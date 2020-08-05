/*
 * Class: Token
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

/**
 * Representation of each Token parsed 
 */
public class Token {

    private String filename;
    private int lineNumber;
    private int column;

    private String text;

    private Keyword keyword;
    private TokenType tokenType;
    private boolean isIdentifier;

    // ----------------------------------------

    public Token(String filename, int lineNumber, int column, String text) {
        this.filename = filename;
        this.lineNumber = lineNumber;
        this.column = column;
        this.text = text;

        this.tokenType = TokenType.get(text);
        this.keyword = Keywords.get(text);
        this.isIdentifier = Character.isLetter(text.charAt(0)) && keyword == null;
    }

    public Token(String filename, int lineNumber, int column, String text, TokenType tt) {
        this.filename = filename;
        this.lineNumber = lineNumber;
        this.column = column;
        this.text = text;

        assert(tt == TokenType.TT_STRING_DQ);
        this.tokenType = TokenType.TT_STRING_DQ;
        this.keyword = null;
        this.isIdentifier = false;
    }

    // ----------------------------------------

    public String getText() {
        return text;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public String toString() {
        String fileLineColumn = filename + ":" + String.valueOf(lineNumber)
                                    + " @ col #" + String.valueOf(column);
        String annotation = " ["
                                + tokenType.toString()
                                + "]";
        return "Token @ " + filename + ":" + lineNumber + "/" + column
                   + ": " + text + "\t"
                   + annotation;
    }
}
