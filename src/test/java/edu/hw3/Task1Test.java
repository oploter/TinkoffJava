package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("General functionality")
    void test1() {
        String res1 = Task1.atbash("Hello world!");
        assertThat(res1).isEqualTo("Svool dliow!");

        String res2 = Task1.atbash("Any fool can write code that a computer can understand. " +
                "Good programmers write code that humans can understand. ― Martin Fowler");

        assertThat(res2).isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. " +
                "Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
    }

    @Test
    @DisplayName("null")
    void testWithNull() {
        String res = Task1.atbash(null);
        assertThat(res).isNull();
    }

    @Test
    @DisplayName("Test with russian letters")
    void testWithRussian() {
        String res = Task1.atbash("Привет, Kak Dela? -- всё атлична, no ne ochen");
        assertThat(res).isEqualTo("Привет, Pzp Wvoz? -- всё атлична, ml mv lxsvm");
    }

    @Test
    @DisplayName("Test with not only english letters")
    void testNotOnlyEnglish() {
        String res1 = Task1.atbash("你好! Hello!");
        assertThat(res1).isEqualTo("你好! Svool!");

        String res2 = Task1.atbash("ǐ ǎ second-last");
        assertThat(res2).isEqualTo("ǐ ǎ hvxlmw-ozhg");
    }

    @Test
    @DisplayName("Letter case does not change")
    void testLetterCase() {
        String res1 = Task1.atbash("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertThat(res1).isEqualTo("ZYXWVUTSRQPONMLKJIHGFEDCBA");

        String res2 = Task1.atbash("abcdefghijklmnopqrstuvwxyz");
        assertThat(res2).isEqualTo("zyxwvutsrqponmlkjihgfedcba");
    }

    @Test
    @DisplayName("Does not contain english letters")
    void testWithoutChange() {
        String s1 = "ВСЕМ ПРИВЕТ Всем привет 12355!@#$%^&*()_+-={}][;:'\".<>,?/";
        assertThat(Task1.atbash(s1)).isEqualTo(s1);

    }

}
