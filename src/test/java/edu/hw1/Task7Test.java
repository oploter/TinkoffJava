package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Test")
    void Test1() {
        assertThat(Task7.rotateRight(8, 1)).isEqualTo(4);
        assertThat(Task7.rotateLeft(16, 1)).isEqualTo(1);
        assertThat(Task7.rotateLeft(17, 2)).isEqualTo(6);
    }


    @Test
    @DisplayName("Only 1s")
    void Test2() {
        for (int bitCnt = 1; bitCnt < 31; ++bitCnt) {
            int n = (1 << (bitCnt + 1)) - 1;
            for (int shift = 0; shift < 100; ++shift) {
                assertThat(Task7.rotateLeft(n, shift)).isEqualTo(n);
                assertThat(Task7.rotateRight(n, shift)).isEqualTo(n);
            }
        }
    }

    @Test
    @DisplayName("1101001")
// 105
    void Test3() {
        int n = Integer.parseInt("1101001", 2);
        assertThat(n).isEqualTo(105);

        assertThat(Task7.rotateLeft(n, 0)).isEqualTo(n);
        assertThat(Task7.rotateLeft(n, 1)).isEqualTo(Integer.parseInt("1010011", 2)); // 1010011
        assertThat(Task7.rotateLeft(n, 2)).isEqualTo(Integer.parseInt("0100111", 2));
        assertThat(Task7.rotateLeft(n, 3)).isEqualTo(Integer.parseInt("1001110", 2));
        assertThat(Task7.rotateLeft(n, 4)).isEqualTo(Integer.parseInt("0011101", 2));
        assertThat(Task7.rotateLeft(n, 5)).isEqualTo(Integer.parseInt("0111010", 2));
        assertThat(Task7.rotateLeft(n, 6)).isEqualTo(Integer.parseInt("1110100", 2));
        assertThat(Task7.rotateLeft(n, 7)).isEqualTo(Integer.parseInt("1101001", 2));
        for (int shift = 8; shift < 10000; ++shift) {
            assertThat(Task7.rotateLeft(n, shift)).isEqualTo(Task7.rotateLeft(n, shift % 7));
        }

        assertThat(Task7.rotateRight(n, 0)).isEqualTo(n);
        assertThat(Task7.rotateRight(n, 1)).isEqualTo(Integer.parseInt("1110100", 2)); // 1010011
        assertThat(Task7.rotateRight(n, 2)).isEqualTo(Integer.parseInt("0111010", 2));
        assertThat(Task7.rotateRight(n, 3)).isEqualTo(Integer.parseInt("0011101", 2));
        assertThat(Task7.rotateRight(n, 4)).isEqualTo(Integer.parseInt("1001110", 2));
        assertThat(Task7.rotateRight(n, 5)).isEqualTo(Integer.parseInt("0100111", 2));
        assertThat(Task7.rotateRight(n, 6)).isEqualTo(Integer.parseInt("1010011", 2));
        assertThat(Task7.rotateRight(n, 7)).isEqualTo(Integer.parseInt("1101001", 2));
        for (int shift = 8; shift < 10000; ++shift) {
            assertThat(Task7.rotateRight(n, shift)).isEqualTo(Task7.rotateRight(n, shift % 7));
        }

    }

    @Test
    @DisplayName("10")
    void Test4() {
        int n = Integer.parseInt("10", 2);
        assertThat(n).isEqualTo(2);

        assertThat(Task7.rotateLeft(n, 0)).isEqualTo(n);
        assertThat(Task7.rotateLeft(n, 1)).isEqualTo(Integer.parseInt("01", 2)); // 1010011
        assertThat(Task7.rotateLeft(n, 2)).isEqualTo(Integer.parseInt("10", 2));
        for (int shift = 3; shift < 10000; ++shift) {
            assertThat(Task7.rotateLeft(n, shift)).isEqualTo(Task7.rotateLeft(n, shift % 2));
        }

        assertThat(Task7.rotateRight(n, 0)).isEqualTo(n);
        assertThat(Task7.rotateRight(n, 1)).isEqualTo(Integer.parseInt("01", 2)); // 1010011
        assertThat(Task7.rotateRight(n, 2)).isEqualTo(Integer.parseInt("10", 2));
        for (int shift = 3; shift < 10000; ++shift) {
            assertThat(Task7.rotateRight(n, shift)).isEqualTo(Task7.rotateLeft(n, shift % 2));
        }


    }


}
