package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

class ISOSlashParser extends DateParser {
    ISOSlashParser(DateParser nextParser) {
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
