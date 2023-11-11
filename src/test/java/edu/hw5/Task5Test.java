package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Task5Test {
    @Test
    @DisplayName("Valid tags")
    void testValidTags() {
        String[] validTags = new String[]{
                "А123ВЕ777",
                "А123ВЕ777",
                "Р605КМ30",
                "К325ТТ40",
                "В321УУ797",
                "У444ХА977",
                "М594НО01",
                "С321СС02",
                "К309КС21",
                "Х412ВЕ38",
                "Х412ВЕ138",
        };
        for (String tags : validTags) {
            assertThat(Task5.isValidTag(tags)).isTrue();
        }
    }

    @Test
    @DisplayName("Invalid letter tags")
    void testInvalidLetterTags() {
        assertThatThrownBy(() -> Task5.isValidTag(null)).isInstanceOf(IllegalArgumentException.class);

        String[] invalidLetters = new String[]{
                "А123ВГ77",
                "Б399ФО199",
                "Б394АА40",
                "М111ЛН39",
                "Т493ТШ12",
                "Щ344УГ997"
        };


        for (String tags : invalidLetters) {
            assertThat(Task5.isValidTag(tags)).isFalse();
        }
    }

    @Test
    @DisplayName("Invalid region tags")
    void testInvalidTags() {
        assertThatThrownBy(() -> Task5.isValidTag(null)).isInstanceOf(IllegalArgumentException.class);

        String[] invalidRegions = new String[]{
                "123АВЕ777",
                "А123ВЕ7777",
                "A111AA20",
                "В222ВВ132",
                "А321КН139"
        };


        for (String tags : invalidRegions) {
            assertThat(Task5.isValidTag(tags)).isFalse();
        }
    }

    @Test
    @DisplayName("Other invalid cases")
    void testInvalid() {
        String[] invalidCases = new String[]{
                "HА123ВР777вл", // Excess letters
                "АВВ839ОР797", // В 839 ОР | 797  -- excess leters before and after valid tag
                "I123HJ12", // English letters
                "В222ВВЛЛ", // Letters instead of region
                "А3-1КН139" // Negative number
        };
        for (String tags : invalidCases) {
            assertThat(Task5.isValidTag(tags)).isFalse();
        }
    }
}
