package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class Task7Test {
    @Test
    @DisplayName("Test")
    void test() {

        TreeMap<String, String> tree1 = new TreeMap<>(Comparator.naturalOrder());
        // tree1.put(null, "shouldn't add");
        assertThatThrownBy(() -> tree1.put(null, "throw")).isInstanceOf(NullPointerException.class);


        assertThat(tree1.containsKey(null)).isFalse();

        TreeMap<String, String> tree2 = new TreeMap<>(new Task7<String>(Comparator.naturalOrder()));
        tree2.put(null, "test");

        assertThat(tree2.containsKey(null)).isTrue();

    }
}
