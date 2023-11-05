package edu.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFSSolver implements Solver {
    private List<Coordinate> path;
    private Set<Coordinate> visitedCells;
    private Maze maze;
    private Coordinate target;

    private boolean dfs(Coordinate cell) {
        visitedCells.add(cell);
        if (cell.equals(target)) {
            path.add(cell);
            return true;
        }
        boolean pathToTargetContainsTarget = false;
        for (Coordinate delta : Coordinate.COORDINATES_DELTA_FOR_NEIGHBOURS) {
            Coordinate neighbor = new Coordinate(cell.row() + delta.row(), cell.col() + delta.col());
            if (maze.isBadCoordinate(neighbor)) {
                continue;
            }
            if (!visitedCells.contains(neighbor) && !Cell.wallBetween(maze.at(cell), maze.at(neighbor))) {
                if (dfs(neighbor)) {
                    path.add(cell);
                    pathToTargetContainsTarget = true;
                }
            }
        }
        return pathToTargetContainsTarget;

    }

    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        if (maze == null) {
            throw new IllegalArgumentException("Maze is null");
        }
        path = new ArrayList<>();
        visitedCells = new HashSet<>();
        this.maze = maze;
        target = end;
        if (maze.isBadCoordinate(start) || maze.isBadCoordinate(end)) {
            throw new IllegalArgumentException("Start/end coordinates are invalid");
        }
        return dfs(start) ? path : Collections.emptyList();
    }
}
