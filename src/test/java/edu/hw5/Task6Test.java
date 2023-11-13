package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Test empty substr")
    void testEmpty() {
        assertThat(Task6.isSubstring("", "")).isTrue();
        assertThat(Task6.isSubstring("ajskd", "")).isTrue();
        assertThat(Task6.isSubstring("\n", "")).isTrue();
        assertThat(Task6.isSubstring("1234", "")).isTrue();
    }

    @Test
    @DisplayName("Test general function")
    void testGeneral() {
        String s = "CheckWord;12345678910";
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i + 1; j <= s.length(); ++j) {
                assertThat(Task6.isSubstring(s, s.substring(i, j))).isTrue();
            }
        }

        assertThat(Task6.isSubstring("\n", "\n")).isTrue();


    }

    @Test
    @DisplayName("substr contains regex")
    void testContainRegex() {
        assertThat(Task6.isSubstring("\\n\\n", "\\n")).isTrue();

        assertThat(Task6.isSubstring("\\d{2,3}", "\\d{1}")).isFalse();
        assertThat(Task6.isSubstring("\\d{2,3}", "\\d")).isTrue();
        assertThat(Task6.isSubstring("\\d{2,3}", "\\d{2")).isTrue();

        assertThat(Task6.isSubstring("hello.*hello.*", ".*")).isTrue();
        assertThat(Task6.isSubstring("hello.*hello.*", "h.*")).isFalse();

    }
}
