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

    private static final int MONTHS_NUM = 12;
    private static final int THIRTEEN_CONST = 13;

    public static List<LocalDate> fridaysTheThirteenth(Year year) {
        List<LocalDate> fridaysTheThirteenthDates = new ArrayList<>();
        for (int monthId = 1; monthId <= MONTHS_NUM; ++monthId) {
            LocalDate dayThirteenth = year.atMonth(monthId).atDay(THIRTEEN_CONST);
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
        if (currDate.getDayOfMonth() < THIRTEEN_CONST) {
            newDate = currDate;
        } else {
            newDate = (LocalDate) TemporalAdjusters.firstDayOfNextMonth().adjustInto(currDate);
        }
        newDate = (LocalDate) TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY).adjustInto(newDate);

        while (newDate.getDayOfMonth() != THIRTEEN_CONST) {
            newDate = (LocalDate) TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY)
                    .adjustInto(TemporalAdjusters.firstDayOfNextMonth().adjustInto(newDate));
        }
        return newDate;
    }
}
