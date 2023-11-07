package edu.hw3;

import edu.hw3.tsk5.Contact;
import edu.hw3.tsk5.Task5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Task5Test {
    @Test
    @DisplayName("Test1")
    void test1() {
        List<Contact> contacts1 = Task5.parseContacts(new String[]{"John Locke", "Thomas Aquinas",
                "David Hume", "Rene Descartes"}, "DESC");

        assertThat(contacts1).isEqualTo(Arrays.asList(
                new Contact("John", "Locke"),
                new Contact("David", "Hume"),
                new Contact("Rene", "Descartes"),
                new Contact("Thomas", "Aquinas")
        ));


        List<Contact> contacts2 = Task5.parseContacts(new String[]{"John Locke", "Thomas Aquinas",
                "David Hume", "Rene Descartes"}, "ASC");

        assertThat(contacts2).isEqualTo(Arrays.asList(
                new Contact("Thomas", "Aquinas"),
                new Contact("Rene", "Descartes"),
                new Contact("David", "Hume"),
                new Contact("John", "Locke")
        ));

    }

    @Test
    @DisplayName("Test2")
    void test2() {
        List<Contact> contacts1 = Task5.parseContacts(new String[]{"Paul Erdos",
                "Leonhard Euler", "Carl Gauss"}, "DESC");


        assertThat(contacts1).isEqualTo(Arrays.asList(
                new Contact("Carl", "Gauss"),
                new Contact("Leonhard", "Euler"),
                new Contact("Paul", "Erdos")
        ));

        List<Contact> contacts2 = Task5.parseContacts(new String[]{"Paul Erdos",
                "Leonhard Euler", "Carl Gauss"}, "ASC");

        assertThat(contacts2).isEqualTo(Arrays.asList(
                new Contact("Paul", "Erdos"),
                new Contact("Leonhard", "Euler"),
                new Contact("Carl", "Gauss")
        ));
    }

    @Test
    @DisplayName("Empty and null")
    void testEmptyAndNull() {
        List<Contact> contacts1 = Task5.parseContacts(new String[]{}, "DESC");
        assertThat(contacts1).isEmpty();

        List<Contact> contacts2 = Task5.parseContacts(null, "DESC");
        assertThat(contacts2).isEmpty();
    }

    @Test
    @DisplayName("Containing nulls")
    void testContainingNulls() {
        String[] names = new String[]{
                "T D",
                "T D",
                "R A",
                "A E",
                "R",
                "F",
                "B",
                null,
                null,
                null,
                "L I"
        };

        List<Contact> contacts1 = Task5.parseContacts(names, "ASC");
        assertThat(contacts1).isEqualTo(Arrays.asList(
                null,
                null,
                null,
                new Contact("R", "A"),
                new Contact("B"),
                new Contact("T", "D"),
                new Contact("T", "D"),
                new Contact("A", "E"),
                new Contact("F"),
                new Contact("L", "I"),
                new Contact("R")
        ));

        List<Contact> contacts2 = Task5.parseContacts(names, "DESC");
        assertThat(contacts2).isEqualTo(Arrays.asList(
                new Contact("R"),
                new Contact("L", "I"),
                new Contact("F"),
                new Contact("A", "E"),
                new Contact("T", "D"),
                new Contact("T", "D"),
                new Contact("B"),
                new Contact("R", "A"),
                null,
                null,
                null
        ));
    }

    @Test
    @DisplayName("Contains multi-word names")
    void testMultiWordNames() {
        String[] names = new String[]{
                "A B C",
                "A BC",
                "B"
        };
        List<Contact> contacts = Task5.parseContacts(names, "ASC");
        assertThat(contacts).isEqualTo(Arrays.asList(
                new Contact("B"),
                new Contact("A", "B C"),
                new Contact("A", "BC")
        ));
    }
}
