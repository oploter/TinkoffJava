package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Intermediate values are only even lengths")
    void IntermediateValuesOnlyEvenLengthsTest() {
        assertThat(Task5.isPalindromeDescendant(23336014)).isEqualTo(true);
/*
        23336014    -
        5665        +
*/

        assertThat(Task5.isPalindromeDescendant(123312)).isEqualTo(true);
/*
        123312  -
        363     +
*/

        assertThat(Task5.isPalindromeDescendant(11211230)).isEqualTo(true);
/*
        11211230    -
        2333        -
        56          -
        11          +
*/

        assertThat(Task5.isPalindromeDescendant(13001120)).isEqualTo(true);
/*
        13001120    -
        4022        -
        44          +
*/
    }


    @Test
    @DisplayName("Already palindrome")
    void AlreadyPalindromeTest() {
        assertThat(Task5.isPalindromeDescendant(12344321)).isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(11)).isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(1234321)).isEqualTo(true); // odd length works
    }


    @Test
    @DisplayName("Non-positive numbers OR numbers < 10 -> false")
    void NegativeNumberTest() {
        for (int i = -1000; i <= 0; ++i) {
            assertThat(Task5.isPalindromeDescendant(i)).isEqualTo(false);
        }
        assertThat(Task5.isPalindromeDescendant(-123321)).isEqualTo(false);
        for (int i = 1; i <= 9; ++i) {
            assertThat(Task5.isPalindromeDescendant(i)).isEqualTo(false);
        }
    }


    @Test
    @DisplayName("Intermediate values can be odd lengths")
    void IntermediateValuesCanBeOddLengthsTest() {
        assertThat(Task5.isPalindromeDescendant(617)).isEqualTo(true);
        /*
        617     -
        77      +
         */
        assertThat(Task5.isPalindromeDescendant(551)).isEqualTo(true);
        /*
        551     -
        101     +
         */

        assertThat(Task5.isPalindromeDescendant(6612123)).isEqualTo(true);
        /*
        6612123     -
        12333       -
        363         +
         */
    }


}
