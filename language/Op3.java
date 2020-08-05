/*
 * Class: Op3<A,B,C,R>
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

/**
 * Represent all ternary operators
 */
public class Op3<A,B,C,R> implements Op {

    private String name;
    private String display;
    private TriFunction<A,B,C,R> evalf;

    // ----------------------------------------

    public Op3(String name, String display, TriFunction<A,B,C,R> evalf) {
        this.name = name;
        this.display = display;
        this.evalf = evalf;
    } 

    // ----------------------------------------

    public int arity() { return 3; }
    public TriFunction<A,B,C,R> getEvalf() { return evalf; }
    public String toString() { return name; }
}
