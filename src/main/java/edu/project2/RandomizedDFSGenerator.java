package edu.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class RandomizedDFSGenerator implements Generator {
    private static final Random RANDOM = new Random();

    public Maze generate(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Cannot create maze with non-positive dimensions");
        }
        boolean[][] visitedCells = new boolean[height][width];
        Cell[][] grid = new Cell[height][width];
        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                grid[row][col] = new Cell(row, col);
                visitedCells[row][col] = false;
            }
        }

        Stack<Coordinate> cellStack = new Stack<>();
        cellStack.push(new Coordinate(0, 0));
        visitedCells[0][0] = true;
        while (!cellStack.empty()) {
            Coordinate currCellCoordinate = cellStack.pop();

            List<Coordinate> unvisitedNeighborsCoordinates = new ArrayList<>();
            for (Coordinate delta : Coordinate.COORDINATES_DELTA_FOR_NEIGHBOURS) {
                int neighborRow = currCellCoordinate.row() + delta.row();
                int neighborCol = currCellCoordinate.col() + delta.col();
                if (neighborRow < 0 || height <= neighborRow || neighborCol < 0
                        || width <= neighborCol || visitedCells[neighborRow][neighborCol]) {
                    continue;
                }
                unvisitedNeighborsCoordinates.add(new Coordinate(neighborRow, neighborCol));
            } // Find unvisited neighbours

            if (unvisitedNeighborsCoordinates.size() == 0) {
                continue;
            }

            cellStack.push(currCellCoordinate); // Push the current cell to the stack

            Coordinate neighborCoordinate = unvisitedNeighborsCoordinates.get(
                    RANDOM.nextInt(unvisitedNeighborsCoordinates.size())
            ); // Chose one of the unvisited neighbours

            Cell.removeWallBetweenCells(
                    grid[currCellCoordinate.row()][currCellCoordinate.col()],
                    grid[neighborCoordinate.row()][neighborCoordinate.col()]
            ); // Remove the wall between the current cell and the chosen neighbor

            visitedCells[neighborCoordinate.row()][neighborCoordinate.col()] = true;
            // Mark the chosen neighbor as visited
            cellStack.push(neighborCoordinate);
        }
        return new Maze(height, width, grid);
    }
}
