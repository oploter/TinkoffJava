package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static List<LocalDate> fridaysTheThirteenth(Year year) {
        List<LocalDate> fridaysTheThirteenthDates = new ArrayList<>();
        for (int monthId = 1; monthId <= 12; ++monthId) {
            LocalDate dayThirteenth = year.atMonth(monthId).atDay(13);
            if (dayThirteenth.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                fridaysTheThirteenthDates.add(dayThirteenth);
            }
        }
        return fridaysTheThirteenthDates;
    }

    public static LocalDate nextFridayThirteen(LocalDate currDate) {
        if (currDate == null) {
            throw new IllegalArgumentException("currDate is null");
        }
        LocalDate newDate;
        if (currDate.getDayOfMonth() < 13) {
            newDate = currDate;
        } else {
            newDate = (LocalDate) TemporalAdjusters.firstDayOfNextMonth().adjustInto(currDate);
        }
        newDate = (LocalDate) TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY).adjustInto(newDate);

        while (newDate.getDayOfMonth() != 13) {
            newDate = (LocalDate) TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY)
                    .adjustInto(TemporalAdjusters.firstDayOfNextMonth().adjustInto(newDate));
        }
        return newDate;
    }
}
