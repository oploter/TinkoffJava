package edu.hw1;

public class Task2 {
    private Task2() {
    } // for suppressing HideUtilityClassConstructor

    private static final int TEN = 10;

    public static int countDigits(long number) {
        int digitCnt = 1;
        long localNumber = Math.abs(number);
        while (localNumber >= TEN) {
            localNumber /= TEN;
            ++digitCnt;
        }
        return digitCnt;
    }
}
