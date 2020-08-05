/*
 * Class: Expr<T>
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

/**
 * Interface for all expressions of a type T
 */
public interface Expr<T> {
    public T eval();
    public String toString();
}
