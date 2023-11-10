package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Optional;

class ISODashParser extends DateParser {
    public ISODashParser(DateParser nextParser) {
        super(nextParser);
    }

    public Optional<LocalDate> parseDate(String string) {
        try {
            LocalDate date = LocalDate.parse(string, DateTimeFormatter.ofPattern("[uuuu][uuu][uu]-M-d"));
            return Optional.ofNullable(date);
        } catch (DateTimeParseException e) {
            return nextParser != null ? nextParser.parseDate(string) : Optional.empty();
        }
    }
}

class ISOSlashParser extends DateParser {
    public ISOSlashParser(DateParser nextParser) {
        super(nextParser);
    }

    public Optional<LocalDate> parseDate(String string) {
        try {
            LocalDate date = LocalDate.parse(string, DateTimeFormatter.ofPattern("d/M/[uuuu][uuu][uu]"));
            return Optional.ofNullable(date);
        } catch (DateTimeParseException e) {
            return nextParser != null ? nextParser.parseDate(string) : Optional.empty();
        }
    }
}

class TomorrowTodayYesterdayParser extends DateParser {
    private static final Map<String, Integer> DAYS_DELTA = Map.of(
            "tomorrow", 1,
            "today", 0,
            "yesterday", -1
    );

    public TomorrowTodayYesterdayParser(DateParser nextParser) {
        super(nextParser);
    }

    public Optional<LocalDate> parseDate(String string) {
        Integer dayDelta = DAYS_DELTA.get(string.toLowerCase());
        if (dayDelta != null) {
            return Optional.of(LocalDate.now().plusDays(dayDelta));
        } else {
            return nextParser != null ? nextParser.parseDate(string) : Optional.empty();
        }
    }
}

class DaysAgoParser extends DateParser {
    public DaysAgoParser(DateParser nextParser) {
        super(nextParser);
    }

    public Optional<LocalDate> parseDate(String string) {
        if (string.matches("\\d+ days? ago")) { // try pasing float
            int daysAgo = Integer.parseInt(string.split(" ", 2)[0]);
            return daysAgo >= 0
                    ? Optional.of(LocalDate.now().minusDays(daysAgo))
                    : Optional.empty();
        }
        return nextParser != null ? nextParser.parseDate(string) : Optional.empty();
    }
}


public class Task3 {
    private Task3() {
    }

    private static final DateParser dateParser =
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
        return dateParser.parseDate(string);
    }
}
