package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task1 {
    private Task1() {
    }

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd, HH:mm";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    private static final int NUM_OF_SPACES_BETWEEN_DATES = 3;

    public static Duration averageSpentTime(String[] clientsTimes) {
        if (clientsTimes == null) {
            throw new IllegalArgumentException("clientTimes is null");
        }
        Duration averageDuration = Duration.ZERO;
        int clientCnt = 1;
        for (String clientTime : clientsTimes) {
            Duration duration = Duration.between(
                    LocalDateTime.parse(clientTime.substring(0, DATE_TIME_FORMAT.length()), FORMATTER),
                    LocalDateTime.parse(clientTime.substring(DATE_TIME_FORMAT.length() + NUM_OF_SPACES_BETWEEN_DATES),
                            FORMATTER)
            );
            if (duration.compareTo(Duration.ZERO) < 0) {
                throw new IllegalArgumentException("Contains client with negative duration");
            }
            averageDuration = averageDuration.plus(duration.minus(averageDuration).dividedBy(clientCnt));
            ++clientCnt;
        }
        return averageDuration;
    }
}
