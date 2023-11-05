package edu.project2;

public record Cell(int row, int col, boolean[] walls) {
    private static final int WALLS_NUMBER = 4;
    private static final String ERROR_MESSAGE = "Cells are not neighbors";

    public Cell {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Row/col cannot be negative");
        }
        if (walls == null || walls.length != WALLS_NUMBER) {
            throw new IllegalArgumentException("Walls invalid");
        }
    }

    public Cell(int row, int col) {
        this(row, col, new boolean[]{true, true, true, true});
    }

    public enum Direction {
        TOP, RIGHT, BOTTOM, LEFT
    }

    public boolean isWall(Direction direction) {
        return walls[direction.ordinal()];
    }

    public static Direction directionFromAToB(Cell a, Cell b) {
        Coordinate coordinateDiff = new Coordinate(a.row() - b.row(), a.col() - b.col());
        if (coordinateDiff.equals(new Coordinate(-1, 0))) {
            return Direction.BOTTOM;
        } else if (coordinateDiff.equals(new Coordinate(0, -1))) {
            return Direction.RIGHT;
        } else if (coordinateDiff.equals(new Coordinate(1, 0))) {
            return Direction.TOP;
        } else if (coordinateDiff.equals(new Coordinate(0, 1))) {
            return Direction.LEFT;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public static void removeWallBetweenCells(Cell a, Cell b) {
        switch (directionFromAToB(a, b)) {
            case BOTTOM -> {
                a.walls[Direction.BOTTOM.ordinal()] = false;
                b.walls[Direction.TOP.ordinal()] = false;
            }
            case RIGHT -> {
                a.walls[Direction.RIGHT.ordinal()] = false;
                b.walls[Direction.LEFT.ordinal()] = false;
            }
            case TOP -> {
                a.walls[Direction.TOP.ordinal()] = false;
                b.walls[Direction.BOTTOM.ordinal()] = false;
            }
            case LEFT -> {
                a.walls[Direction.LEFT.ordinal()] = false;
                b.walls[Direction.RIGHT.ordinal()] = false;
            }
            default -> throw new IllegalArgumentException(ERROR_MESSAGE);
        }

    }

    public static Boolean wallBetween(Cell a, Cell b) {
        Direction direction = directionFromAToB(a, b);
        if (direction != null) {
            return a.walls[direction.ordinal()];
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }
}
