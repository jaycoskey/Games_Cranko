/*
 * Class: Keyword
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

/**
 * Represent an individual keyword
 */
public class Keyword {

    private final String text;

    // ----------------------------------------
 
    public Keyword(String text) {
        this.text = text;
    }

    // ----------------------------------------

    @Override public String toString() {
        return text;
    }
}
