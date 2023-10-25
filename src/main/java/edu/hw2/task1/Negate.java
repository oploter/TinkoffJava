package edu.hw2.task1;

public record Negate(Expr expr) implements Expr {
    public double evaluate() {
        return -1 * expr.evaluate();
    }
}
