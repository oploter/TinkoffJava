package edu.hw1;

public class Task8 {
    private Task8() {
    }

    private static final int BOARD_SIZE = 8;

    private static void checkPositionsUnderAttack(byte[] nextLine, byte[] pastNextLine, int col) {
        if (col - 1 >= 0) {
            pastNextLine[col - 1] = 1;
        }
        if (col - 2 >= 0) {
            nextLine[col - 2] = 1;
        }
        if (col + 1 < BOARD_SIZE) {
            pastNextLine[col + 1] = 1;
        }
        if (col + 2 < BOARD_SIZE) {
            nextLine[col + 2] = 1;
        }
    }

    public static boolean knightBoardCapture(byte[][] board) {
        if (board.length != BOARD_SIZE || board[0].length != BOARD_SIZE) {
            return false;
        }
        byte[] currLine = new byte[BOARD_SIZE];
        byte[] nextLine = new byte[BOARD_SIZE];
        byte[] pastNextLine = new byte[BOARD_SIZE];
        boolean foundAttack = false;
        for (int row = 0; row < BOARD_SIZE; ++row) {
            for (int col = 0; col < BOARD_SIZE; ++col) {
                int cell = board[row][col];
                if (cell == 1) {
                    if (currLine[col] == 1) {
                        foundAttack = true;
                        break;
                    }
                    checkPositionsUnderAttack(nextLine, pastNextLine, col);
                } else if (cell != 0) { // cell value not in {0, 1} -> board is invalid
                    return false;
                }
            }
            currLine = nextLine;
            nextLine = pastNextLine;
            pastNextLine = new byte[BOARD_SIZE];
            if (foundAttack) {
                break;
            }
        }
        return !foundAttack;
    }
}
