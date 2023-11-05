package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExtremeTest {
    @Test
    @DisplayName("Maze constructor invalid")
    void test1() {
        assertThatThrownBy(() -> {
            Maze m1 = new Maze(-1, 2, new Cell[][]{});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Cannot create maze with non-positive dimensions");

        assertThatThrownBy(() -> {
            Maze m1 = new Maze(1, -2, new Cell[][]{});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Cannot create maze with non-positive dimensions");


        Cell[][] grid = new Cell[2][3];
        grid[0] = new Cell[3];
        grid[1] = new Cell[3];
        grid[0][0] = new Cell(0, 0);
        grid[0][1] = new Cell(0, 1);
        grid[0][2] = new Cell(0, 2);
        grid[1][0] = new Cell(1, 0);
        grid[1][1] = new Cell(1, 1);
        grid[1][2] = new Cell(1, 2);

        assertThatThrownBy(() -> {
            Maze m1 = new Maze(2, 2, grid);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Grid is invalid");
        assertThatThrownBy(() -> {
            Maze m1 = new Maze(2, 2, null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Grid is invalid");

        Generator generator = new RandomizedDFSGenerator();
        assertThatThrownBy(() -> {
            generator.generate(-1, 2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Cannot create maze with non-positive dimensions");
        assertThatThrownBy(() -> {
            generator.generate(11, -2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Cannot create maze with non-positive dimensions");
    }
}
