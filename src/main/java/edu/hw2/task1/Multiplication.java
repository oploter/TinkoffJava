package edu.hw2.task1;

public record Multiplication(Expr l, Expr r) implements Expr {
    public double evaluate() {
        return l.evaluate() * r.evaluate();
    }
}
