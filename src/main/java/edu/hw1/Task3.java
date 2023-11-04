package edu.hw1;

public class Task3 {
    private Task3() {
    } // for suppressing HideUtilityClassConstructor

    private static int min(int[] arr) {
        int minVal = Integer.MAX_VALUE;
        for (int val : arr) {
            minVal = Math.min(minVal, val);
        }
        return minVal;
    }

    private static int max(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        for (int val : arr) {
            maxVal = Math.max(maxVal, val);
        }
        return maxVal;
    }

    public static boolean isNestable(int[] arr1, int[] arr2) { // [a1, b1] < [a2, b2]
        if (arr1 == null || arr2 == null) {
            return false;
        }
        return (arr1.length == 0 || ((min(arr1) > min(arr2)) && (max(arr1) < max(arr2))));
    }
    // arr1 == arr2
}
