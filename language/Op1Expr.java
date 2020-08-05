/*
 * Class: Op1Expr<T>
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

/**
 * Represent all expression tree nodes with unary operators
 */
public final class Op1Expr<T> implements Expr<T> {

    private Op1<T> op1;
    private Expr<T> a;

    // ----------------------------------------

    public Op1Expr(Op1<T> op1, Expr<T> a) {
        this.op1 = op1;
        this.a = a;
    }

    // ----------------------------------------
 
    public T eval() {
        if (a == null) {
            throw new IllegalArgumentException("Op1Expr is missing an argument");
        }
        return op1.getEvalf().apply(a.eval());
    }

    public String toString() {
        return "(" + op1.toString() + " " + a.toString() + ")";
    }
}
