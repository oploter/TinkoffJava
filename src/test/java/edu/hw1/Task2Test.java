package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Works for all numbers up to 6 digits")
    void AllNumbersUpTo6Digits() {
        long startValue = 1;
        for (int numOfDigits = 1; numOfDigits <= 6; ++numOfDigits) {
            for (long num = startValue; num < (startValue * 10); ++num) {
                assertThat(Task2.countDigits(num)).isEqualTo(numOfDigits);
                assertThat(Task2.countDigits(-1 * num)).isEqualTo(numOfDigits);
            }
            startValue *= 10;
        }
    }

    @Test
    @DisplayName("Works for 0")
    void CheckZero() {
        assertThat(Task2.countDigits(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("Works for big numbers")
    void CheckBigNumbers() {
        assertThat(Task2.countDigits(1234567891011L)).isEqualTo(13);
        assertThat(Task2.countDigits(0000000000000L)).isEqualTo(1);
        assertThat(Task2.countDigits(123456789123456789L)).isEqualTo(18);
    }


}
