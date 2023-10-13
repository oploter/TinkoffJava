package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Kaprekar's constant -> 0 steps")
    void Test1() {
        assertThat(Task6.countK(6174)).isEqualTo(0);
    }

    @Test
    @DisplayName("3524")
    void Test2() {
        assertThat(Task6.countK(3524)).isEqualTo(3);
        assertThat(Task6.countK(3087)).isEqualTo(2);
        assertThat(Task6.countK(8352)).isEqualTo(1);
        /*
        1) 5432 - 2345 = 3087
        2) 8730 - 0378 = 8352
        3) 8532 - 2358 = 6174 +
         */
    }

    @Test
    @DisplayName("2005")
    void Test3() {
        assertThat(Task6.countK(2005)).isEqualTo(7);
        assertThat(Task6.countK(5175)).isEqualTo(6);
        assertThat(Task6.countK(5994)).isEqualTo(5);
        assertThat(Task6.countK(5355)).isEqualTo(4);
        assertThat(Task6.countK(1998)).isEqualTo(3);
        assertThat(Task6.countK(8082)).isEqualTo(2);
        assertThat(Task6.countK(8532)).isEqualTo(1);
        /*
        1) 5200 - 0025 = 5175
        2) 7551 - 1557 = 5994
        3) 9954 - 4599 = 5355
        4) 5553 - 3555 = 1998
        5) 9981 - 1899 = 8082
        6) 8820 - 0288 = 8532
        7) 8532 - 2358 = 6174 +
         */
    }

    @Test
    @DisplayName("1001")
    void Test4() {
        assertThat(Task6.countK(1001)).isEqualTo(4);
        assertThat(Task6.countK(1089)).isEqualTo(3);
        assertThat(Task6.countK(9621)).isEqualTo(2);
        assertThat(Task6.countK(8352)).isEqualTo(1);
        /*
        1) 1100 - 0011 = 1089
        2) 9810 - 0189 = 9621
        3) 9621 - 1269 = 8352
        4) 8532 - 2358 = 6174 +
         */
    }

    @Test
    @DisplayName("2011")
    void Test5() {
        assertThat(Task6.countK(2011)).isEqualTo(4);
        assertThat(Task6.countK(1998)).isEqualTo(3);
        assertThat(Task6.countK(8082)).isEqualTo(2);
        assertThat(Task6.countK(8532)).isEqualTo(1);
        /*
        1) 2110 - 0112 = 1998
        2) 9981 - 1899 = 8082
        3) 8820 - 0288 = 8532
        4) 8532 - 2358 = 6174 +
         */
    }

    @Test
    @DisplayName("2324")
    void Test6() {
        assertThat(Task6.countK(2324)).isEqualTo(3);
        assertThat(Task6.countK(2088)).isEqualTo(2);
        assertThat(Task6.countK(8532)).isEqualTo(1);
        /*
        1) 4322 - 2234 = 2088
        2) 8820 - 0288 = 8532
        3) 8532 - 2358 = 6174 +
         */
    }


    @Test
    @DisplayName("Test the amount of every step is correct")
    /*
    На сайте хабр приведена таблица распределения кол-ва чисел в зависимости кол-ва ходов до Постоянной Капрекара.
    В этом тесте проверяю, что моя таблица совпадает с приведенной на сайте*.
    Ссылка на таблицу: https://shorturl.at/muw15   (https://habr.com/ru/articles/122121/#)
    * -- Кол-во чисел, для которых число шагов = 5, уменьшено на 1,
    так как на сайте 1000 входит в область определения функции, а в Задаче 6 -- нет.
     */
    void help() {
        final int[] habrTable = new int[]{1, 356, 519, 2124, 1124, 1378, 1508, 1980};
        int[] myTable = new int[8];
        for (int i = 1001; i <= 9998; ++i) {
            int steps = Task6.countK(i);
            if (steps > -1) {
                ++myTable[steps];
            }
        }
        assertThat(Arrays.equals(myTable, habrTable)).isEqualTo(true);
    }

}
