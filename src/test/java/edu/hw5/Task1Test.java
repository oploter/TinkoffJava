package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.format.DateTimeParseException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class Task1Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task1.averageSpentTime(new String[]{
                "2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"
        })).isEqualTo(Duration.parse("PT3H40M")); // 3 hours 40 minutes


        assertThat(Task1.averageSpentTime(new String[]{
                "2023-11-09, 10:10 - 2023-11-09, 12:30",
                "2023-11-09, 09:09 - 2023-11-09, 14:53",
                "2023-11-09, 13:13 - 2023-11-09, 13:25",
                "2023-11-09, 15:52 - 2023-11-09, 23:59",
                "2023-11-09, 18:01 - 2023-11-09, 21:32",
                "2023-11-09, 22:05 - 2023-11-10, 03:00",
                "2023-11-09, 18:10 - 2023-11-10, 06:03",
                "2023-11-09, 16:17 - 2023-11-09, 19:08",
                "2023-11-09, 21:43 - 2023-11-09, 23:41",
                "2023-11-09, 23:37 - 2023-11-10, 05:56"
        })).isEqualTo(Duration.parse("PT4H47M"));

        assertThat(Task1.averageSpentTime(new String[]{
                "2023-11-09, 10:10 - 2023-11-09, 12:30",
                "2023-11-09, 09:09 - 2023-11-09, 14:53",
                "2023-11-09, 13:13 - 2023-11-09, 13:25",
                "2023-11-09, 15:52 - 2023-11-09, 23:59",
                "2023-11-09, 18:01 - 2023-11-09, 21:32",
                "2023-11-09, 22:05 - 2023-11-10, 03:00",
                "2023-11-09, 18:10 - 2023-11-10, 06:03",
                "2023-11-09, 16:17 - 2023-11-09, 19:08",
                "2023-11-09, 21:43 - 2023-11-09, 23:41",
                "2023-11-09, 23:37 - 2023-11-10, 05:56"
        })).isEqualTo(Duration.parse("PT4H47M"));

        assertThat(Task1.averageSpentTime(new String[]{
                "1932-01-02, 12:00 - 1932-01-02, 12:51",
                "1932-01-02, 13:31 - 1932-01-02, 15:07",
                "1932-01-02, 18:01 - 1932-01-02, 18:22",
                "1932-01-02, 20:03 - 1932-01-02, 23:42",
                "1932-01-02, 18:09 - 1932-01-02, 21:53",
                "1932-01-02, 05:32 - 1932-01-02, 05:49",
                "1932-01-02, 14:00 - 1932-01-02, 15:02",
                "1932-01-02, 14:00 - 1932-01-02, 15:02",
                "1932-01-02, 20:32 - 1932-01-02, 20:59",
                "1932-01-02, 18:44 - 1932-01-02, 18:57",
                "1932-01-02, 02:03 - 1932-01-02, 02:56"
        })).isCloseTo(Duration.parse("PT1H16M49.0909S"), Duration.ofMillis(1)); // 845/11 minutes

        assertThat(Task1.averageSpentTime(new String[]{
                "0911-03-02, 12:00 - 0911-03-02, 12:51",
                "0911-03-02, 14:45 - 0911-03-02, 16:07"
        })).isEqualTo(Duration.parse("PT1H6M30S"));
    }

    @Test
    @DisplayName("Invalid parameters")
    void testInvalid() {
        assertThatThrownBy(() -> Task1.averageSpentTime(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("clientTimes is null");

        assertThatThrownBy(() -> Task1.averageSpentTime(new String[]{
                "2023-11-09, 20:20 - 2023-11-09, 19:30", // 20:20 > 19:30
                "2022-10-10, 12:20 - 2022-10-12, 19:30",
        })).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Contains client with negative duration");

        assertThatThrownBy(() -> Task1.averageSpentTime(new String[]{
                "2023-11-09, 19:00 - 2023-11-09, 23:59",
                "2023-13-01, 10:00 - 2023-13-02, 00:00" // invalid month: 13
        })).isInstanceOf(DateTimeParseException.class);

        assertThatThrownBy(() -> Task1.averageSpentTime(new String[]{
                "2022-03-12+20:20 - 2022-03-12+23:50",
                "2022-04-01+21:30 - 2022-04-02+01:20"
        })).isInstanceOf(DateTimeParseException.class);

    }
}
