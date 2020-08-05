/*
 * Class: Keywords
 * Copyright 2020 by Jay M. Coskey */

// package cranko;

import java.util.HashMap;
import java.util.Map;

/**
 * Represent the collection of Keywords, and static methods to create and query them.
 */
public class Keywords {

    public static final Map<String, Keyword> keywords = new HashMap<>();

    public static Keyword make(String text) {
        synchronized (keywords) {
            Keyword prev = keywords.get(text);
            if (prev != null) {
                throw new IllegalArgumentException("Keyword '" + text + "' already exists");
            }
            Keyword kw = new Keyword(text);
            keywords.put(text, kw);
            return kw;
        }
    }

    public static Keyword get(String txt) {
        return Keywords.keywords.get(txt);
    }

    public static boolean isKeyword(String txt) {
        Keyword result = Keywords.keywords.get(txt);
        return result == null ? false : true;
    }

    // Arithmetic
    static final Keyword KW_ABS = Keywords.make("abs");
    static final Keyword KW_ADD = Keywords.make("add");
    static final Keyword KW_DIV = Keywords.make("div");
    static final Keyword KW_MOD = Keywords.make("mod");
    static final Keyword KW_MUL = Keywords.make("mul");
    static final Keyword KW_SUB = Keywords.make("sub");

    // Boolean
    static final Keyword KW_FALSE = Keywords.make("false");
    static final Keyword KW_TRUE  = Keywords.make("true");

    static final Keyword KW_NOT   = Keywords.make("not");

    static final Keyword KW_AND   = Keywords.make("and");
    static final Keyword KW_OR    = Keywords.make("or");

    // Sets
    static final Keyword KW_SET          = Keywords.make("set");
    static final Keyword KW_DIFF         = Keywords.make("diff");
    static final Keyword KW_INTERSECTION = Keywords.make("intersection");
    static final Keyword KW_UNION        = Keywords.make("union");

    // Functions
    static final Keyword KW_IF = Keywords.make("if");

    // Graphs

    // Games

    // Contracts

    // ----------------------------------------

    private Keywords() {}
}
