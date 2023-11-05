package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolverTest {
    @Test
    @DisplayName("Test 1")
    void testPath() {
        StringBuilder fullMazeStr = new StringBuilder(); // Maze 6x6
        fullMazeStr.append("| |         |\n");
        fullMazeStr.append("       - -   \n");
        fullMazeStr.append("| | | |   | |\n");
        fullMazeStr.append("   -     -   \n");
        fullMazeStr.append("|     | |   |\n");
        fullMazeStr.append(" - - -     - \n");
        fullMazeStr.append("|   |   | | |\n");
        fullMazeStr.append("             \n");
        fullMazeStr.append("| |   | | | |\n");
        fullMazeStr.append("   - -       \n");
        fullMazeStr.append("|     |     |\n");

        Maze maze1 = UtilsMaze.mazeFromString(6, 6, fullMazeStr.toString());

        Solver solver = new DFSSolver();

        for (int r1 = 0; r1 < maze1.getHeight(); ++r1) {
            for (int c1 = 0; c1 < maze1.getWidth(); ++c1) {
                for (int r2 = 0; r2 < maze1.getHeight(); ++r2) {
                    for (int c2 = 0; c2 < maze1.getWidth(); ++c2) {
                        assertThat(solver.solve(maze1, new Coordinate(r1, c1), new Coordinate(r2, c2)).size())
                                .isPositive();
                    }
                }
            }
        }

        List<Coordinate> coordinates1 = Arrays.asList(
                new Coordinate(0, 0),   // 18
                new Coordinate(1, 0),   // 17
                new Coordinate(2, 0),   // 16
                new Coordinate(2, 1),   // 15
                new Coordinate(2, 2),   // 14
                new Coordinate(1, 2),   // 13
                new Coordinate(0, 2),   // 12
                new Coordinate(0, 3),   // 11
                new Coordinate(0, 4),   // 10
                new Coordinate(0, 5),   // 9
                new Coordinate(1, 5),   // 8
                new Coordinate(2, 5),   // 7
                new Coordinate(2, 4),   // 6
                new Coordinate(3, 4),   // 5
                new Coordinate(4, 4),   // 4
                new Coordinate(5, 4),   // 3
                new Coordinate(5, 3),   // 2
                new Coordinate(4, 3),   // 1
                new Coordinate(3, 3)    // 0
        );
        Collections.reverse(coordinates1);

        assertThat(solver.solve(maze1, new Coordinate(0, 0), new Coordinate(3, 3)))
                .isEqualTo(coordinates1);
        assertThat(solver.solve(maze1, new Coordinate(0, 3), new Coordinate(3, 4)))
                .isEqualTo(coordinates1.subList(5, 12));

        List<Coordinate> reversedPath = solver.solve(maze1, new Coordinate(2, 0), new Coordinate(5, 4));
        Collections.reverse(reversedPath);
        assertThat(solver.solve(maze1, new Coordinate(5, 4), new Coordinate(2, 0)))
                .isEqualTo(reversedPath);


        List<Coordinate> coordinates2 = Arrays.asList(
                new Coordinate(0, 0),
                new Coordinate(1, 0),
                new Coordinate(2, 0),
                new Coordinate(2, 1),
                new Coordinate(2, 2),
                new Coordinate(1, 2),
                new Coordinate(0, 2),
                new Coordinate(0, 3),
                new Coordinate(0, 4),
                new Coordinate(0, 5),
                new Coordinate(1, 5),
                new Coordinate(2, 5),
                new Coordinate(2, 4),
                new Coordinate(3, 4),
                new Coordinate(4, 4),
                new Coordinate(5, 4),
                new Coordinate(5, 5),
                new Coordinate(4, 5),
                new Coordinate(3, 5)
        );
        assertThat(solver.solve(maze1, new Coordinate(3, 5), new Coordinate(0, 0)));
        Collections.reverse(coordinates2);
        assertThat(solver.solve(maze1, new Coordinate(0, 0), new Coordinate(3, 5)));


        List<Coordinate> coordinates3 = Arrays.asList(
                new Coordinate(2, 0),
                new Coordinate(2, 1),
                new Coordinate(2, 2),
                new Coordinate(1, 2),
                new Coordinate(0, 2),
                new Coordinate(0, 1),
                new Coordinate(1, 1)
        );
        assertThat(solver.solve(maze1, new Coordinate(1, 1), new Coordinate(2, 0)));
        Collections.reverse(coordinates3);
        assertThat(solver.solve(maze1, new Coordinate(2, 0), new Coordinate(1, 1)));
    }

    @Test
    @DisplayName("Test 2")
    void test2() {

    }

    @Test
    @DisplayName("Test no path")
    void testNoPath() {
        StringBuilder fullMazeStr1 = new StringBuilder(); // Maze 6x6
        fullMazeStr1.append("|       | | |\n");
        fullMazeStr1.append(" - - - -   - \n");
        fullMazeStr1.append("|   | | | | |\n");
        fullMazeStr1.append("   -   -   - \n");
        fullMazeStr1.append("| | | |   | |\n");
        fullMazeStr1.append("   -   - - - \n");
        fullMazeStr1.append("|   |     | |\n");
        fullMazeStr1.append("   -   - - - \n");
        fullMazeStr1.append("| | | | | | |\n");
        fullMazeStr1.append("   - - - - - \n");
        fullMazeStr1.append("|     | | | |\n");

        Maze maze1 = UtilsMaze.mazeFromString(6, 6, fullMazeStr1.toString());
        Solver solver1 = new DFSSolver();

        assertThat(solver1.solve(maze1, new Coordinate(0, 0), new Coordinate(2, 4))).isEmpty();
        assertThat(solver1.solve(maze1, new Coordinate(3, 2), new Coordinate(3, 5))).isEmpty();
        assertThat(solver1.solve(maze1, new Coordinate(4, 3), new Coordinate(0, 5))).isEmpty();
        assertThat(solver1.solve(maze1, new Coordinate(0, 3), new Coordinate(3, 0))).isEmpty();
        assertThat(solver1.solve(maze1, new Coordinate(3, 1), new Coordinate(3, 2))).isEmpty();
        assertThat(solver1.solve(maze1, new Coordinate(3, 4), new Coordinate(1, 4))).isEmpty();
        assertThat(solver1.solve(maze1, new Coordinate(4, 0), new Coordinate(0, 2))).isEmpty();

        List<Coordinate> coordinates1 = Arrays.asList(
                new Coordinate(1, 2),
                new Coordinate(2, 2),
                new Coordinate(3, 2),
                new Coordinate(3, 3),
                new Coordinate(3, 4)
        );
        assertThat(solver1.solve(maze1, new Coordinate(3, 4), new Coordinate(1, 2))).isEqualTo(coordinates1);
        Collections.reverse(coordinates1);
        assertThat(solver1.solve(maze1, new Coordinate(1, 2), new Coordinate(3, 4))).isEqualTo(coordinates1);


        StringBuilder fullMazeStr2 = new StringBuilder(); // Maze 6x6
        fullMazeStr2.append("| | | |\n");
        fullMazeStr2.append(" - - - \n");
        fullMazeStr2.append("| | | |\n");
        fullMazeStr2.append(" - - - \n");
        fullMazeStr2.append("| | | |\n");

        Maze maze2 = UtilsMaze.mazeFromString(3, 3, fullMazeStr2.toString());
        for (int r1 = 0; r1 < maze2.getHeight(); ++r1) {
            for (int c1 = 0; c1 < maze2.getWidth(); ++c1) {
                for (int r2 = 0; r2 < maze2.getHeight(); ++r2) {
                    for (int c2 = 0; c2 < maze2.getWidth(); ++c2) {
                        if (r1 == r2 || c1 == c2) {
                            continue;
                        }
                        assertThat(solver1.solve(maze2, new Coordinate(r1, c1), new Coordinate(r2, c2))).isEmpty();
                    }
                }
            }
        }

    }
}
