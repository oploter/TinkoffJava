package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task1 {
    private Task1() {
    }

    public static List<Animal> task1(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    public static List<Animal> task2(List<Animal> animals, int k) {
        if (k < 0 || animals == null) {
            return null;
        }
        return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).collect(Collectors.toList());
    }

    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        Map<Animal.Type, Integer> typeCnt
                = animals.stream().collect(Collectors.toMap(Animal::type, s -> 1, Integer::sum));
        Map<Animal.Type, Integer> typeCntWithZeroesIfAbsent = Stream.of(Animal.Type.values()).collect(Collectors.toMap(
                Function.identity(),
                v -> typeCnt.getOrDefault(v, 0)
        ));
        return typeCntWithZeroesIfAbsent;
    }

    public static Animal task4(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        int maxNameLength = -1;
        Animal maxNameLengthAnimal = null;
        boolean numOfMaxNameLengthAnimalsIsMoreThanOne = false;
        for (Animal a : animals) {
            if (a.name().length() > maxNameLength) {
                maxNameLength = a.name().length();
                maxNameLengthAnimal = a;
                numOfMaxNameLengthAnimalsIsMoreThanOne = false;
            } else if (a.name().length() == maxNameLength) {
                numOfMaxNameLengthAnimalsIsMoreThanOne = true;
            }
        }
        return (numOfMaxNameLengthAnimalsIsMoreThanOne ? null : maxNameLengthAnimal);
    }

    public static Animal.Sex task5(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        Map<Animal.Sex, Integer> typeCnt = animals.stream()
                .collect(Collectors.toMap(Animal::sex, s -> 1, Integer::sum));
        int mCnt = typeCnt.getOrDefault(Animal.Sex.M, 0);
        int fCnt = typeCnt.getOrDefault(Animal.Sex.F, 0);
        return (mCnt == fCnt ? null : (mCnt < fCnt ? Animal.Sex.F : Animal.Sex.M));
    }

    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        if (animals == null) {
            return null;
        }

        return animals.stream()
                .collect(Collectors.toMap(Animal::type,
                        Function.identity(),
                        (l, r) -> {
                            if (l.weight() == r.weight()) {
                                return null;
                            } else {
                                return (l.weight() > r.weight() ? l : r);
                            }
                        }));
    }

    public static Animal task7(List<Animal> animals, int k) {
        if (animals == null || (k < 1 || animals.size() < k)) {
            return null;
        }

        return animals.stream()
                .sorted(Comparator.comparingInt(Animal::age).reversed())
                .skip(k - 1)
                .findFirst()
                .orElse(null);
    }

    public static Optional<Animal> task8(List<Animal> animals, int k) {
        if (animals == null) {
            return Optional.empty();
        }
        return animals.stream().filter(a -> a.height() < k).max(Comparator.comparing(Animal::weight));
    }

    public static Integer task9(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    public static List<Animal> task10(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream().filter(a -> a.age() != a.paws())
                .collect(Collectors.toList());
    }

    public static List<Animal> task11(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        final int minHeight = 100;
        return animals.stream()
                .filter((a -> a.bites() && a.height() > minHeight))
                .collect(Collectors.toList());
    }

    public static Integer task12(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return Math.toIntExact(animals.stream().filter(a -> a.weight() > a.height()).count());
    }

    public static List<Animal> task13(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream().filter(a -> a.name().split(" ").length > 2).collect(Collectors.toList());
    }

    public static Boolean task14(List<Animal> animals, int k) {
        if (animals == null) {
            return null;
        }
        return animals.stream().anyMatch(a -> (a.type() == Animal.Type.DOG && a.height() > k));
    }

    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        if (animals == null) {
            return null;
        }
        return animals.stream().collect(Collectors.toMap(
                Animal::type,
                a -> ((k <= a.age() && a.age() <= l) ? a.weight() : 0),
                Integer::sum
        ));
    }

    public static List<Animal> task16(List<Animal> animals) {
        if (animals == null) {
            return null;
        }

        return animals.stream().sorted(((o1, o2) -> {
            int res1 = o1.type().compareTo(o2.type());
            if (res1 != 0) {
                return res1;
            }
            int res2 = o1.sex().compareTo(o2.sex());
            if (res2 != 0) {
                return res2;
            }
            return o1.name().compareTo(o2.name());
        })).collect(Collectors.toList());

    }

    public static Boolean task17(List<Animal> animals) {
        enum DogsAndSpiders {
            DOG_BITING,
            DOG_NOT_BITING,
            SPIDER_BITING,
            SPIDER_NOT_BITING
        }

        if (animals == null) {
            return null;
        }
        Map<DogsAndSpiders, Integer> dogsAndSpidersCnt = animals.stream()
                .filter(a -> (a.type().equals(Animal.Type.DOG) || a.type().equals(Animal.Type.SPIDER)))
                .collect(Collectors.toMap(
                        a -> {
                            if (a.type() == Animal.Type.DOG) {
                                return a.bites() ? DogsAndSpiders.DOG_BITING : DogsAndSpiders.DOG_NOT_BITING;
                            } else {
                                return a.bites() ? DogsAndSpiders.SPIDER_BITING : DogsAndSpiders.SPIDER_NOT_BITING;
                            }
                        },
                        a -> 1,
                        Integer::sum
                ));
        /*
        for (Animal a : animals) {
            if (a.type() == Animal.Type.DOG) {
                ++totalDogCnt;
                if (a.bites()) {
                    ++bitingDogCnt;
                }
            } else if (a.type() == Animal.Type.SPIDER) {
                ++totalSpiderCnt;
                if (a.bites()) {
                    ++bitingSpiderCnt;
                }
            }
        }
         */

        int bitingDogCnt = dogsAndSpidersCnt.getOrDefault(DogsAndSpiders.DOG_BITING, 0);
        int totalDogCnt = bitingDogCnt + dogsAndSpidersCnt.getOrDefault(DogsAndSpiders.DOG_NOT_BITING, 0);
        int bitingSpiderCnt = dogsAndSpidersCnt.getOrDefault(DogsAndSpiders.SPIDER_BITING, 0);
        int totalSpiderCnt = bitingSpiderCnt + dogsAndSpidersCnt.getOrDefault(DogsAndSpiders.SPIDER_NOT_BITING, 0);

        if (totalSpiderCnt == 0 || totalDogCnt == 0) {
            return false;
        }
        return (((float) bitingSpiderCnt) / totalSpiderCnt > ((float) bitingDogCnt) / totalDogCnt);
    }

    public static Animal task18(List<List<Animal>> animals) {
        return animals.stream()
                .flatMap(Collection::stream)
                .filter(a -> a.type() == Animal.Type.FISH)
                .max(Comparator.comparing(Animal::weight)).orElse(null);
    }

    private static Set<ValidationError> checkAnimal(Animal a) {
        Set<ValidationError> errors = new HashSet<>();
        if (a.age() < 0) {
            errors.add(new ValidationError(ValidationError.Type.NEGATIVE_AGE));
        }
        if (a.weight() <= 0) {
            errors.add(new ValidationError(ValidationError.Type.NON_POSITIVE_WEIGHT));
        }
        if (a.height() <= 0) {
            errors.add(new ValidationError(ValidationError.Type.NON_POSITIVE_HEIGHT));
        }
        return errors;
    }

    public static Map<String, Set<ValidationError>> task19(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream()
                .filter(a -> Task1.checkAnimal(a).size() > 0)
                .collect(Collectors.toMap(
                        Animal::name,
                        Task1::checkAnimal
                ));
    }

    private static String checkAnimalString(Animal a) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirstError = true;
        if (a.age() < 0) {
            stringBuilder.append("age");
            isFirstError = false;
        }
        if (a.weight() <= 0) {
            if (!isFirstError) {
                stringBuilder.append(' ');
            } else {
                isFirstError = false;
            }
            stringBuilder.append("weight");

        }
        if (a.height() <= 0) {
            if (!isFirstError) {
                stringBuilder.append(' ');
            }
            stringBuilder.append("height");
        }
        return stringBuilder.toString();
    }

    public static Map<String, String> task20(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream()
                .filter(a -> Task1.checkAnimalString(a).length() > 0)
                .collect(Collectors.toMap(
                        Animal::name,
                        Task1::checkAnimalString
                ));
    }
}
