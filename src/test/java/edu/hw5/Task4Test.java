package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    static final String SYMBOLS = "~!@#$%^&*|";
    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz1234567890-+=()<>,./?\\\"`";

    @Test
    @DisplayName("Contains one of each symbol")
    void testContainOneSymbol() {
        String[] passwordTemplates = new String[]{
                "Hello?Hello?",
                "?????",
                "?",
                "sjknsd??ksdjnd?skdjnd",
                "sdncskdjcds?!()-=__+`;:<>,.JKlkm@NS",
                "1212e3?32e23e?1212e2"
        };
        for (String template : passwordTemplates) {
            char prevChar = '?';
            for (int i = 0; i < SYMBOLS.length(); ++i) {
                template = template.replace(prevChar, SYMBOLS.charAt(i));
                prevChar = SYMBOLS.charAt(i);
                assertThat(Task4.isCorrect(template)).isTrue();
            }
        }
    }

    @Test
    @DisplayName("Contains several symbols")
    void testContainSeveralSymbols() {
        Random random = new SecureRandom();
        for (int testN = 0; testN < 1000; ++testN) {
            StringBuilder newPassword = new StringBuilder();
            int newPasswordLength = 10 + random.nextInt(20); // Создаем случайный пароль из символов ALPHABET
            for (int i = 0; i < newPasswordLength; ++i) {
                newPassword.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
            }

            int symbolsCnt = 1 + random.nextInt(10); // Количество нужных символов в пароле

            // Вставляем случайный символ из SYMBOLS в случайное место в пароле
            for (int i = 0; i < symbolsCnt; ++i) {
                newPassword.insert(random.nextInt(newPassword.length()),
                        SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));
            }
            assertThat(Task4.isCorrect(newPassword.toString())).isTrue();
        }
    }

    @Test
    @DisplayName("Does not contain any symbols")
    void testDoesNotContain() {
        Random random = new SecureRandom();
        for (int testN = 0; testN < 1000; ++testN) {
            StringBuilder newPassword = new StringBuilder();
            int newPasswordLength = 10 + random.nextInt(20); // Создаем случайный пароль из символов ALPHABET
            for (int i = 0; i < newPasswordLength; ++i) {
                newPassword.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
            }
            assertThat(Task4.isCorrect(newPassword.toString())).isFalse();
        }
    }
}
