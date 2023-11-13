package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

class ISODashParser extends DateParser {
    ISODashParser(DateParser nextParser) {
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
