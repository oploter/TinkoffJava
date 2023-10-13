package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    private static final int BOARD_SIZE = 8;

    private static byte[][] boardFromString(String rows) {
        byte[][] board = new byte[BOARD_SIZE][BOARD_SIZE];
        int rowCount = 0;
        for (String rowS : rows.split("\n")) {
            rowS = rowS.strip();
            for (int col = 0; col < BOARD_SIZE; ++col) {
                board[rowCount][col] = (byte) (rowS.charAt(col) == '0' ? 0 : 1);
            }
            ++rowCount;
        }
        return board;
    }

    @Test
    @DisplayName("Test1")
    void Test1() {
        byte[][] board = boardFromString("""
                             00010000
                             00000000
                             01000100
                             00001010
                             01000100
                             00000000
                             01000001
                             00001000
                """);

        assertThat(Task8.knightBoardCapture(board)).isEqualTo(true);
    }

    @Test
    @DisplayName("Test2")
    void Test2() {
        byte[][] board = boardFromString("""
                            10101010
                            01010101
                            00001010
                            00100101
                            10001010
                            00000101
                            10001010
                            00010101
                """);

        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test3")
    void Test3() {
        byte[][] board = boardFromString("""
                           00001000
                           00000100
                           00010000
                           10000000
                           00001000
                           00000100
                           00000100
                           10000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test4")
    void Test4() {
        byte[][] board = boardFromString("""
                           11111111
                           11111111
                           11111111
                           11111111
                           11111111
                           11111111
                           11111111
                           11111111
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test5")
    void Test5() {
        byte[][] board = boardFromString("""
                           11111111
                           10000001
                           10000001
                           10000001
                           10000001
                           10000001
                           10000001
                           11111111
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test6")
    void Test6() {
        byte[][] board = boardFromString("""
                           11111111
                           00000000
                           00000000
                           10000001
                           10000001
                           00000000
                           00000000
                           11111111
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(true);
    }

    @Test
    @DisplayName("Test7")
    void Test7() {
        byte[][] board = boardFromString("""
                           10101010
                           01010101
                           10101010
                           01010101
                           10101010
                           01010101
                           10101010
                           01010101
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(true);
    }

    @Test
    @DisplayName("Test8")
    void Test8() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(true);
    }

    @Test
    @DisplayName("Test9")
    void Test9() {
        byte[][] board = boardFromString("""
                           00002000
                           00000000
                           00002300
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test10")
    void Test10() {
        byte[][] board = boardFromString("""
                           00000000
                           00010000
                           00000000
                           00001000
                           00000000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test11")
    void Test11() {
        byte[][] board = boardFromString("""
                           00000000
                           00000100
                           00000000
                           00001000
                           00000000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test12")
    void Test12() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00000010
                           00001000
                           00000000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test Default Pos")
    void Test13() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00100000
                           00001000
                           00000000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test14")
    void Test14() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00000000
                           00001000
                           00000000
                           00010000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test15")
    void Test15() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00000000
                           00001000
                           00000000
                           00000100
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test16")
    void Test16() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00000000
                           00001000
                           00000010
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test17")
    void Test17() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00000000
                           00001000
                           00100000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test18")
    void Test18() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00000000
                           00001000
                           00000000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(true);
    }

    @Test
    @DisplayName("Testing angles 1")
    void TestAngles1() {
        byte[][] board = boardFromString("""
                           10000000
                           00000000
                           01000000
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Testing angles 2")
    void TestAngles2() {
        byte[][] board = boardFromString("""
                           10000000
                           00100000
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Testing angles 3")
    void TestAngles3() {
        byte[][] board = boardFromString("""
                           00000001
                           00000000
                           00000010
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Testing angles 4")
    void TestAngles4() {
        byte[][] board = boardFromString("""
                           00000001
                           00000100
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Testing angles 5")
    void TestAngles5() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                           00000010
                           00000000
                           00000001
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Testing angles 6")
    void TestAngles6() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                           00000100
                           00000001
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Testing angles 7")
    void TestAngles7() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                           01000000
                           00000000
                           10000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Testing angles 8")
    void TestAngles8() {
        byte[][] board = boardFromString("""
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                           00000000
                           00100000
                           10000000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test19")
    void Test19() {
        byte[][] board = boardFromString("""
                           11000000
                           11100000
                           01110000
                           00111000
                           00011100
                           00001110
                           00000111
                           00000011
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
    }

    @Test
    @DisplayName("Test20")
    void Test20() {
        byte[][] board = boardFromString("""
                           10000001
                           00010001
                           00111001
                           00010000
                           10000001
                           00010000
                           00111000
                           00010000
                """);
        assertThat(Task8.knightBoardCapture(board)).isEqualTo(true);
    }


}
