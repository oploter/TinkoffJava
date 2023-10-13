package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int nParam, int shiftParam) {
        int n = nParam;
        int shift = shiftParam;
        if (n <= 0 || shift < 0) {
            return -1;
        }
        String binStr = Integer.toBinaryString(n);
        shift %= binStr.length();
        if (shift == 0) {
            return n;
        }
        String rotatedStr = binStr.substring(shift) + binStr.substring(0, shift);
        return Integer.parseInt(rotatedStr, 2);
    }

    public static int rotateRight(int nParam, int shiftParam) {
        int n = nParam;
        int shift = shiftParam;
        if (n <= 0 || shift < 0) {
            return -1;
        }
        String binStr = Integer.toBinaryString(n);
        shift %= binStr.length();
        if (shift == 0) {
            return n;
        }
        String rotatedStr = binStr.substring(binStr.length() - shift)
                + binStr.substring(0, binStr.length() - shift);
        return Integer.parseInt(rotatedStr, 2);
    }

}
