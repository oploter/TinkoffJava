package edu.hw2;

import edu.hw2.task1.Addition;
import edu.hw2.task1.Constant;
import edu.hw2.task1.Exponent;
import edu.hw2.task1.Multiplication;
import edu.hw2.task1.Negate;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Task example works")
    void testTaskExample() {
        var two = new Constant(2);
        assertThat(two.evaluate()).isEqualTo(2);
        var four = new Constant(4);
        assertThat(four.evaluate()).isEqualTo(4);
        var negOne = new Negate(new Constant(1));
        assertThat(negOne.evaluate()).isEqualTo(-1);
        var sumTwoFour = new Addition(two, four); // 6
        assertThat(sumTwoFour.evaluate()).isEqualTo(6);
        var mult = new Multiplication(sumTwoFour, negOne); // -6
        assertThat(mult.evaluate()).isEqualTo(-6);
        var exp = new Exponent(mult, 2); // 36
        assertThat(exp.evaluate()).isEqualTo(36);
        var res = new Addition(exp, new Constant(1));
        assertThat(res.evaluate()).isEqualTo(37);
    }

    @Test
    @DisplayName("Constant")
    void constantTest() {
        var c1 = new Constant(12.43);
        assertThat(c1.evaluate()).isEqualTo(12.43);

        var c2 = new Constant((byte) (1));
        assertThat(c2.evaluate()).isEqualTo(1);

        var c3 = new Constant(-1000);
        assertThat(c3.evaluate()).isEqualTo(-1000);
    }

    @Test
    @DisplayName("Addition")
    void additionTest() {
        var c1 = new Constant(12);
        var c2 = new Constant(-12.32);
        var res1 = new Addition(c1, c2);

        assertThat(res1.evaluate()).isCloseTo(-0.32, Percentage.withPercentage(0.1));

        var res2 = new Addition(c1, c1);

        assertThat(res2.evaluate()).isEqualTo(c1.evaluate() * 2);

        var c3 = new Constant(1);
        var res3 = new Addition(new Addition(c1, c2), new Addition(c3, c2));
        assertThat(res3.evaluate()).isEqualTo(12 - 12.32 - 12.32 + 1);

        var res4 = new Addition(
                c1,
                new Addition(c1,
                        new Addition(c1, c1))
        );
        assertThat(res4.evaluate()).isEqualTo(4 * c1.evaluate());
    }

    @Test
    @DisplayName("Multiplication")
    void multiplicationTest() {
        var c1 = new Addition(new Constant(12), new Constant(-11)); // 1
        var c2 = new Constant(2.3);

        var res1 = new Multiplication(c1, c2);
        assertThat(res1.evaluate()).isCloseTo(2.3, Percentage.withPercentage(0.1));

        var s1 = new Addition(new Constant(1), new Constant(2));
        var s2 = new Addition(new Constant(3), new Constant(4));
        var res2 = new Multiplication(s1, s2);
        assertThat(res2.evaluate()).isEqualTo(21);

        var res3 = new Multiplication(new Constant(-2), new Constant(3));
        assertThat(res3.evaluate()).isEqualTo(-6);

        var res4 = new Multiplication(new Constant(-2), new Constant(-3));
        assertThat(res4.evaluate()).isEqualTo(6);
    }

    @Test
    @DisplayName("Exponent, zero degree")
    void exponentTestZeroDegree() {
        for (double i = -200; i <= 200; i += 0.5) {
            var res = new Exponent(new Constant(i), 0);
            assertThat(res.evaluate()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("Exponent")
    void exponentTest() {
        var res1 = new Exponent(new Constant(32), 3);
        assertThat(res1.evaluate()).isEqualTo(32768);

        var res2 = new Exponent(new Addition(new Constant(3), new Constant(12)), -1);
        assertThat(res2.evaluate()).isCloseTo(0.0666666, Percentage.withPercentage(0.1));

        var mult = new Multiplication(new Constant(2), new Constant(12));
        var res3 = new Exponent(mult, 4);
        var res4 = new Multiplication(new Exponent(new Constant(2), 4), new Exponent(new Constant(12), 4));
        assertThat(res3.evaluate()).isCloseTo(res4.evaluate(), Percentage.withPercentage(0.1));
    }

    @Test
    @DisplayName("Negate")
    void negateTest() {
        var c1 = new Constant(2);
        var c2 = new Constant(2.3);
        var c3 = new Constant(-4);
        var res1 = new Negate(new Addition(c1, c2));
        assertThat(res1.evaluate()).isCloseTo(-4.3, Percentage.withPercentage(0.1));

        var res2 = new Negate(new Multiplication(c1, c3));
        assertThat(res2.evaluate()).isEqualTo(8);

        var res3 = new Negate(new Constant(0));
        assertThat(res3.evaluate()).isEqualTo(0);

        var res4 = new Negate(new Constant(-3));
        assertThat(res4.evaluate()).isEqualTo(3);
    }
}
