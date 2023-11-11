package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    private Task4() {
    }

    private static final Pattern PATTERN = Pattern.compile("[~!@#$%^&*|]");

    public static boolean isCorrect(String password) {
        return PATTERN.matcher(password).find();
    }
}
