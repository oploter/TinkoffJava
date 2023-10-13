package edu.hw1;

public class Task4 {
    private Task4() {
    } // for suppressing HideUtilityClassConstructor

    public static String fixString(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i += 2) {
            stringBuilder.append(s.charAt(i + 1));
            stringBuilder.append(s.charAt(i));
        }
        if (s.length() % 2 == 1) {
            stringBuilder.append(s.charAt(s.length() - 1));
        }
        return stringBuilder.toString();
    }
}
