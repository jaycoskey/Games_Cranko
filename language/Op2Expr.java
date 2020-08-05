/*
 * Class: Op2Expr<A,B,R>
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

/**
 * Represent all expression tree nodes with binary operators
 */
public final class Op2Expr<A,B,R> implements Expr<R> {

    private Op2<A,B,R> op2;
    private Expr<A> a;
    private Expr<B> b;

    // ----------------------------------------
 
    public Op2Expr(Op2<A,B,R> op2, Expr<A> a, Expr<B> b) {
        this.op2 = op2;
        this.a = a;
        this.b = b;
    }

    // ----------------------------------------

    public R eval() {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Op2Expr is missing an argument");
        }
        return op2.getEvalf().apply(a.eval(), b.eval());
    }

    public String toString() {
        return "(" + op2.toString()
		+ " " + a.toString()
		+ " " + b.toString()
		+ ")";
    }
}
