/*
 * Class: TokenType
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

/**
 * Taxonomy of Tokens
 */
public enum TokenType {
    TT_UNKNOWN,

    TT_COMMENT,
    TT_FLOAT,
    TT_IDENTIFIER,
    TT_INTEGER,
    TT_KEYWORD,
    TT_NEWLINE,
    TT_OPERATOR,
    TT_PAREN_L,
    TT_PAREN_R,
    TT_QUOTE_D,
    TT_QUOTE_S,
    TT_SPACE,
    TT_STRING_DQ,
    TT_STRING_SQ;

    // TODO: Efficiency could be improved by using a lexer.
    public static TokenType get(String text) {
        TokenType result = TT_UNKNOWN;

        // Limited character checks
        if (text.length() >= 2 && text.substring(0, 1) == "//") {
            result = TT_COMMENT;
        } else if (text.equals("(")) {
            result = TT_PAREN_L;
        } else if (text.equals(")")) {
            result = TT_PAREN_R;
        } else if (text.equals("\"")) {
            result = TT_QUOTE_D;
        } else if (text.equals("\'")) {
            result = TT_QUOTE_S;
        } else if (text.length() == 1 && text.equals(" ")) {
            result = TT_SPACE;
        } else if (text.length() == 1 && text.equals("\n")) {
            result = TT_NEWLINE;
        } else if (Keywords.isKeyword(text)) {
            result = TT_KEYWORD;
        } else if (text.length() >= 2
            && text.charAt(0) == '\"' && text.charAt(text.length() - 1) == '\"')
        {
            result = TT_STRING_DQ;
        } else if
            (text.length() >= 2
                && text.charAt(0) == '\'' && text.charAt(text.length() - 1) == '\''
            )
        {
            result = TT_STRING_SQ;
        } else if (TokenType.isInteger(text)) {
            result = TT_INTEGER;
        } else if (Operators.isOperator(text)) {
            result = TT_OPERATOR;
        } else if (Character.isLetter(text.charAt(0))) {
            result = TT_IDENTIFIER;
        }

        return result;
    }

    // TODO: Move to util
    static boolean isInteger(String text) {
        try {
            Integer.parseInt(text);
        } catch(NumberFormatException ex) {
            return false;
        } catch(NullPointerException ex) {
            return false;
        }
        return true;
    }
}
