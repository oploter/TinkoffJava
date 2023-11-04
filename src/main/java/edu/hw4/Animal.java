package edu.hw4;

import java.util.List;
import java.util.Random;

public record Animal(
        String name,
        Type type,
        Sex sex,
        int age,
        int height,
        int weight,
        boolean bites
) {
    private static final int FOUR_PAWS = 4;
    private static final int TWO_PAWS = 2;
    private static final int ZERO_PAWS = 0;
    private static final int EIGHT_PAWS = 8;
    private static final double FIFTY_PERCENT = 0.5;
    private static final int MAX_INT_VAL = 40;


    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> FOUR_PAWS;
            case BIRD -> TWO_PAWS;
            case FISH -> ZERO_PAWS;
            case SPIDER -> EIGHT_PAWS;
        };
    }

    private static final List<Type> TYPE_VALUES =
            List.of(Type.values());
    private static final int TYPE_SIZE = TYPE_VALUES.size();
    private static final Random RANDOM = new Random();

    public static Animal randomAnimalWithType(Type type) {
        return new Animal(
                "A" + type.toString() + Math.random(),
                type,
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                Math.random() < FIFTY_PERCENT
        );
    }


    public static Animal randomAnimalWithWeight(int weight) {
        Type type = TYPE_VALUES.get(RANDOM.nextInt(TYPE_SIZE));
        return new Animal(
                "A" + type.toString() + RANDOM.nextInt(),
                type,
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                weight,
                Math.random() < FIFTY_PERCENT
        );
    }

    public static Animal randomAnimalWithHeight(int height) {
        Type type = TYPE_VALUES.get(RANDOM.nextInt(TYPE_SIZE));
        return new Animal(
                "A" + type.toString() + RANDOM.nextInt(),
                type,
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                RANDOM.nextInt(MAX_INT_VAL),
                height,
                RANDOM.nextInt(MAX_INT_VAL),
                Math.random() < FIFTY_PERCENT
        );
    }

    public static Animal randomAnimalWithName(String name) {
        return new Animal(
                name,
                TYPE_VALUES.get(RANDOM.nextInt(TYPE_SIZE)),
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                Math.random() < FIFTY_PERCENT
        );
    }

    public static Animal randomAnimalWithSex(Sex sex) {
        Type type = TYPE_VALUES.get(RANDOM.nextInt(TYPE_SIZE));
        return new Animal(
                "A" + type.toString() + RANDOM.nextInt(),
                type,
                sex,
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                Math.random() < FIFTY_PERCENT
        );
    }

    public static Animal randomAnimalWithTypeAndWeight(Type type, int weight) {
        return new Animal(
                "A" + type.toString() + RANDOM.nextInt(),
                type,
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                weight,
                Math.random() < FIFTY_PERCENT
        );
    }

    public static Animal randomAnimalWithAgeAndType(int age, Type type) {
        return new Animal(
                "A" + type.toString() + RANDOM.nextInt(),
                type,
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                age,
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                Math.random() < FIFTY_PERCENT
        );
    }

    public static Animal randomAnimalWithBitesAndHeight(boolean bites, int height) {
        Type type = TYPE_VALUES.get(RANDOM.nextInt(TYPE_SIZE));
        return new Animal(
                "A" + type.toString() + RANDOM.nextInt(),
                type,
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                RANDOM.nextInt(MAX_INT_VAL),
                height,
                RANDOM.nextInt(MAX_INT_VAL),
                bites
        );
    }

    public static Animal randomAnimalWithWeightAndHeight(int weight, int height) {
        Type type = TYPE_VALUES.get(RANDOM.nextInt(TYPE_SIZE));
        return new Animal(
                "A" + type.toString() + RANDOM.nextInt(),
                type,
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                RANDOM.nextInt(MAX_INT_VAL),
                height,
                weight,
                Math.random() < FIFTY_PERCENT
        );
    }

    public static Animal randomAnimalWithTypeAndHeight(Type type, int height) {
        return new Animal(
                "A" + type.toString() + RANDOM.nextInt(),
                type,
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                RANDOM.nextInt(MAX_INT_VAL),
                height,
                RANDOM.nextInt(MAX_INT_VAL),
                Math.random() < FIFTY_PERCENT
        );
    }

    public static Animal randomAnimalWithTypeWeightAge(Type type, int weight, int age) {
        return new Animal(
                "A" + type.toString() + RANDOM.nextInt(),
                type,
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                age,
                RANDOM.nextInt(MAX_INT_VAL),
                weight,
                Math.random() < FIFTY_PERCENT
        );
    }

    public static Animal randomAnimalWithTypeSexName(Type type, Sex sex, String name) {
        return new Animal(
                name,
                type,
                sex,
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                Math.random() < FIFTY_PERCENT
        );
    }

    public static Animal randomAnimalWithTypeAndBites(Type type, boolean bites) {
        return new Animal(
                "A" + type.toString() + RANDOM.nextInt(),
                type,
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                bites
        );
    }

    public static Animal randomAnimalWithAge(int age) {
        Type type = TYPE_VALUES.get(RANDOM.nextInt(TYPE_SIZE));
        return new Animal(
                "A" + type.toString() + RANDOM.nextInt(),
                type,
                (Math.random() < FIFTY_PERCENT ? Sex.M : Sex.F),
                age,
                RANDOM.nextInt(MAX_INT_VAL),
                RANDOM.nextInt(MAX_INT_VAL),
                Math.random() < FIFTY_PERCENT
        );
    }

}
