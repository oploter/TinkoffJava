package edu.hw1;

public class Task1 {
    private Task1() {
    } // for suppressing HideUtilityClassConstructor

    private static final int NUMBER_OF_SECONDS_IN_MINUTE = 60;

    public static long minutesToSeconds(String s) {
        if (s == null) {
            return -1;
        }
        String[] minutesSeconds = s.trim().split(":");
        long minutes;
        long seconds;
        try {
            minutes = Long.parseLong(minutesSeconds[0].trim());
            seconds = Long.parseLong(minutesSeconds[1].trim());
        } catch (NumberFormatException e) {
            return -1;
        }
        if (seconds < 0 || NUMBER_OF_SECONDS_IN_MINUTE <= seconds || minutes < 0) {
            return -1;
        }
        return minutes * NUMBER_OF_SECONDS_IN_MINUTE + seconds;
    }
}
