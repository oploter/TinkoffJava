package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

class TomorrowTodayYesterdayParser extends DateParser {
    private static final Map<String, Integer> DAYS_DELTA = Map.of(
            "tomorrow", 1,
            "today", 0,
            "yesterday", -1
    );

    TomorrowTodayYesterdayParser(DateParser nextParser) {
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
