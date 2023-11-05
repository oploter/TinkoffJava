package edu.project2;

public class UtilsMaze {
    public static Maze mazeFromString(int height, int width, String str) {
        Cell[][] grid = new Cell[height][width];
        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                grid[row][col] = new Cell(row, col);
            }
        }
        boolean isCellRow = true;
        int rowCnt = 0;
        for (String row : str.split("\n")) {
            if (isCellRow) {
                Cell prevCell = grid[rowCnt][0];
                int colCnt = 1;
                for (int i = 2; i < row.length() - 1; i += 2) {
                    //System.out.println(rowCnt + " " + colCnt + " " + row.length());
                    Cell currCell = grid[rowCnt][colCnt];
                    if (row.charAt(i) == ' ') {
                        Cell.removeWallBetweenCells(prevCell, currCell);
                    }
                    prevCell = currCell;
                    ++colCnt;
                }
                isCellRow = false;
            } else {
                int colCnt = 0;
                for (int i = 1; i < row.length(); i += 2) {
                    if (row.charAt(i) == ' ') {
                        Cell.removeWallBetweenCells(grid[rowCnt][colCnt], grid[rowCnt + 1][colCnt]);
                    }
                    ++colCnt;
                }
                ++rowCnt;
                isCellRow = true;
            }
        }
        return new Maze(height, width, grid);
    }
}
