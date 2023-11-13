package edu.hw4;

public record ValidationError(edu.hw4.ValidationError.Type type) {
    enum Type {
        NEGATIVE_AGE,
        NON_POSITIVE_HEIGHT,
        NON_POSITIVE_WEIGHT
    }

}
