package edu.project2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SimpleRenderer implements Renderer {
    private static final String VERTICAL_WALL = "|";
    private static final String NO_VERTICAL_WALL = " ";
    private static final String VER_FILLER = "+";
    private static final String HORIZONTAL_WALL = "---";
    private static final String NO_HORIZONTAL_WALL = "   ";
    private static final String PASSAGE = " # ";

    public String render(Maze maze) {
        if (maze == null) {
            throw new IllegalArgumentException("Maze is null");
        }
        return render(maze, Collections.emptyList());
    }

    public String render(Maze maze, List<Coordinate> path) {
        List<Coordinate> sortedPath = path.stream()
                .sorted(Comparator.comparingInt(Coordinate::row)
                        .thenComparingInt(Coordinate::col)).toList();
        int sortedPathInd = 0;

        StringBuilder stringRepresentation = new StringBuilder();
        StringBuilder wallsStr;
        StringBuilder cellsStr;
        stringRepresentation.append((VER_FILLER + HORIZONTAL_WALL).repeat(maze.getWidth())).append("+\n");
        for (int row = 0; row < maze.getHeight(); ++row) {
            cellsStr = new StringBuilder(VERTICAL_WALL);
            wallsStr = new StringBuilder(VER_FILLER);
            for (int col = 0; col < maze.getWidth(); ++col) {
                Coordinate cellCoordinate = new Coordinate(row, col);
                Cell cell = maze.at(cellCoordinate);
                if (sortedPathInd < sortedPath.size()
                        && sortedPath.get(sortedPathInd).equals(cellCoordinate)) {
                    cellsStr.append(PASSAGE);
                    ++sortedPathInd;
                } else {
                    cellsStr.append(NO_HORIZONTAL_WALL);
                }

                cellsStr.append((
                        cell.isWall(Cell.Direction.RIGHT)
                                ? VERTICAL_WALL
                                : NO_VERTICAL_WALL
                ));
                wallsStr.append(
                        cell.isWall(Cell.Direction.BOTTOM)
                                ? HORIZONTAL_WALL
                                : NO_HORIZONTAL_WALL
                );
                wallsStr.append(VER_FILLER);
            }

            stringRepresentation.append(cellsStr).append('\n').append(wallsStr).append('\n');
        }
        return stringRepresentation.toString();
    }
}
