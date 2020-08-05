/*
 * Class: Op3Expr<A,B,C,R>
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

/**
 * Represent all expression tree nodes with binary operators
 */
public final class Op3Expr<A,B,C,R> implements Expr<R> {

    private Op3<A,B,C,R> op3;
    private Expr<A> a;
    private Expr<B> b;
    private Expr<C> c;

    // ----------------------------------------
 
    public Op3Expr(Op3<A,B,C,R> op3, Expr<A> a, Expr<B> b, Expr<C> c) {
        this.op3 = op3;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // ----------------------------------------

    public R eval() {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("Op3Expr is missing an argument");
        }
        return op3.getEvalf().apply(a.eval(), b.eval(), c.eval());
    }

    public String toString() {
        return "(" + op3.toString()
                + " " + a.toString()
                + " " + b.toString()
                + " " + c.toString()
                + ")";
    }
}
