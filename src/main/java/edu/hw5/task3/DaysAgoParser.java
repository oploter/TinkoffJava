package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

class DaysAgoParser extends DateParser {
    DaysAgoParser(DateParser nextParser) {
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
