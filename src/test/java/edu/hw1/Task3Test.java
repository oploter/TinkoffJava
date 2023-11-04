package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task3Test {
    @Test
    @DisplayName("[a, b] < [] -> false")
    void nonEmptyNotInEmpty() {
        int[][] arrs = new int[][]{{21, -1}, {}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("{rMin, [lMin, rMax}, lMax] -> false")
    void false1() {
        int[][] arrs = new int[][]{{123, 23, 43}, {1, 2, 23}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("{rMin, rMax}[lMin, lMax] -> false")
    void false2() {
        int[][] arrs = new int[][]{{10000, 132, 13, 1, 1, 1, 1}, {-1000, -54, -1}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("{rMin, rMax}[lMin == lMax] -> false")
    void false3() {
        int[][] arrs = new int[][]{{1}, {-10, -20}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("[lMin, lMax]{rMin == rMax} -> false")
    void false4() {
        int[][] arrs = new int[][]{{-1000, 10000}, {10000}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("[lMin, {rMin, lMax], rMax} -> false")
    void false5() {
        int[][] arrs = new int[][]{{-10000, 123, 1232}, {0, 1, 2, 3, 99999, 12}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("null, null -> false")
    void false6() {
        int[][] arrs = new int[][]{null, null};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("null, not null -> false")
    void false7() {
        int[][] arrs = new int[][]{null, {-1, 1, 2}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("not null, null -> false")
    void false8() {
        int[][] arrs = new int[][]{{-12}, null};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("[lMin, {rMin, rMax}, lMax]")
    void false9() {
        int[][] arrs = new int[][]{{Integer.MIN_VALUE, Integer.MAX_VALUE}, {}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("[{lMin == rMin, rMax == lMax}]")
    void false10() {
        int[][] arrs = new int[][]{{9, 9, 8}, {8, 9}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("[{lMin == rMin, rMax == lMax]}")
    void false11() {
        int[][] arrs = new int[][]{{1, 2, 3}, {3, 2, 1}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);

        arrs = new int[][]{{1}, {1}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("[{lMin == rMin, lMax}, rMax]")
    void false12() {
        int[][] arrs = new int[][]{{1, 2, 123, 1233}, {1, 11000}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("[rMin == lMin, lMax}, rMax]")
    void false13() {
        int[][] arrs = new int[][]{{-1000, 1, 2, 0, 1000}, {-1000, -1, 234, 321, 10000}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("[{lMin == rMin, rMax == lMax]}")
    void false14() {
        int[][] arrs = new int[][]{{Integer.MIN_VALUE, Integer.MAX_VALUE}, {Integer.MAX_VALUE, Integer.MIN_VALUE}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }

    @Test
    @DisplayName("{lMin, [rMin, rMax] lMax}")
    void false15() {
        int[][] arrs = new int[][]{{1, 2, 3, 4}, {2, 3}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(false);
    }


    //[1, 2, 3, 4], [2, 3]
    /* True Tests */
    @Test
    @DisplayName("empty in [rMin, rMax]")
    void emptyAlwaysIn() {
        int[][] arrs = new int[][]{{}, {21, -1}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(true);
    }

    @Test
    @DisplayName("[rMin, {lMin, lMax}, rMax]")
    void true2() {
        int[][] arrs = new int[][]{{1, 2, 123, 1233}, {-1000, 102, 22, 1, 11000}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(true);
    }

    @Test
    @DisplayName("Empty is always in empty")
    void true4() {
        int[][] arrs = new int[][]{{}, {}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(true);
    }

    @Test
    @DisplayName("[rMin, {lMin, lMax}, rMax]")
    void true6() {
        int[][] arrs = new int[][]{{1, 2, 3, 4}, {0, 6}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(true);
    }

    @Test
    @DisplayName("[rMin, {lMin, lMax}, rMax]")
    void true7() {
        int[][] arrs = new int[][]{{3, 1}, {4, 0}};
        assertThat(Task3.isNestable(arrs[0], arrs[1])).isEqualTo(true);
    }

}
