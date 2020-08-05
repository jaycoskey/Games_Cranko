/*
 * Class: TokenizerTest
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

// import org.junit.Test;

import java.util.Deque;
// import java.util.Queue;

/**
 * Test the Tokenizer. First on sample data. Later focus on coverage.
 */
// TODO: Convert to JUnit
public class TokenizerTest {
    public static void testCase(String text) {
        Deque<Token> tokens1 = Tokenizer.tokenize(text);
        tokens1.forEach(token->System.out.println(token.toString()));
    }

    public static void main(String[] args) {
        TokenizerTest.testCase("(add    123 654)");
        System.out.println("====================");
        TokenizerTest.testCase("(add (mul 2 3) (mul 4 5))");
        System.out.println("====================");
        TokenizerTest.testCase("(union (set \"foo\" \"bar bar\") (set \"bar bar\" \"baz\"))");
    }
}
