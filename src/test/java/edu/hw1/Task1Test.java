package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("If null, return -1")
    void checkNull() {
        assertThat(Task1.minutesToSeconds(null)).isEqualTo(-1);
    }

    @Test
    @DisplayName("If empty string, return -1")
    void EmptyString() {
        assertThat(Task1.minutesToSeconds("")).isEqualTo(-1);
    }

    @Test
    @DisplayName("string doesn't contain any numbers, return -1")
    void NoNumbersContained() {
        assertThat(Task1.minutesToSeconds("hello")).isEqualTo(-1);
    }

    @Test
    @DisplayName("Time in right format and spaces before it")
    void RightTimeSpacesBefore() {
        assertThat(Task1.minutesToSeconds("    10:25")).isEqualTo(625);
    }

    @Test
    @DisplayName("Right time format and spaces before and after colon symbol")
    void RightTimeSpacesBeforeAfter() {
        assertThat(Task1.minutesToSeconds("      12 : 3")).isEqualTo(723);
    }

    @Test
    @DisplayName("If another symbol instead of colon, return -1")
    void AnotherSymbolInsteadOfColon() {
        assertThat(Task1.minutesToSeconds("     10.30  ")).isEqualTo(-1);
    }

    @Test
    @DisplayName("Leading zeroes don't matter")
    void LeadingZeroesDoNotMatter() {
        assertThat(Task1.minutesToSeconds("0001:00023")).isEqualTo(83);
        assertThat(Task1.minutesToSeconds("  021:000")).isEqualTo(1260);
        assertThat(Task1.minutesToSeconds("  05:05  ")).isEqualTo(Task1.minutesToSeconds("5:5"));
    }

    @Test
    @DisplayName("If negative minutes/seconds, return -1")
    void NegativeMinutesNotAllowed() {
        assertThat(Task1.minutesToSeconds("-12:23")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds(" -1:-1")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("12:-12")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds(" 101:-12")).isEqualTo(-1);
    }

    @Test
    @DisplayName("If string contains not only time, return -1")
    void ContainsNotOnlyTime() {
        assertThat(Task1.minutesToSeconds("a10:23")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("bb   9:12 ")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("bb   9:1a2sa aaa")).isEqualTo(-1);
    }

    @Test
    @DisplayName("General functionality works")
    void GeneralFunctionalityWorks() {
        for (int minutes = 0; minutes <= 1000; ++minutes) {
            for (int seconds = 0; seconds < 60; ++seconds) {
                assertThat(Task1.minutesToSeconds(minutes + ":" + seconds)).isEqualTo(60 * minutes + seconds);
            }
        }
    }

    @Test
    @DisplayName("If seconds greater 59, return -1")
    void SecondsCannotBeMore59() {
        assertThat(Task1.minutesToSeconds("12:61")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("1:60")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("10:59")).isEqualTo(659);
    }

    @Test
    @DisplayName("Test for big lengths")
    void LongVideos() {
        assertThat(Task1.minutesToSeconds("33333333:59")).isEqualTo(33333333L * 60 + 59); // 2 billion seconds ~ 64 years
    }
}
