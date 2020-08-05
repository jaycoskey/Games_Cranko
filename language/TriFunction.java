/*
 * Class: TriFunction<A,B,C,R>
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

/**
 * Represent three-argument functions
 */
public interface TriFunction<A,B,C,R> {
    R apply(A a, B b, C c);
}
