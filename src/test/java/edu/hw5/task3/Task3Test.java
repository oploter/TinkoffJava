package edu.hw5.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Test 2020-12-10 parser")
    void testISODashParser() {
        assertThat(Task3.parseDate("2022-12-10")).hasValue(LocalDate.of(2022, 12, 10));
        assertThat(Task3.parseDate("2023-1-1")).hasValue(LocalDate.of(2023, 1, 1));
        assertThat(Task3.parseDate("2023-1-31")).hasValue(LocalDate.of(2023, 1, 31));
        assertThat(Task3.parseDate("2023-01-1")).hasValue(LocalDate.of(2023, 1, 1));
        assertThat(Task3.parseDate("2023-1-01")).hasValue(LocalDate.of(2023, 1, 1));
        assertThat(Task3.parseDate("2023-01-01")).hasValue(LocalDate.of(2023, 1, 1));
        assertThat(Task3.parseDate("2023-11-21")).hasValue(LocalDate.of(2023, 11, 21));

        assertThat(Task3.parseDate("988-7-15")).hasValue(LocalDate.of(988, 7, 15));
        assertThat(Task3.parseDate("988-07-15")).hasValue(LocalDate.of(988, 7, 15));
        assertThat(Task3.parseDate("988-7-05")).hasValue(LocalDate.of(988, 7, 5));
        assertThat(Task3.parseDate("988-07-05")).hasValue(LocalDate.of(988, 7, 5));

        assertThat(Task3.parseDate("2001-13-15")).isEmpty();
        assertThat(Task3.parseDate("988-7-35")).isEmpty();
    }

    @Test
    @DisplayName("Test 1/3/1996 parser")
    void testISOSlashParser() {
        assertThat(Task3.parseDate("1/3/1976")).hasValue(LocalDate.of(1976, 3, 1));
        assertThat(Task3.parseDate("01/3/1976")).hasValue(LocalDate.of(1976, 3, 1));
        assertThat(Task3.parseDate("01/03/1976")).hasValue(LocalDate.of(1976, 3, 1));
        assertThat(Task3.parseDate("1/03/1976")).hasValue(LocalDate.of(1976, 3, 1));
        assertThat(Task3.parseDate("11/12/2003")).hasValue(LocalDate.of(2003, 12, 11));
        assertThat(Task3.parseDate("15/7/998")).hasValue(LocalDate.of(998, 7, 15));
        assertThat(Task3.parseDate("15/07/998")).hasValue(LocalDate.of(998, 7, 15));
        assertThat(Task3.parseDate("05/07/998")).hasValue(LocalDate.of(998, 7, 5));
        assertThat(Task3.parseDate("5/07/998")).hasValue(LocalDate.of(998, 7, 5));

        assertThat(Task3.parseDate("32/3/1976")).isEmpty();
        assertThat(Task3.parseDate("13/23/999")).isEmpty();

    }

    @Test
    @DisplayName("Test 1/3/20 parser")
    void testISOSlashYYParser() {
        assertThat(Task3.parseDate("1/3/20")).hasValue(LocalDate.of(2020, 3, 1));
        assertThat(Task3.parseDate("01/3/98")).hasValue(LocalDate.of(2098, 3, 1));
        assertThat(Task3.parseDate("01/3/43")).hasValue(LocalDate.of(2043, 3, 1));
    }

    @Test
    @DisplayName("Test tomorrow/today/yesterday parser")
    void testTomorrowTodayYesterdayParser() {
        assertThat(Task3.parseDate("today")).hasValue(LocalDate.now());
        assertThat(Task3.parseDate("YESTERDAY")).hasValue(LocalDate.now().minusDays(1));
        assertThat(Task3.parseDate("ToMoRrOw")).hasValue(LocalDate.now().plusDays(1));
    }

    @Test
    @DisplayName("Test days ago parser")
    void testDaysAgoParser() {
        for (int d = 0; d <= 1000; ++d) {
            assertThat(Task3.parseDate(d + " day ago")).hasValue(LocalDate.now().minusDays(d));
            assertThat(Task3.parseDate(d + " days ago")).hasValue(LocalDate.now().minusDays(d));
            assertThat(Task3.parseDate(d + " dayyys ago")).isEmpty();
        }

        assertThat(Task3.parseDate("-12 days ago")).isEmpty();
    }
}
