package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Test all in [1, 3999]")
    void test() {
        /*
        I am checking my function with file, containing correct answers.
         */
        try (Scanner scanner = new Scanner(new File("src/test/java/edu/hw3/Task4RomanNumbers.txt"))) {
            int number = 1;
            while (number < 4000) {
                assertThat(Task4.convertToRoman(number)).isEqualTo(scanner.nextLine());
                ++number;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test num < 0 || 3999 < num")
    void testBad() {
        for (int i = -100; i <= 0; ++i) {
            assertThat(Task4.convertToRoman(i)).isEqualTo(null);
        }

        for (int i = 4000; i < 5000; ++i) {
            assertThat(Task4.convertToRoman(i)).isEqualTo(null);
        }


    }
}
