package edu.hw1;

public class Task5 {
    private static final int BASE = 10;

    private Task5() {
    } // for suppressing HideUtilityClassConstructor

    private static boolean isPalindrome(byte[] digits) {
        for (int i = 0; 2 * i < digits.length; ++i) {
            if (digits[i] != digits[digits.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeDescendantPrivate(byte[] digitsParam) {
        byte[] digits = digitsParam;
        while (digits.length > 1) {
            if (isPalindrome(digits)) {
                return true;
            }

            int newDigitsSize = 0;
            for (int i = 0; 2 * i < digits.length - 1; ++i) {
                newDigitsSize += (digits[2 * i] + digits[2 * i + 1] >= BASE ? 2 : 1);
            }
            if (digits.length % 2 == 1) {
                ++newDigitsSize;
            }


            byte[] newDigits = new byte[newDigitsSize];
            int pos = 0;
            for (int i = 0; 2 * i < digits.length - 1; ++i) {
                byte newDigit = (byte) (digits[2 * i] + digits[2 * i + 1]);
                if (newDigit >= BASE) {
                    newDigits[pos] = (byte) (newDigit / BASE);
                    ++pos;
                    newDigits[pos] = (byte) (newDigit % BASE);
                } else {
                    newDigits[pos] = newDigit;
                }
                ++pos;
            }
            if (digits.length % 2 == 1) {
                newDigits[newDigits.length - 1] = digits[digits.length - 1];
            }

            digits = newDigits;
        }
        return false;
    }

    private static int countDigits(long numberParam) {
        long number = numberParam;
        int digitCnt = 0;
        while (number > 0) {
            ++digitCnt;
            number /= BASE;
        }
        return digitCnt;
    }

    public static boolean isPalindromeDescendant(int numberParam) {
        int number = numberParam;
        if (number < BASE) { // Cannot call function for negative numbers or numbers, containing 1 digit
            return false;
        }
        byte[] digits = new byte[countDigits(number)];
        for (int i = digits.length - 1; i >= 0; --i) {
            digits[i] = (byte) (number % BASE);
            number /= BASE;
        }
        return isPalindromeDescendantPrivate(digits);
    }
}
