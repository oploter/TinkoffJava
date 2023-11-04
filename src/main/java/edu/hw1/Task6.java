package edu.hw1;


import java.util.Arrays;

public class Task6 {
    private static final int BASE = 10;
    private static final int MIN_APPROPRIATE_VAL = 1000;
    private static final int MAX_APPROPRIATE_VAL = 9998;
    private static final int KAPREKARS_CONSTANT = 6174;
    private static final int DIGIT_COUNT = 4;
    private static final int INVALID_NUMBER = 1111;
    private static final int MAX_NUMBER_OF_STEPS = 7;

    private Task6() {
    } // for suppressing HideUtilityClassConstructor

    private static int intFromDigits(int[] digits) {
        int ans = 0;
        for (int i = DIGIT_COUNT - 1; i >= 0; --i) {
            ans += digits[i];
            ans *= BASE;
        }
        ans /= BASE;
        return ans;
    }

    private static int[] digitsFromInt(int kParam) {
        int k = kParam;
        int[] digits = new int[DIGIT_COUNT];

        for (int i = 0; i < DIGIT_COUNT; ++i) {
            if (k > 0) {
                digits[i] = (k % BASE);
                k /= BASE;
            } else {
                digits[i] = 0;
            }
        }
        return digits;
    }

    private static int[] negateTwoIntArrays(int[] digitsAscending) { // / [1, 2, 3, 4] -> 4321
        int[] digitsDescending = digitsAscending.clone(); // \
        int[] digits = new int[DIGIT_COUNT];

        boolean carry = false;
        for (int i = 0; i < DIGIT_COUNT; ++i) {
            if (carry) {
                if (digitsAscending[i] > 0) {
                    carry = false;
                }
                digitsAscending[i] += (digitsAscending[i] == 0 ? BASE - 1 : -1); // BASE - 1 == 9
            }
            digits[i] = digitsAscending[i] - digitsDescending[DIGIT_COUNT - 1 - i];
            if (digitsAscending[i] < digitsDescending[DIGIT_COUNT - 1 - i]) {
                digits[i] += BASE;
                carry = true;
            }
        }
        return digits;
    }

    public static int countK(int kParam) {
        int k = kParam;
        if (k < MIN_APPROPRIATE_VAL || MAX_APPROPRIATE_VAL < k
                || ((k % BASE != 0) && (k % (k % BASE)) == 0 && (k / (k % BASE)) == INVALID_NUMBER)) {
            return -1;
        }
        int stepsCounter = 0;
        int[] digits = digitsFromInt(k);
        while (k != KAPREKARS_CONSTANT) {
            int[] digitsAscending = digits;
            Arrays.sort(digitsAscending);
            digits = negateTwoIntArrays(digitsAscending);
            k = intFromDigits(digits);
            ++stepsCounter;
            if (stepsCounter > MAX_NUMBER_OF_STEPS) {
                return -1;
            }
        }
        return stepsCounter;
    }
}
