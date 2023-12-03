//import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;
//import java.io.IOException;
import java.lang.InterruptedException;
//import java.io.BufferedReader;
import java.io.*;
import java.util.concurrent.*;
import java.util.*;

class KnockKnockProtocol{
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;
 
    private static final int NUMJOKES = 5;
 
    private int state = WAITING;
    private int currentJoke = 0;
 
    private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
    private String[] answers = { "Turnip the heat, it's cold in here!",
                                 "I didn't know you could yodel!",
                                 "Bless you!",
                                 "Is there an owl in here?",
                                 "Is there an echo in here?" };
                                 
    public String processInput(String theInput){
        String theOutput = null;
        if (state == WAITING) {
            theOutput = "Knock! Knock!";
            state = SENTKNOCKKNOCK;
        } else if (state == SENTKNOCKKNOCK) {
            if (theInput.equalsIgnoreCase("Who's there?")) {
                theOutput = clues[currentJoke];
                state = SENTCLUE;
            } else {
                theOutput = "You're supposed to say \"Who's there?\"! " +
                "Try again. Knock! Knock!";
            }
        } else if (state == SENTCLUE) {
            if (theInput.equalsIgnoreCase(clues[currentJoke] + " who?")) {
                theOutput = answers[currentJoke] + " Want another? (y/n)";
                state = ANOTHER;
            } else {
                theOutput = "You're supposed to say \"" + 
                clues[currentJoke] + 
                " who?\"" + 
                "! Try again. Knock! Knock!";
                state = SENTKNOCKKNOCK;
            }
        } else if (state == ANOTHER) {
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = "Knock! Knock!";
                if (currentJoke == (NUMJOKES - 1))
                    currentJoke = 0;
                else
                    currentJoke++;
                state = SENTKNOCKKNOCK;
            } else {
                theOutput = "Bye.";
                state = WAITING;
            }
        }
        return theOutput;
   } 
}


class Server implements Runnable{
    private final ExecutorService threadPool;
    private final int port = 8081;
    private ServerSocket serverSocket;

    public Server(){
        threadPool = Executors.newFixedThreadPool(3);
        try{
            serverSocket = new ServerSocket(port);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try{
            while(true){
                threadPool.submit(new Handler(serverSocket.accept()));
            }
        }catch(IOException e){
            threadPool.shutdown();
        }
    }
}

class Handler implements Runnable{
    private final Socket socket;
    public Handler(Socket socket){
        this.socket = socket;
    }
    
    @Override
    public void run(){
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
            String inputLine, outputLine;
            System.out.println("Server started new dialog on thread " + Thread.currentThread().getName());
            
            KnockKnockProtocol kkp = new KnockKnockProtocol();
            outputLine = kkp.processInput(null);
            out.println(outputLine);
        
            while ((inputLine = in.readLine()) != null) {
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye."))
                    break;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

class Client implements Runnable{
    private String[] phrases = {"Who's there?", "Turnip who?", "n"};
    private String name;
    
    public Client(String name){
        this.name = name;
    }
    
    @Override
    public void run(){
        System.out.println("Client " + name + " started");
        try(Socket socket = new Socket("127.0.0.1", 8081);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            System.out.println("Client " + name + " connected to server");
            int phraseCnt = 0;
            String fromServer, fromUser;
            while((fromServer = in.readLine()) != null){
                System.out.println("Server: " + fromServer);
                if(fromServer.equals("Bye.")){
                    System.out.println("Shuting down");
                    break;
                }
                // fromUser = stdIn.readLine();
                Thread.sleep(1000);
                fromUser = phrases[phraseCnt++];
                if (fromUser != null) {
                    System.out.println("Client " + name + ": " + fromUser);
                    out.println(fromUser);
                }
            }
        }catch(IOException e){
        
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class Main
{
	public static void main(String[] args) {
	    try{
    	    Thread serverThread = new Thread(new Server());
    	    serverThread.start();
    	    Thread.sleep(300);
            List<Thread> clients = new ArrayList<>();
            for(int i = 0; i < 10; ++i){
                Thread client = new Thread(new Client(Integer.toString(i)));
                client.start();
                clients.add(client);
            }
    	    for(Thread client : clients){
                client.join();
            }
            serverThread.join();
	    }catch(InterruptedException e){
	        e.printStackTrace();
	    }
	}
}