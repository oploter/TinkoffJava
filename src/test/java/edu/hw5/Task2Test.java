package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Task2Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Map<Integer, List<Integer>> monthsByYear = Map.ofEntries(
                Map.entry(1900, List.of(4, 7)),
                Map.entry(1905, List.of(1, 10)),
                Map.entry(1909, List.of(8)),
                Map.entry(1910, List.of(5)),
                Map.entry(1915, List.of(8)),
                Map.entry(1920, List.of(2, 8)),
                Map.entry(1925, List.of(2, 3, 11)),
                Map.entry(1930, List.of(6)),
                Map.entry(1935, List.of(9, 12)),
                Map.entry(1940, List.of(9, 12)),
                Map.entry(1945, List.of(4, 7)),
                Map.entry(1950, List.of(1, 10)),
                Map.entry(1955, List.of(5)),
                Map.entry(1960, List.of(5)),
                Map.entry(1965, List.of(8)),
                Map.entry(1970, List.of(2, 3, 11)),
                Map.entry(1975, List.of(6)),
                Map.entry(1980, List.of(6)),
                Map.entry(1985, List.of(9, 12)),
                Map.entry(1990, List.of(4, 7)),
                Map.entry(1995, List.of(1, 10)),
                Map.entry(2000, List.of(10)),
                Map.entry(2005, List.of(5)),
                Map.entry(2010, List.of(8)),
                Map.entry(2015, List.of(2, 3, 11)),
                Map.entry(2020, List.of(3, 11)),
                Map.entry(2025, List.of(6))
        );

        for (Integer year : monthsByYear.keySet()) {
            assertThat(Task2.fridaysTheThirteenth(Year.of(year)))
                    .isEqualTo(monthsByYear.get(year).stream()
                            .map(i -> LocalDate.of(year, i, 13)).collect(Collectors.toList()));
        }
    }

    @Test
    @DisplayName("Next friday the 13th. General Function")
    void nextFridayGeneralFunction() {
        assertThatThrownBy(() -> Task2.nextFridayThirteen(null)).isInstanceOf(IllegalArgumentException.class);

        assertThat(Task2.nextFridayThirteen(LocalDate.of(1925, 11, 2))).isEqualTo(LocalDate.of(1925, 11, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(1925, 6, 10))).isEqualTo(LocalDate.of(1925, 11, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(1925, 11, 13))).isEqualTo(LocalDate.of(1926, 8, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2010, 6, 25))).isEqualTo(LocalDate.of(2010, 8, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2001, 5, 17))).isEqualTo(LocalDate.of(2001, 7, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2001, 2, 28))).isEqualTo(LocalDate.of(2001, 4, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2017, 3, 31))).isEqualTo(LocalDate.of(2017, 10, 13));
    }

    @Test
    @DisplayName("Next friday the 13th is next year")
    void testNextYear() {
        for (int monthId = 9; monthId <= 12; ++monthId) {
            for (int dayId = 1; dayId <= 30 + (monthId % 2 != 0 ? 0 : 1); ++dayId) {
                assertThat(Task2.nextFridayThirteen(LocalDate.of(2022, monthId, dayId)))
                        .isEqualTo(LocalDate.of(2023, 1, 13));
            }
        }
    }

    @Test
    @DisplayName("Firday the 13th is tomorrow")
    void testFridayTomorrow() {
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2015, 2, 12)))
                .isEqualTo(LocalDate.of(2015, 2, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2015, 3, 12)))
                .isEqualTo(LocalDate.of(2015, 3, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2015, 11, 12)))
                .isEqualTo(LocalDate.of(2015, 11, 13));
    }

    @Test
    @DisplayName("Current date if friday the 13th")
    void testCurrentFriday() {
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2004, 8, 13)))
                .isEqualTo(LocalDate.of(2005, 5, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2005, 5, 13)))
                .isEqualTo(LocalDate.of(2006, 1, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2006, 1, 13)))
                .isEqualTo(LocalDate.of(2006, 10, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2006, 10, 13)))
                .isEqualTo(LocalDate.of(2007, 4, 13));
    }

    @Test
    @DisplayName("Friday the 13th is in current month")
    void testCurrentMonth() {
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2010, 8, 1)))
                .isEqualTo(LocalDate.of(2010, 8, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2010, 8, 10)))
                .isEqualTo(LocalDate.of(2010, 8, 13));
        assertThat(Task2.nextFridayThirteen(LocalDate.of(2010, 8, 12)))
                .isEqualTo(LocalDate.of(2010, 8, 13));
    }
}
