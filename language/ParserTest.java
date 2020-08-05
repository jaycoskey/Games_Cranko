/*
 * Class: ParserTest
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

import java.util.ArrayList;
import java.util.List;
// import java.util.Queue;
import java.util.Deque;

/**
 * Parse files and strings of code into expression trees
 */
public class ParserTest {
    public static void testCase(String text) {
        List<Expr> exprTrees = Parser.parse(text);
        exprTrees.forEach(exprTree->System.out.println(exprTree.toString()));
        exprTrees.forEach(exprTree->System.out.println(exprTree.eval().toString()));
    }

    public static void main(String[] args) {
        // ParserTest.testCase("(add    123 654)");
        // System.out.println("====================");
        ParserTest.testCase("(add (mul 2 3) (mul 4 5))");
        // System.out.println("====================");
        // ParserTest.testCase("(union (set \"foo\" \"bar bar\") (set \"bar bar\" \"baz\"))");
    }
}
