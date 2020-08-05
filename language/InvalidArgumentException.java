/*
 * Class: InvalidArgumentException
 * Copyright 2020 by Jay M. Coskey
 */

// package crano;

public class InvalidArgumentException extends SyntaxException {

    private String message;

    // ----------------------------------------

    public InvalidArgumentException(String message) {
        super(message);
    }

    // ----------------------------------------

    public String getMessage() { return message; }
}
