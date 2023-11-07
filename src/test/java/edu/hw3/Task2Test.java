package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("List of strings")
    void testString() {
        List<String> l1 = Arrays.asList("a", "bb", "a", "bb");
        assertThat(Task2.freqDict(l1)).isEqualTo(Map.ofEntries(
                Map.entry("bb", 2),
                Map.entry("a", 2)
        ));

        List<String> l2 = Arrays.asList("a", "про", "bbv", "    ");
        assertThat(Task2.freqDict(l2)).isEqualTo(Map.ofEntries(
                Map.entry("a", 1),
                Map.entry("про", 1),
                Map.entry("bbv", 1),
                Map.entry("    ", 1)
        ));

        List<String> l3 = Arrays.asList("1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
        assertThat(Task2.freqDict(l3)).isEqualTo(Map.ofEntries(
                Map.entry("1", 10)
        ));

        List<String> l4 = Arrays.asList("this", "and", "that", "and");
        assertThat(Task2.freqDict(l4)).isEqualTo(Map.ofEntries(
                Map.entry("and", 2),
                Map.entry("this", 1),
                Map.entry("that", 1)
        ));

        List<String> l5 = Arrays.asList("код", "код", "код", "bug");
        assertThat(Task2.freqDict(l5)).isEqualTo(Map.ofEntries(
                Map.entry("код", 3),
                Map.entry("bug", 1)
        ));
    }

    @Test
    @DisplayName("Return null if, null is element in list")
    void testNullAsElement() {
        List<String> l1 = Arrays.asList("a", null, "про", "blp", "     ");
        assertThat(Task2.freqDict(l1)).isNull();

        List<Integer> l2 = Arrays.asList(12, 32, null);
        assertThat(Task2.freqDict(l2)).isNull();
    }

    @Test
    @DisplayName("Empty list")
    void testEmpty() {
        List<String> l1 = new ArrayList<>();
        assertThat(Task2.freqDict(l1)).isEqualTo(Map.of());

        List<Integer> l2 = new ArrayList<>();
        assertThat(Task2.freqDict(l2)).isEqualTo(Map.of());
    }

    @Test
    @DisplayName("List of integers")
    void testIntegers() {
        List<Integer> l1 = Arrays.asList(1, 1, 2, 2);
        assertThat(Task2.freqDict(l1)).isEqualTo(Map.ofEntries(
                Map.entry(1, 2),
                Map.entry(2, 2)
        ));

        List<Integer> l2 = Arrays.asList(23, 23, 23, 23, 23);
        assertThat(Task2.freqDict(l2)).isEqualTo(Map.of(23, 5));

        List<Integer> l3 = Arrays.asList(-1, 0, 1, 2, 3, 4, 5);
        assertThat(Task2.freqDict(l3)).isEqualTo(Map.ofEntries(
                Map.entry(-1, 1),
                Map.entry(0, 1),
                Map.entry(1, 1),
                Map.entry(2, 1),
                Map.entry(3, 1),
                Map.entry(4, 1),
                Map.entry(5, 1)
        ));
    }

    private static class CustomObject {
        private final String seq;

        public CustomObject(String seq) {
            this.seq = seq;
        }

        @Override
        public boolean equals(Object obj) {
            /* Объекты одинаковы, если совпадают упорядоченные наборы их последовательностей */
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            CustomObject that = (CustomObject) obj;
            char[] chars1 = seq.toCharArray();
            char[] chars2 = that.seq.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            return Arrays.equals(chars1, chars2);
        }

        @Override
        public int hashCode() {
            char[] charSeq = seq.toCharArray();
            Arrays.sort(charSeq);
            String s = new String(charSeq);
            return s.hashCode();
        }
    }

    private static CustomObject getCustomObj(String s) {
        return new CustomObject(s);
    }

    @Test
    @DisplayName("Custom object")
    void testCustomObject() {
        List<CustomObject> l1 = new ArrayList<>();
        l1.add(getCustomObj("abc"));
        l1.add(getCustomObj("cba"));
        l1.add(getCustomObj("aaa"));
        l1.add(getCustomObj("aab"));
        l1.add(getCustomObj("baa"));
        l1.add(getCustomObj("aba"));
        l1.add(getCustomObj("bca"));
        l1.add(getCustomObj("cab"));

        assertThat(getCustomObj("abc")).isEqualTo(getCustomObj("bac"));

        assertThat(Task2.freqDict(l1)).isEqualTo(Map.ofEntries(
                Map.entry(getCustomObj("abc"), 4),
                Map.entry(getCustomObj("aaa"), 1),
                Map.entry(getCustomObj("baa"), 3)
        ));

        assertThat(Task2.freqDict(l1)).isEqualTo(Map.ofEntries(
                Map.entry(getCustomObj("cba"), 4),
                Map.entry(getCustomObj("aaa"), 1),
                Map.entry(getCustomObj("aba"), 3)
        ));
    }

    @Test
    @DisplayName("List of set of integers")
    void testListOfSets() {
        List<Set<Integer>> l1 = Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3)),
                new HashSet<>(Arrays.asList(1, 1, 2, 2, 2, 3, 3, 3, 3)),
                new HashSet<>(Arrays.asList(-1, -1, 2, 2, 0)),
                new HashSet<>(Arrays.asList(-1, -1, -1, 2, 2, 0, 0))
        );

        assertThat(Task2.freqDict(l1)).isEqualTo(Map.ofEntries(
                Map.entry(new HashSet<>(Arrays.asList(1, 2, 3)), 2),
                Map.entry(new HashSet<>(Arrays.asList(-1, 2, 0)), 2)
        ));
    }
}
