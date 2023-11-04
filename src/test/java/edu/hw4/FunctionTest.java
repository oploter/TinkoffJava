package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {

    @Test
    @DisplayName("Test task 1")
    void test1() {
        List<Animal> animals = Arrays.asList(
                Animal.randomAnimalWithHeight(10), // 0
                Animal.randomAnimalWithHeight(1),  // 1
                Animal.randomAnimalWithHeight(2),  // 2
                Animal.randomAnimalWithHeight(5),  // 3
                Animal.randomAnimalWithHeight(3),  // 4
                Animal.randomAnimalWithHeight(8),  // 5
                Animal.randomAnimalWithHeight(50), // 6
                Animal.randomAnimalWithHeight(3)   // 7
        );

        List<Integer> sortedHeightAscIndexes = Arrays.asList(1, 2, 4, 7, 3, 5, 0, 6);
        var animalsSorted = Task1.task1(animals);
        for (int i = 0; i < animals.size(); ++i) {
            assertThat(animalsSorted.get(i)).isEqualTo(animals.get(sortedHeightAscIndexes.get(i)));
        }

        assertThat(Task1.task1(null)).isNull();
    }

    @Test
    @DisplayName("Test task 2")
    void test2() {
        List<Animal> animals1 = Arrays.asList(
                Animal.randomAnimalWithWeight(1), // 0
                Animal.randomAnimalWithWeight(2), // 1
                Animal.randomAnimalWithWeight(3), // 2
                Animal.randomAnimalWithWeight(4), // 3
                Animal.randomAnimalWithWeight(5), // 4
                Animal.randomAnimalWithWeight(10),// 5
                Animal.randomAnimalWithWeight(9), // 6
                Animal.randomAnimalWithWeight(8), // 7
                Animal.randomAnimalWithWeight(13),// 8
                Animal.randomAnimalWithWeight(7)  // 9
        );
        List<Integer> sortedWeightDescIndexes = Arrays.asList(8, 5, 6, 7, 9, 4, 3, 2, 1, 0);

        for (int k = 0; k < animals1.size(); ++k) {
            var animalsSorted = Task1.task2(animals1, k);
            for (int i = 0; i < k; ++i) {
                assertThat(animalsSorted.get(i)).isEqualTo(animals1.get(sortedWeightDescIndexes.get(i)));
            }
        }

        assertThat(Task1.task2(null, 100)).isNull();
        assertThat(Task1.task2(Collections.emptyList(), -1)).isNull();

    }


    @Test
    @DisplayName("Test task 3")
    void test3() {
        final int MAX_NUM = 20;
        for (int catNum = 0; catNum < MAX_NUM; ++catNum) {
            for (int dogNum = 0; dogNum < MAX_NUM; ++dogNum) {
                for (int fishNum = 0; fishNum < MAX_NUM; ++fishNum) {
                    for (int birdNum = 0; birdNum < MAX_NUM; ++birdNum) {
                        for (int spiderNum = 0; spiderNum < MAX_NUM; ++spiderNum) {
                            List<Animal> animals = new ArrayList<>();

                            animals.addAll(Collections.nCopies(catNum,
                                    Animal.randomAnimalWithType(Animal.Type.CAT)));
                            animals.addAll(Collections.nCopies(dogNum,
                                    Animal.randomAnimalWithType(Animal.Type.DOG)));
                            animals.addAll(Collections.nCopies(fishNum,
                                    Animal.randomAnimalWithType(Animal.Type.FISH)));
                            animals.addAll(Collections.nCopies(birdNum,
                                    Animal.randomAnimalWithType(Animal.Type.BIRD)));
                            animals.addAll(Collections.nCopies(spiderNum,
                                    Animal.randomAnimalWithType(Animal.Type.SPIDER)));

                            Map<Animal.Type, Integer> typeCnt = Task1.task3(animals);

                            assertThat(typeCnt).isEqualTo(Map.of(
                                    Animal.Type.CAT, catNum,
                                    Animal.Type.DOG, dogNum,
                                    Animal.Type.FISH, fishNum,
                                    Animal.Type.BIRD, birdNum,
                                    Animal.Type.SPIDER, spiderNum
                            ));
                        }
                    }
                }
            }
        }

    }
    
    @Test
    @DisplayName("Test task 4")
    void test4() {
        List<Animal> animals1 = Arrays.asList(
                Animal.randomAnimalWithName("A"),   // 0
                Animal.randomAnimalWithName("B"),   // 1
                Animal.randomAnimalWithName("AA"),  // 2
                Animal.randomAnimalWithName("BB"),  // 3
                Animal.randomAnimalWithName("CC"),  // 4
                Animal.randomAnimalWithName("DDD"), // 5
                Animal.randomAnimalWithName("D"),   // 6
                Animal.randomAnimalWithName("YU")   // 7
        );
        Animal maxNameLengthAnimal1 = Task1.task4(animals1);
        assertThat(maxNameLengthAnimal1).isEqualTo(animals1.get(5));

        List<Animal> animals2 = Arrays.asList(
                Animal.randomAnimalWithName("A"),   // 0
                Animal.randomAnimalWithName("B"),   // 1
                Animal.randomAnimalWithName("AA"),  // 2
                Animal.randomAnimalWithName("BB"),  // 3
                //Animal.randomAnimalWithName("CC"),  // 4
                //Animal.randomAnimalWithName("DDD"), // 5
                Animal.randomAnimalWithName("D"),   // 6
                Animal.randomAnimalWithName("YU")   // 7
        );
        Animal maxNameLengthAnimal2 = Task1.task4(animals2);
        assertThat(maxNameLengthAnimal2).isNull();

        List<Animal> animals3 = List.of(
                Animal.randomAnimalWithName("A")
        );
        Animal maxNameLengthAnimal3 = Task1.task4(animals3);
        assertThat(maxNameLengthAnimal3).isEqualTo(animals3.get(0));


        assertThat(Task1.task4(null)).isNull();
    }

    @Test
    @DisplayName("Test task 5")
    void test5() {
        List<Animal> animals1 = Arrays.asList(
                Animal.randomAnimalWithSex(Animal.Sex.M),
                Animal.randomAnimalWithSex(Animal.Sex.M),
                Animal.randomAnimalWithSex(Animal.Sex.M),
                Animal.randomAnimalWithSex(Animal.Sex.F)
        );
        assertThat(Task1.task5(animals1)).isEqualTo(Animal.Sex.M);

        List<Animal> animals2 = List.of();
        assertThat(Task1.task5(animals2)).isNull();

        List<Animal> animals3 = Arrays.asList(
                Animal.randomAnimalWithSex(Animal.Sex.M),
                Animal.randomAnimalWithSex(Animal.Sex.M),
                Animal.randomAnimalWithSex(Animal.Sex.F),
                Animal.randomAnimalWithSex(Animal.Sex.F)
        );
        assertThat(Task1.task5(animals3)).isNull();

        List<Animal> animals4 = List.of(
                Animal.randomAnimalWithSex(Animal.Sex.M)
        );
        assertThat(Task1.task5(animals4)).isEqualTo(Animal.Sex.M);

        List<Animal> animals5 = List.of(
                Animal.randomAnimalWithSex(Animal.Sex.F)
        );
        assertThat(Task1.task5(animals5)).isEqualTo(Animal.Sex.F);

        List<Animal> animals6 = Arrays.asList(
                Animal.randomAnimalWithSex(Animal.Sex.F),
                Animal.randomAnimalWithSex(Animal.Sex.F),
                Animal.randomAnimalWithSex(Animal.Sex.F),
                Animal.randomAnimalWithSex(Animal.Sex.M),
                Animal.randomAnimalWithSex(Animal.Sex.M),
                Animal.randomAnimalWithSex(Animal.Sex.M),
                Animal.randomAnimalWithSex(Animal.Sex.M)
        );
        assertThat(Task1.task5(animals6)).isEqualTo(Animal.Sex.M);
    }

    @Test
    @DisplayName("Test task 6")
    void test6() {
        List<Animal> animals1 = Arrays.asList(
                Animal.randomAnimalWithTypeAndWeight(Animal.Type.CAT, 10), // 0
                Animal.randomAnimalWithTypeAndWeight(Animal.Type.CAT, 11), // 1
                Animal.randomAnimalWithTypeAndWeight(Animal.Type.CAT, 5),  // 2

                Animal.randomAnimalWithTypeAndWeight(Animal.Type.DOG, 1),  // 3
                Animal.randomAnimalWithTypeAndWeight(Animal.Type.DOG, 2),  // 4
                Animal.randomAnimalWithTypeAndWeight(Animal.Type.DOG, 3),  // 5

                Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 1), // 6

                Animal.randomAnimalWithTypeAndWeight(Animal.Type.BIRD, 2), // 7
                Animal.randomAnimalWithTypeAndWeight(Animal.Type.BIRD, 3)  // 8
        );

        Map<Animal.Type, Animal> animalMap1 = Task1.task6(animals1);
        assertThat(animalMap1).isEqualTo(Map.of(
                Animal.Type.DOG, animals1.get(5),
                Animal.Type.BIRD, animals1.get(8),
                Animal.Type.FISH, animals1.get(6),
                Animal.Type.CAT, animals1.get(1)
        ));
    }

    @Test
    @DisplayName("Test task 7")
    void test7() {
        List<Animal> animals1 = Arrays.asList(  // Weight order
                Animal.randomAnimalWithAge(9),  //  2
                Animal.randomAnimalWithAge(2),  //  9
                Animal.randomAnimalWithAge(1),  //  10
                Animal.randomAnimalWithAge(5),  //  6
                Animal.randomAnimalWithAge(10), //  1
                Animal.randomAnimalWithAge(8),  //  3
                Animal.randomAnimalWithAge(4),  //  7
                Animal.randomAnimalWithAge(3),  //  8
                Animal.randomAnimalWithAge(7),  //  4
                Animal.randomAnimalWithAge(6)   //  5
        );
        assertThat(Task1.task7(animals1, 0)).isNull();
        for (int k = 1; k <= 10; ++k) {
            assertThat(Task1.task7(animals1, k).age()).isEqualTo(11 - k);
        }
        assertThat(Task1.task7(animals1, 11)).isNull();

        for (int k = -1; k <= 10; ++k) {
            assertThat(Task1.task7(new ArrayList<>(), k)).isNull();
        }

        List<Animal> animals2 = Arrays.asList(
                Animal.randomAnimalWithAge(1),
                Animal.randomAnimalWithAge(2),
                Animal.randomAnimalWithAge(1),
                Animal.randomAnimalWithAge(1),
                Animal.randomAnimalWithAge(2),
                Animal.randomAnimalWithAge(2),
                Animal.randomAnimalWithAge(2)
        );

        assertThat(Task1.task7(animals2, 0)).isNull();
        for (int k = 1; k <= 4; ++k) {
            assertThat(Task1.task7(animals2, k).age()).isEqualTo(2);
        }
        for (int k = 5; k <= 7; ++k) {
            assertThat(Task1.task7(animals2, k).age()).isEqualTo(1);
        }
    }


    @Test
    @DisplayName("Test task 8")
    void test8() {
        assertThat(Task1.task8(null, 10)).isEmpty();

        List<Animal> animals1 = Arrays.asList(                  // index
                Animal.randomAnimalWithWeightAndHeight(1, 1),   // 0
                Animal.randomAnimalWithWeightAndHeight(2, 2),   // 1
                Animal.randomAnimalWithWeightAndHeight(100, 3), // 2
                Animal.randomAnimalWithWeightAndHeight(10, 4),  // 3
                Animal.randomAnimalWithWeightAndHeight(12, 5),  // 4
                Animal.randomAnimalWithWeightAndHeight(3, 3)   // 5
        );

        assertThat(Task1.task8(animals1, -1)).isEmpty();
        assertThat(Task1.task8(animals1, 0)).isEmpty();
        assertThat(Task1.task8(animals1, 1)).isEmpty();
        assertThat(Task1.task8(animals1, 2).orElse(null)).isEqualTo(animals1.get(0));
        assertThat(Task1.task8(animals1, 3).orElse(null)).isEqualTo(animals1.get(1));
        assertThat(Task1.task8(animals1, 4).orElse(null)).isEqualTo(animals1.get(2));
        assertThat(Task1.task8(animals1, 5).orElse(null)).isEqualTo(animals1.get(2));
        assertThat(Task1.task8(animals1, 6).orElse(null)).isEqualTo(animals1.get(2));
    }

    @Test
    @DisplayName("Test task 9")
    void test9() {
        assertThat(Task1.task9(null)).isNull();

        List<Animal> animals1 = Arrays.asList(
                Animal.randomAnimalWithType(Animal.Type.CAT),
                Animal.randomAnimalWithType(Animal.Type.BIRD),
                Animal.randomAnimalWithType(Animal.Type.DOG),
                Animal.randomAnimalWithType(Animal.Type.FISH),
                Animal.randomAnimalWithType(Animal.Type.SPIDER)
        );
        assertThat(Task1.task9(animals1)).isEqualTo(18);

        List<Animal> animals2 = Arrays.asList(
                Animal.randomAnimalWithType(Animal.Type.CAT),
                Animal.randomAnimalWithType(Animal.Type.DOG),
                Animal.randomAnimalWithType(Animal.Type.CAT),
                Animal.randomAnimalWithType(Animal.Type.CAT),
                Animal.randomAnimalWithType(Animal.Type.CAT),
                Animal.randomAnimalWithType(Animal.Type.DOG)
        );
        assertThat(Task1.task9(animals2)).isEqualTo(24);

        List<Animal> animals3 = new ArrayList<>();
        assertThat(Task1.task9(animals3)).isEqualTo(0);

        List<Animal> animals4 = List.of(Animal.randomAnimalWithType(Animal.Type.CAT));
        assertThat(Task1.task9(animals4)).isEqualTo(4);

        List<Animal> animals5 = List.of(Animal.randomAnimalWithType(Animal.Type.DOG));
        assertThat(Task1.task9(animals5)).isEqualTo(4);

        List<Animal> animals6 = List.of(Animal.randomAnimalWithType(Animal.Type.FISH));
        assertThat(Task1.task9(animals6)).isEqualTo(0);

        List<Animal> animals7 = List.of(Animal.randomAnimalWithType(Animal.Type.BIRD));
        assertThat(Task1.task9(animals7)).isEqualTo(2);

        List<Animal> animals8 = List.of(Animal.randomAnimalWithType(Animal.Type.SPIDER));
        assertThat(Task1.task9(animals8)).isEqualTo(8);

        List<Animal> animals9 = Arrays.asList(
                Animal.randomAnimalWithType(Animal.Type.FISH),
                Animal.randomAnimalWithType(Animal.Type.FISH),
                Animal.randomAnimalWithType(Animal.Type.FISH),

                Animal.randomAnimalWithType(Animal.Type.DOG),
                Animal.randomAnimalWithType(Animal.Type.SPIDER)
        );
        assertThat(Task1.task9(animals9)).isEqualTo(12);
    }

    @Test
    @DisplayName("Test task 10")
    void test10() {
        assertThat(Task1.task10(null)).isNull();

        List<Animal> animals1 = List.of(                                    // Index    Age     Paws
                Animal.randomAnimalWithAgeAndType(4, Animal.Type.CAT),      // 0        4       4
                Animal.randomAnimalWithAgeAndType(4, Animal.Type.DOG),      // 1        4       4
                Animal.randomAnimalWithAgeAndType(0, Animal.Type.FISH),     // 2        0       0
                Animal.randomAnimalWithAgeAndType(2, Animal.Type.BIRD),     // 3        2       2
                Animal.randomAnimalWithAgeAndType(8, Animal.Type.SPIDER)    // 4        8       8
        );
        assertThat(Task1.task10(animals1)).isEmpty();

        List<Animal> animals2 = List.of(                                    // Index    Age     Paws
                Animal.randomAnimalWithAgeAndType(1, Animal.Type.CAT),      // 0        1       4
                Animal.randomAnimalWithAgeAndType(2, Animal.Type.SPIDER),   // 1        2       8
                Animal.randomAnimalWithAgeAndType(32, Animal.Type.CAT),     // 2        32      4
                Animal.randomAnimalWithAgeAndType(2, Animal.Type.FISH),     // 3        2       0
                Animal.randomAnimalWithAgeAndType(4, Animal.Type.DOG),      // 4        4       4
                Animal.randomAnimalWithAgeAndType(2, Animal.Type.BIRD)      // 5        2       2
        );
        assertThat(Task1.task10(animals2)).isEqualTo(List.of(
                animals2.get(0),
                animals2.get(1),
                animals2.get(2),
                animals2.get(3)
        ));
    }

    @Test
    @DisplayName("Test task 11")
    void test11() {
        List<Animal> animals1 = Arrays.asList(                      // Index    Predicate
                Animal.randomAnimalWithBitesAndHeight(true, 100),   // 0        false
                Animal.randomAnimalWithBitesAndHeight(true, 101),   // 1        true
                Animal.randomAnimalWithBitesAndHeight(false, 200),  // 2        false
                Animal.randomAnimalWithBitesAndHeight(false, 3000), // 3        false
                Animal.randomAnimalWithBitesAndHeight(true, 200),   // 4        true
                Animal.randomAnimalWithBitesAndHeight(true, 300),   // 5        true
                Animal.randomAnimalWithBitesAndHeight(true, 30)    // 6        false
        );
        assertThat(Task1.task11(animals1)).isEqualTo(Arrays.asList(
                animals1.get(1),
                animals1.get(4),
                animals1.get(5)
        ));

        assertThat(Task1.task11(null)).isNull();
        assertThat(Task1.task11(new ArrayList<>())).isEmpty();
    }

    @Test
    @DisplayName("Test task 12")
    void test12() {
        assertThat(Task1.task12(null)).isNull();
        assertThat(Task1.task12(new ArrayList<>())).isEqualTo(0);

        List<Animal> animals1 = Arrays.asList(                      // Index  Predicate
                Animal.randomAnimalWithWeightAndHeight(100, 11),    // 0      true
                Animal.randomAnimalWithWeightAndHeight(100, 1000),  // 1      false
                Animal.randomAnimalWithWeightAndHeight(12, 13),     // 2      false
                Animal.randomAnimalWithWeightAndHeight(1, 12),      // 3      false
                Animal.randomAnimalWithWeightAndHeight(300, 200),   // 4      true
                Animal.randomAnimalWithWeightAndHeight(321, 123),   // 5      true
                Animal.randomAnimalWithWeightAndHeight(100, 100),   // 6      false
                Animal.randomAnimalWithWeightAndHeight(20, 20),     // 7      false
                Animal.randomAnimalWithWeightAndHeight(10, 30)      // 8      false
        );
        assertThat(Task1.task12(animals1)).isEqualTo(3);

        List<Animal> animals2 = Arrays.asList(                  // Index    Predicate
                Animal.randomAnimalWithWeightAndHeight(1, 1),   // 0        false
                Animal.randomAnimalWithWeightAndHeight(2, 2),   // 1        false
                Animal.randomAnimalWithWeightAndHeight(1, 1),   // 2        false
                Animal.randomAnimalWithWeightAndHeight(2, 2),   // 3        false
                Animal.randomAnimalWithWeightAndHeight(3, 3)    // 4        false
        );
        assertThat(Task1.task12(animals2)).isEqualTo(0);

        List<Animal> animals3 = Arrays.asList(                   // Index    Predicate
                Animal.randomAnimalWithWeightAndHeight(10, 1),   // 0        true
                Animal.randomAnimalWithWeightAndHeight(20, 2),   // 1        true
                Animal.randomAnimalWithWeightAndHeight(10, 1),   // 2        true
                Animal.randomAnimalWithWeightAndHeight(20, 2),   // 3        true
                Animal.randomAnimalWithWeightAndHeight(30, 3)    // 4        true
        );
        assertThat(Task1.task12(animals3)).isEqualTo(5);
    }

    @Test
    @DisplayName("Test task 13")
    void test13() {
        assertThat(Task1.task13(null)).isNull();
        assertThat(Task1.task13(new ArrayList<>())).isEmpty();

        List<Animal> animals1 = Arrays.asList(                 // index   predicate
                Animal.randomAnimalWithName("A"),              // 0       false
                Animal.randomAnimalWithName("A A"),            // 1       false
                Animal.randomAnimalWithName("A A A"),          // 2       true
                Animal.randomAnimalWithName("A A A A"),        // 3       true
                Animal.randomAnimalWithName("A A A A A"),      // 4       true
                Animal.randomAnimalWithName("A A A A A A"),    // 5       true
                Animal.randomAnimalWithName("ABCD"),           // 6       false
                Animal.randomAnimalWithName("ABCD JD"),        // 7       false
                Animal.randomAnimalWithName("AJD JDK DJKN KND")// 8       true
        );
        assertThat(Task1.task13(animals1)).isEqualTo(List.of(
                animals1.get(2),
                animals1.get(3),
                animals1.get(4),
                animals1.get(5),
                animals1.get(8)
        ));

        List<Animal> animals2 = Arrays.asList(
                Animal.randomAnimalWithName("A A A"),
                Animal.randomAnimalWithName("A A A"),
                Animal.randomAnimalWithName("a a a")
        );
        assertThat(Task1.task13(animals2)).isEqualTo(List.of(
                animals2.get(0),
                animals2.get(1),
                animals2.get(2)
        ));

        List<Animal> animals3 = Arrays.asList(
                Animal.randomAnimalWithName("ak"),
                Animal.randomAnimalWithName("akl alkm"),
                Animal.randomAnimalWithName("ajknkjansjkadn"),
                Animal.randomAnimalWithName("1234kml4321lkml23")
        );
        assertThat(Task1.task13(animals3)).isEmpty();
    }

    @Test
    @DisplayName("Test task 14")
    void test14() {
        assertThat(Task1.task14(null, 10)).isNull();
        assertThat(Task1.task14(new ArrayList<>(), 10)).isFalse();

        List<Animal> noDogType = Arrays.asList(
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.CAT, 100),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.BIRD, 10),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.FISH, 123),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.SPIDER, 1)
        );
        assertThat(Task1.task14(noDogType, 0)).isFalse();

        List<Animal> dogButShort = Arrays.asList(
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.FISH, 1000),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.DOG, 1),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.DOG, 2),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.DOG, 3),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.DOG, 5),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.CAT, 500),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.FISH, 250),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.SPIDER, 400)
        );
        assertThat(Task1.task14(dogButShort, 100)).isFalse();

        List<Animal> okayDogs = Arrays.asList(
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.DOG, 100),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.DOG, 1000),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.DOG, 500),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.FISH, 120),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.CAT, 230),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.FISH, 2),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.SPIDER, 32),
                Animal.randomAnimalWithTypeAndHeight(Animal.Type.DOG, 2)
        );
        assertThat(Task1.task14(okayDogs, 100)).isTrue();
        assertThat(Task1.task14(okayDogs, 2000)).isFalse();
    }

    @Test
    @DisplayName("Test task 15")
    void test15() {
        List<Animal> animals1 = Arrays.asList(                                  // predicate
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 1, 1),    // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 2, 2),    // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 3, 3),    // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 1, 11),   // true     1
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 2, 12),   // true     2
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 3, 13),   // true     3
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 4, 14),   // true     4
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 5, 30),   // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 6, 40),   // false

                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 5, 1),    // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 1, 1),    // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 2, 2),    // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 3, 3),    // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 10, 10),  // true     10
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 20, 12),  // true     20
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 30, 19),  // true     30
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 50, 21),  // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 6, 24),   // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 54, 30),  // false

                Animal.randomAnimalWithTypeWeightAge(Animal.Type.FISH, 1, 1),   // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.FISH, 2, 10),  // true     2
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.FISH, 3, 12),  // true     3
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.FISH, 10, 300),// false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.FISH, 20, 200),// false

                Animal.randomAnimalWithTypeWeightAge(Animal.Type.SPIDER, 2, 2), // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.SPIDER, 3, 9), // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.SPIDER, 33, 12),// true    33
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.SPIDER, 40, 40),// false

                Animal.randomAnimalWithTypeWeightAge(Animal.Type.BIRD, 1, 1),   // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.BIRD, 2, 2),   // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.BIRD, 30, 30), // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.BIRD, 40, 40)  // false
        );

        assertThat(Task1.task15(animals1, 10, 20)).isEqualTo(Map.of(
                Animal.Type.DOG, 10,
                Animal.Type.CAT, 60,
                Animal.Type.FISH, 5,
                Animal.Type.SPIDER, 33,
                Animal.Type.BIRD, 0
        ));

        List<Animal> animals2 = Arrays.asList(                                  // predicate
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 10, 10),  // true         10
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 20, 20),  // true         20
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.DOG, 30, 30),  // true         30

                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 1, 1),    // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 2, 2),    // false
                Animal.randomAnimalWithTypeWeightAge(Animal.Type.CAT, 3, 3)     // false
        );
        assertThat(Task1.task15(animals2, 10, 40)).isEqualTo(Map.of(
                Animal.Type.DOG, 60,
                Animal.Type.CAT, 0
        ));
    }

    @Test
    @DisplayName("Test task 16")
    void test16() {
        List<Animal> animals1 = Arrays.asList(                                           // index    order
                Animal.randomAnimalWithTypeSexName(Animal.Type.DOG, Animal.Sex.F, "B"), // 0        5
                Animal.randomAnimalWithTypeSexName(Animal.Type.CAT, Animal.Sex.M, "C"), // 1        0
                Animal.randomAnimalWithTypeSexName(Animal.Type.CAT, Animal.Sex.F, "D"), // 2        3
                Animal.randomAnimalWithTypeSexName(Animal.Type.DOG, Animal.Sex.M, "F"), // 3        4
                Animal.randomAnimalWithTypeSexName(Animal.Type.DOG, Animal.Sex.F, "E"), // 4        6
                Animal.randomAnimalWithTypeSexName(Animal.Type.CAT, Animal.Sex.M, "X"), // 5        2
                Animal.randomAnimalWithTypeSexName(Animal.Type.CAT, Animal.Sex.M, "T")  // 6        1
        );
        assertThat(Task1.task16(animals1)).isEqualTo(List.of(
                animals1.get(1),
                animals1.get(6),
                animals1.get(5),
                animals1.get(2),
                animals1.get(3),
                animals1.get(0),
                animals1.get(4)
        ));

        List<Animal> sameType = Arrays.asList(                                                  // index order
                Animal.randomAnimalWithTypeSexName(Animal.Type.FISH, Animal.Sex.M, "ABC DEF"),  // 0     1
                Animal.randomAnimalWithTypeSexName(Animal.Type.FISH, Animal.Sex.M, "ABC EF"),   // 1     2
                Animal.randomAnimalWithTypeSexName(Animal.Type.FISH, Animal.Sex.M, "A"),        // 2     0
                Animal.randomAnimalWithTypeSexName(Animal.Type.FISH, Animal.Sex.M, "BB"),       // 3     3
                Animal.randomAnimalWithTypeSexName(Animal.Type.FISH, Animal.Sex.F, "A"),        // 4     4
                Animal.randomAnimalWithTypeSexName(Animal.Type.FISH, Animal.Sex.F, "FER"),      // 5     6
                Animal.randomAnimalWithTypeSexName(Animal.Type.FISH, Animal.Sex.F, "FAR"),      // 6     5
                Animal.randomAnimalWithTypeSexName(Animal.Type.FISH, Animal.Sex.F, "TRE")       // 7     7
        );
        assertThat(Task1.task16(sameType)).isEqualTo(List.of(
                sameType.get(2),
                sameType.get(0),
                sameType.get(1),
                sameType.get(3),
                sameType.get(4),
                sameType.get(6),
                sameType.get(5),
                sameType.get(7)
        ));

        List<Animal> sameTypeAndSex = Arrays.asList(                                        // index    order
                Animal.randomAnimalWithTypeSexName(Animal.Type.BIRD, Animal.Sex.M, "12G"),  // 0        0
                Animal.randomAnimalWithTypeSexName(Animal.Type.BIRD, Animal.Sex.M, "A"),    // 1        2
                Animal.randomAnimalWithTypeSexName(Animal.Type.BIRD, Animal.Sex.M, "BB"),   // 2        3
                Animal.randomAnimalWithTypeSexName(Animal.Type.BIRD, Animal.Sex.M, "YYXZ"), // 3        5
                Animal.randomAnimalWithTypeSexName(Animal.Type.BIRD, Animal.Sex.M, "DEF"),  // 4        4
                Animal.randomAnimalWithTypeSexName(Animal.Type.BIRD, Animal.Sex.M, "23A")   // 5        1
        );
        assertThat(Task1.task16(sameTypeAndSex)).isEqualTo(List.of(
                sameTypeAndSex.get(0),
                sameTypeAndSex.get(5),
                sameTypeAndSex.get(1),
                sameTypeAndSex.get(2),
                sameTypeAndSex.get(4),
                sameTypeAndSex.get(3)
        ));

        List<Animal> animals2 = Arrays.asList(                                              // index    order
                Animal.randomAnimalWithTypeSexName(Animal.Type.FISH, Animal.Sex.M, "D"),    // 0        8
                Animal.randomAnimalWithTypeSexName(Animal.Type.FISH, Animal.Sex.M, "FF"),   // 1        9
                Animal.randomAnimalWithTypeSexName(Animal.Type.CAT, Animal.Sex.M, "A"),     // 2        0
                Animal.randomAnimalWithTypeSexName(Animal.Type.CAT, Animal.Sex.M, "JJK"),   // 3        2
                Animal.randomAnimalWithTypeSexName(Animal.Type.CAT, Animal.Sex.M, "B"),     // 4        1
                Animal.randomAnimalWithTypeSexName(Animal.Type.DOG, Animal.Sex.M, "F"),     // 5        4
                Animal.randomAnimalWithTypeSexName(Animal.Type.BIRD, Animal.Sex.M, "D"),    // 6        6
                Animal.randomAnimalWithTypeSexName(Animal.Type.BIRD, Animal.Sex.M, "E"),    // 7        7
                Animal.randomAnimalWithTypeSexName(Animal.Type.BIRD, Animal.Sex.M, "A"),    // 8        5
                Animal.randomAnimalWithTypeSexName(Animal.Type.DOG, Animal.Sex.M, "B")      // 9        3
        );

        assertThat(Task1.task16(animals2)).isEqualTo(List.of(
                animals2.get(2),
                animals2.get(4),
                animals2.get(3),
                animals2.get(9),
                animals2.get(5),
                animals2.get(8),
                animals2.get(6),
                animals2.get(7),
                animals2.get(0),
                animals2.get(1)
        ));
    }

    @Test
    @DisplayName("Test task 17")
    void test17() {
        assertThat(Task1.task17(null)).isNull();
        assertThat(Task1.task17(new ArrayList<>())).isFalse();

        List<Animal> animals1 = List.of(
                Animal.randomAnimalWithTypeAndBites(Animal.Type.FISH, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true)
        );
        // Dogs: 2/2 = 1 | Spiders: 0/1 = 0 -> Spiders < Dogs
        assertThat(Task1.task17(animals1)).isFalse();

        List<Animal> noDogs1 = List.of(
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.BIRD, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.BIRD, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.BIRD, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.FISH, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.FISH, false)
        );
        assertThat(Task1.task17(noDogs1)).isFalse();

        List<Animal> noDogs2 = List.of(
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),

                Animal.randomAnimalWithTypeAndBites(Animal.Type.FISH, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.FISH, true),

                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false)
        );
        assertThat(Task1.task17(noDogs2)).isFalse();

        List<Animal> animals2 = Arrays.asList(
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),

                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false)
        );
        // Dogs: 6/11 = 0.545 | Spiders: 5/10 = 0.5 -> Spiders < Dogs
        assertThat(Task1.task17(animals2)).isFalse();


        List<Animal> animals3 = Arrays.asList(
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.DOG, false),

                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, true),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false),
                Animal.randomAnimalWithTypeAndBites(Animal.Type.SPIDER, false)
        );
        // Dogs: 6/13 = 0.4615 | Spiders: 7/15 = 0.4666 -> Spiders > Dogs
        assertThat(Task1.task17(animals3)).isTrue();

    }

    @Test
    @DisplayName("Test task 18")
    void test18() {
        List<List<Animal>> animals1 = List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        assertThat(Task1.task18(animals1)).isNull();

        List<List<Animal>> animals2 = List.of(
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.DOG, 1),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.DOG, 2),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.CAT, 3),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 4), // FISH0
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 6), // FISH1
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.CAT, 10)
                ),
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.DOG, 100),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.BIRD, 50),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.SPIDER, 25),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 23)  // FISH2 (Heaviest animals2[1][3])
                ),
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.SPIDER, 123),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.SPIDER, 231),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.CAT, 12),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.DOG, 1)
                ),
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 1),  // FISH3
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 2),  // FISH4
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 3),  // FISH5
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 1)   // FISH6
                ),
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.DOG, 12),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.BIRD, 2),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.CAT, 12003)
                )
        );
        assertThat(Task1.task18(animals2)).isEqualTo(animals2.get(1).get(3));

        List<List<Animal>> animals3 = List.of(
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 5)
                ),
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 3)
                ),
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 2)
                ),
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 10)
                ),
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 21) // Heaviest animals3[4][0]
                ),
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 1)
                )
        );
        assertThat(Task1.task18(animals3)).isEqualTo(animals3.get(4).get(0));

        List<List<Animal>> animals4 = List.of(
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.DOG, 1),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.CAT, 2),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 3), // Heaviest animals4[0][2]
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.SPIDER, 30)
                )
        );
        assertThat(Task1.task18(animals4)).isEqualTo(animals4.get(0).get(2));

        List<List<Animal>> animals5 = List.of(
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.DOG, 1),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.CAT, 2),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 3),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.SPIDER, 30)
                ),
                List.of(
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 30), // Heaviest animals5[1][0]
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.CAT, 2),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.FISH, 3),
                        Animal.randomAnimalWithTypeAndWeight(Animal.Type.SPIDER, 30)
                )
        );
        assertThat(Task1.task18(animals5)).isEqualTo(animals5.get(1).get(0));
    }

    @Test
    @DisplayName("Test task 19")
    void test19() {
        List<Animal> animals1 = Arrays.asList(
                new Animal("A", Animal.Type.FISH, Animal.Sex.M, 1, 2, 3, false),
                new Animal("B", Animal.Type.FISH, Animal.Sex.M, -1, 2, 3, false),
                new Animal("C", Animal.Type.FISH, Animal.Sex.M, -1, -2, 3, false),
                new Animal("D", Animal.Type.FISH, Animal.Sex.M, -1, -2, -3, false),
                new Animal("E", Animal.Type.FISH, Animal.Sex.M, 1, -2, 3, false),
                new Animal("F", Animal.Type.FISH, Animal.Sex.M, 1, 2, -3, false),
                new Animal("G", Animal.Type.FISH, Animal.Sex.M, -1, 2, -3, false),
                new Animal("H", Animal.Type.FISH, Animal.Sex.M, 1, -2, -3, false)
        );
        assertThat(Task1.task19(animals1)).isEqualTo(Map.of(
                "B", Set.of(new ValidationError(ValidationError.Type.NEGATIVE_AGE)),
                "C", Set.of(new ValidationError(ValidationError.Type.NEGATIVE_AGE),
                        new ValidationError(ValidationError.Type.NON_POSITIVE_HEIGHT)),
                "D", Set.of(new ValidationError(ValidationError.Type.NEGATIVE_AGE),
                        new ValidationError(ValidationError.Type.NON_POSITIVE_HEIGHT),
                        new ValidationError(ValidationError.Type.NON_POSITIVE_WEIGHT)),
                "E", Set.of(new ValidationError(ValidationError.Type.NON_POSITIVE_HEIGHT)),
                "F", Set.of(new ValidationError(ValidationError.Type.NON_POSITIVE_WEIGHT)),
                "G", Set.of(new ValidationError(ValidationError.Type.NEGATIVE_AGE),
                        new ValidationError(ValidationError.Type.NON_POSITIVE_WEIGHT)),
                "H", Set.of(new ValidationError(ValidationError.Type.NON_POSITIVE_HEIGHT),
                        new ValidationError(ValidationError.Type.NON_POSITIVE_WEIGHT))
        ));
    }

    @Test
    @DisplayName("Test task 20")
    void test20() {
        List<Animal> animals1 = Arrays.asList(
                new Animal("A", Animal.Type.FISH, Animal.Sex.M, 1, 2, 3, false),
                new Animal("B", Animal.Type.FISH, Animal.Sex.M, -1, 2, 3, false),
                new Animal("C", Animal.Type.FISH, Animal.Sex.M, -1, -2, 3, false),
                new Animal("D", Animal.Type.FISH, Animal.Sex.M, -1, -2, -3, false),
                new Animal("E", Animal.Type.FISH, Animal.Sex.M, 1, -2, 3, false),
                new Animal("F", Animal.Type.FISH, Animal.Sex.M, 1, 2, -3, false),
                new Animal("G", Animal.Type.FISH, Animal.Sex.M, -1, 2, -3, false),
                new Animal("H", Animal.Type.FISH, Animal.Sex.M, 1, -2, -3, false)
        );
        assertThat(Task1.task20(animals1)).isEqualTo(Map.of(
                "B", "age",
                "C", "age height",
                "D", "age weight height",
                "E", "height",
                "F", "weight",
                "G", "age weight",
                "H", "weight height"
        ));
    }
}

