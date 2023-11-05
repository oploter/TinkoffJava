package edu.project2;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(int height, int width, Cell[][] grid) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Cannot create maze with non-positive dimensions");
        }
        if (grid == null || grid.length != height || grid[0].length != width) {
            throw new IllegalArgumentException("Grid is invalid");
        }

        this.height = height;
        this.width = width;
        this.grid = new Cell[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            this.grid[i] = grid[i].clone();
        }
    }

    public boolean isBadCoordinate(Coordinate c) {
        return (0 > c.row() || c.row() >= height || 0 > c.col() || c.col() >= width);
    }

    public Cell at(Coordinate coordinate) {
        if (isBadCoordinate(coordinate)) {
            return null;
        }
        return grid[coordinate.row()][coordinate.col()];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


}
