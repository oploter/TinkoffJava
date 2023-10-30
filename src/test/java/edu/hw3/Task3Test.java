package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Task3Test {
    @Test
    @DisplayName("()()()")
    void test1() {
        List<String> clusters = Task3.clusterize("()()()");
        assertThat(clusters).isEqualTo(Arrays.asList(
                "()", "()", "()"
        ));
    }

    @Test
    @DisplayName("((()))")
    void test2() {
        List<String> clusters = Task3.clusterize("((()))");
        assertThat(clusters).isEqualTo(List.of(
                "((()))"
        ));
    }

    @Test
    @DisplayName("((()))(())()()(()())")
    void test3() {
        List<String> clusters = Task3.clusterize("((()))(())()()(()())");
        assertThat(clusters).isEqualTo(Arrays.asList(
                "((()))", "(())", "()", "()", "(()())"
        ));
    }

    @Test
    @DisplayName("((())())(()(()()))")
    void test4() {
        List<String> clusters = Task3.clusterize("((())())(()(()()))");
        assertThat(clusters).isEqualTo(Arrays.asList(
                "((())())", "(()(()()))"
        ));
    }

    @Test
    @DisplayName("null as argument")
    void testNull() {
        assertThat(Task3.clusterize(null)).isEqualTo(null);
    }

    @Test
    @DisplayName("String contains bad characters")
    void testBadCharacters() {
        assertThat(Task3.clusterize("()h()")).isEqualTo(null);
        assertThat(Task3.clusterize("[][](())")).isEqualTo(null);
    }

    @Test
    @DisplayName("Invalid clusters")
    void testInvalidClusters() {
        assertThat(Task3.clusterize("((())())()")).isEqualTo(Arrays.asList(
                "((())())", "()"
        ));

        assertThat(Task3.clusterize("((())())())")).isEqualTo(null);

        for (int bracketNum = 1; bracketNum < 10; ++bracketNum) {
            assertThat(Task3.clusterize(new String(new char[bracketNum]).replace("\0", ")"))).isEqualTo(null);
        }
    }
}
