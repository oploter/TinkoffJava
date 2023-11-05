package edu.project2;

import java.util.List;

public record Coordinate(int row, int col) {
    public static final List<Coordinate> COORDINATES_DELTA_FOR_NEIGHBOURS = List.of(
            new Coordinate(-1, 0),
            new Coordinate(0, 1),
            new Coordinate(1, 0),
            new Coordinate(0, -1)
    );

}
