/*
 * Class: Op1<T>
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

import java.util.function.UnaryOperator;

/**
 * Represent all unary operators
 */
public class Op1<T> implements Op {

    private String name;
    private String display;
    private UnaryOperator<T> evalf;

    // ----------------------------------------
 
    public Op1(String name, String display, UnaryOperator<T> evalf) {
        this.name = name;
        this.display = display;
        this.evalf = evalf;
    }

    // ----------------------------------------

    public int arity() { return 1; }
    public UnaryOperator<T> getEvalf() { return evalf; }
    public String toString() { return name; }
}
