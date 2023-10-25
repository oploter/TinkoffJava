package edu.hw2.task1;

public record Constant(double val) implements Expr {
    public double evaluate() {
        return val;
    }
}
