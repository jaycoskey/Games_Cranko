/*
 * Class: ConstExpr<T>
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

/**
 * Expression tree Node that contains a single constant of type T
 */
public final class ConstExpr<T> implements Expr {

    private T c;

    // ----------------------------------------

    public ConstExpr(T c) { this.c = c; }

    // ----------------------------------------

    public T eval() {
        if (c == null) { throw new IllegalArgumentException("Constant is null"); }
        return c;
    }

    public T getConst() { return c; }
    public void setConst(T c) { this.c = c; }
    public String toString(T c) { return c.toString(); }
}
