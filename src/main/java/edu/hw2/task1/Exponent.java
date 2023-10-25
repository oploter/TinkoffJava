package edu.hw2.task1;

public record Exponent(Expr l, double r) implements Expr {
    public double evaluate() {
        return Math.pow(l.evaluate(), r);
    }
}
