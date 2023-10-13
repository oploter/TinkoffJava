package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @Test
    @DisplayName("null returns null")
    void CheckForNull() {
        assertThat(Task4.fixString(null)).isEqualTo(null);
    }

    @Test
    @DisplayName("empty string return empty string")
    void EmptyString() {
        assertThat(Task4.fixString("")).isEqualTo("");
    }

    @Test
    @DisplayName("123456 -> 214365")
    void Test1() {
        assertThat(Task4.fixString("123456")).isEqualTo("214365");
    }

    @Test
    @DisplayName("hTsii  s aimex dpus rtni.g -> This is a mixed up string.")
    void Test2() {
        assertThat(Task4.fixString("hTsii  s aimex dpus rtni.g")).isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("badce -> abcde")
    void Test3() {
        assertThat(Task4.fixString("badce")).isEqualTo("abcde");
    }

    @Test
    @DisplayName("оПомигети псаривьтс ртко!и -> Помогите исправить строки!")
    void Test4() {
        assertThat(Task4.fixString("оПомигети псаривьтс ртко!и")).isEqualTo("Помогите исправить строки!");
    }

    @Test
    @DisplayName("Even length of string")
    void TestEvenLength() {
        assertThat(Task4.fixString("214365")).isEqualTo("123456");
    }

    @Test
    @DisplayName("Odd length of string")
    void TestOddLength() {
        assertThat(Task4.fixString("2143657")).isEqualTo("1234567");
    }
}
