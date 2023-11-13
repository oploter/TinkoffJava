package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class Task3 {
    private Task3() {
    }

    private static final DateParser DATE_PARSER =
            new ISODashParser(
                    new ISOSlashParser(
                            new TomorrowTodayYesterdayParser(
                                    new DaysAgoParser(null)
                            )
                    )
            );

    public static Optional<LocalDate> parseDate(String string) {
        if (string == null) {
            throw new IllegalArgumentException("string is null");
        }
        return DATE_PARSER.parseDate(string);
    }
}
