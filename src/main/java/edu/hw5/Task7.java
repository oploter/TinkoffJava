package edu.hw5;

public class Task7 {
    private Task7() {
    }

    private static final String ERROR_MSG = "binStr is null";

    public static boolean atLeast3SymbolsAndThirdIsZero(String binStr) {
        if (binStr == null) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
        return binStr.matches("^[01][01]0[01]*$");
    }

    public static boolean startsAndEndsWithTheSameSymbol(String binStr) {
        if (binStr == null) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
        return binStr.matches("^([01])([01]*\\1)?$");
    }

    public static boolean boundedLength(String binStr) {
        if (binStr == null) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
        return binStr.matches("^[01]{1,3}$");
    }
}
