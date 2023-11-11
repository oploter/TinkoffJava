package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Task7Test {
    @Test
    @DisplayName("Test at least 3 symbols, third symbol is zero")
    void testFristFunction() {
        for (int num = 0; num <= (1 << 20); ++num) { // testing all numbers in [0, 2^30]
            String binRepresentation = Integer.toBinaryString(num);
            boolean isValid = Task7.atLeast3SymbolsAndThirdIsZero(binRepresentation);
            if (binRepresentation.length() < 3) {
                assertThat(isValid).isFalse();
            } else {
                assertThat(isValid).isEqualTo((binRepresentation.charAt(2) == '0'));
            }
        }

        String[] validStrings = new String[]{
                "000",
                "00000",
                "00000001",
                "11011111",
                "110100001",
                "110",
                "10001",
                "100110",
                "1000101"
        };
        for (String validString : validStrings) {
            assertThat(Task7.atLeast3SymbolsAndThirdIsZero(validString)).isTrue();
        }

        String[] invalidStrings = new String[]{
                "0",
                "1",
                "00",
                "01",
                "10",
                "11",
                "001",
                "101",
                "111",
                "10111",
                "001000000",
                "01111011",
                "11111111",
                "101010101",
                "220222222",
                "30033303003",
                "00000003",
                "aa0aaaaaa",
                "ds0sdlmdklf",
                "a",
                "32",
                "0000000001292",
                "\n\n0000000",
                "\r00000000",
                "(00000)"
        };
        for (String invalidString : invalidStrings) {
            assertThat(Task7.atLeast3SymbolsAndThirdIsZero(invalidString)).isFalse();
        }

        assertThatThrownBy(() -> Task7.atLeast3SymbolsAndThirdIsZero(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Test starts and ends with the same symbol")
    void testSameHeadAndTail() {
        for (int n = 0; n <= (1 << 15); ++n) {
            String s = Integer.toBinaryString(n);
            assertThat(Task7.startsAndEndsWithTheSameSymbol("0" + s + "0")).isTrue();
            assertThat(Task7.startsAndEndsWithTheSameSymbol("1" + s + "1")).isTrue();
        }
        assertThat(Task7.startsAndEndsWithTheSameSymbol("0")).isTrue();
        assertThat(Task7.startsAndEndsWithTheSameSymbol("1")).isTrue();
        assertThat(Task7.startsAndEndsWithTheSameSymbol("00")).isTrue();
        assertThat(Task7.startsAndEndsWithTheSameSymbol("11")).isTrue();

        String[] invalidStrings = new String[]{
                "012230",
                "10\n1",
                "0 0",
                "04540",
                "0AAKLM0",
                "0\n\n\n\n0",
                "1\n1",
                "1\r1",
                "\\0\\",
                "kjsdn",
                "0skdflsdkm0",
                "0 0sajkn"
        };
        for (String invalidString : invalidStrings) {
            assertThat(Task7.startsAndEndsWithTheSameSymbol(invalidString)).isFalse();
        }

        assertThatThrownBy(() -> Task7.boundedLength(null)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("Test bounded binary string")
    void testBoundedFunction() {
        Stack<String> validStrings = new Stack<>();
        validStrings.push("");
        for (int currL = 1; currL <= 10; ++currL) { // will check all binary strings with length [0, 10)
            while (!validStrings.empty() && validStrings.peek().length() < currL) {
                String s = validStrings.pop();
                boolean isValid = Task7.boundedLength(s);
                assertThat(isValid).isEqualTo((1 <= s.length() && s.length() <= 3));
                validStrings.push(s + "0");
                validStrings.push(s + "1");
            }
        }

        String[] invalidStrings = new String[]{
                "100001",
                "",
                "00010",
                "0000",
                "12",
                "232",
                "22",
                "\n\n00",
                "\n\n0",
                "(00",
                "fda",
                "34J",
                "10233dk",
                "}10",
                "09",
                "009",
                "\r\\0",
                " 0 ",
                " 0",
                "  1"
        };
        for (String invalidString : invalidStrings) {
            assertThat(Task7.boundedLength(invalidString)).isFalse();
        }

        assertThatThrownBy(() -> Task7.boundedLength(null)).isInstanceOf(IllegalArgumentException.class);

    }

}
