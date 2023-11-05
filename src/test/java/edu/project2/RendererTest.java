package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RendererTest {
    @Test
    @DisplayName("Test 1")
    void test1() {
        StringBuilder fullMazeStr = new StringBuilder(); // Maze 6x6
        fullMazeStr.append("| | | |\n");
        fullMazeStr.append(" - - - \n");
        fullMazeStr.append("| | | |\n");
        fullMazeStr.append(" - - - \n");
        fullMazeStr.append("| | | |\n");

        Maze maze1 = UtilsMaze.mazeFromString(3, 3, fullMazeStr.toString());
        Renderer renderer = new SimpleRenderer();

        StringBuilder fullMazeStrRendered = new StringBuilder(); // Maze 6x6
        fullMazeStrRendered.append("+---+---+---+\n");
        fullMazeStrRendered.append("|   |   |   |\n");
        fullMazeStrRendered.append("+---+---+---+\n");
        fullMazeStrRendered.append("|   |   |   |\n");
        fullMazeStrRendered.append("+---+---+---+\n");
        fullMazeStrRendered.append("|   |   |   |\n");
        fullMazeStrRendered.append("+---+---+---+\n");
        assertThat(renderer.render(maze1)).isEqualTo(fullMazeStrRendered.toString());
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
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
        Renderer renderer = new SimpleRenderer();

        StringBuilder fullMazeStrRendered = new StringBuilder(); // Maze 6x6
        fullMazeStrRendered.append("+---+---+---+---+---+---+\n");
        fullMazeStrRendered.append("|   |                   |\n");
        fullMazeStrRendered.append("+   +   +   +---+---+   +\n");
        fullMazeStrRendered.append("|   |   |   |       |   |\n");
        fullMazeStrRendered.append("+   +---+   +   +---+   +\n");
        fullMazeStrRendered.append("|           |   |       |\n");
        fullMazeStrRendered.append("+---+---+---+   +   +---+\n");
        fullMazeStrRendered.append("|       |       |   |   |\n");
        fullMazeStrRendered.append("+   +   +   +   +   +   +\n");
        fullMazeStrRendered.append("|   |       |   |   |   |\n");
        fullMazeStrRendered.append("+   +---+---+   +   +   +\n");
        fullMazeStrRendered.append("|           |           |\n");
        fullMazeStrRendered.append("+---+---+---+---+---+---+\n");
        assertThat(renderer.render(maze1)).isEqualTo(fullMazeStrRendered.toString());
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        StringBuilder fullMazeStr = new StringBuilder(); // Maze 6x6
        fullMazeStr.append("|       |\n");
        fullMazeStr.append("         \n");
        fullMazeStr.append("|       |\n");
        fullMazeStr.append("         \n");
        fullMazeStr.append("|       |\n");
        fullMazeStr.append("         \n");
        fullMazeStr.append("|       |\n");

        Maze maze1 = UtilsMaze.mazeFromString(4, 4, fullMazeStr.toString());
        Renderer renderer = new SimpleRenderer();

        StringBuilder fullMazeStrRendered = new StringBuilder(); // Maze 6x6
        fullMazeStrRendered.append("+---+---+---+---+\n");
        fullMazeStrRendered.append("|               |\n");
        fullMazeStrRendered.append("+   +   +   +   +\n");
        fullMazeStrRendered.append("|               |\n");
        fullMazeStrRendered.append("+   +   +   +   +\n");
        fullMazeStrRendered.append("|               |\n");
        fullMazeStrRendered.append("+   +   +   +   +\n");
        fullMazeStrRendered.append("|               |\n");
        fullMazeStrRendered.append("+---+---+---+---+\n");
        assertThat(renderer.render(maze1)).isEqualTo(fullMazeStrRendered.toString());
    }
}
