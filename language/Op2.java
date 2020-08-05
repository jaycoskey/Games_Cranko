/*
 * Class: Op2<A,B,R>
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

import java.util.function.BiFunction;

/**
 * Represent all binary operators
 */
public class Op2<A,B,R> implements Op {

    private String name;
    private String display;
    private BiFunction<A,B,R> evalf;

    // ----------------------------------------

    public Op2(String name, String display, BiFunction<A,B,R> evalf) {
        this.name = name;
        this.display = display;
        this.evalf = evalf;
    } 

    // ----------------------------------------

    public int arity() { return 2; }
    public BiFunction<A,B,R> getEvalf() { return evalf; }
    public String toString() { return name; }
}
