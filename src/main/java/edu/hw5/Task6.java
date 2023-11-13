package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    private Task6() {
    }

    public static boolean isSubstring(String str, String substr) {
        if (str == null || substr == null) {
            throw new IllegalArgumentException("Str/Substr is null");
        }
        if (substr.equals("")) {
            return true;
        }
        return Pattern.matches(".*" + Pattern.quote(substr) + ".*", str);
    }
}