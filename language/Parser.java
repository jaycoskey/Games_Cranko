/*
 * Class: Parser
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
public class Parser {

    public static Expr completeExpr(Deque<Token> tokens, int depth) {
        assert(!tokens.isEmpty());
        Token opToken = tokens.remove();
        String opText = opToken.getText();
        Op op = Operators.get(opText);

        List<Expr> argExprs = new ArrayList<>();
        Expr result = null;
        while (true) {
            Token argToken = tokens.remove();
            String argText = argToken.getText();
            TokenType tt = argToken.getTokenType();

            if (tt == TokenType.TT_COMMENT
                || tt == TokenType.TT_NEWLINE
                || tt == TokenType.TT_SPACE)
            {
                continue;
            } else if (tt == TokenType.TT_PAREN_L) {
                Expr argExpr = completeExpr(tokens, depth + 1);
                argExprs.add(argExpr);
            }

            else if (tt == TokenType.TT_KEYWORD || tt == TokenType.TT_OPERATOR) {
                // TODO: Assert appropriate context
                String msg = "Unexpected operator found in non-primary position: " + argText;
                throw new InvalidArgumentException(msg);
            }

            // Category: Constant expressions
            else if (tt== TokenType.TT_INTEGER) {
                Expr argExpr = new ConstExpr<Integer>(Integer.parseInt(argText));
                argExprs.add(argExpr);
	    } else if (tt == TokenType.TT_STRING_DQ || tt == TokenType.TT_STRING_SQ) {
                String s = argToken.getText();
                Expr argExpr = new ConstExpr<String>(s.substring(1, s.length() - 1));
                argExprs.add(argExpr);
            }

	    else if (tt == TokenType.TT_PAREN_R) {
                int argExpectedCount = op.arity();
                int argCount = argExprs.size();
                if (argExpectedCount != argCount) {
                    String msg = "Number of arguments found ("
	                    + Integer.toString(argCount)
                            + ") does not match the number expected ("
                            + Integer.toString(argExpectedCount)
                            ;
                    throw new InvalidArgumentException(msg);
                }
                switch(argCount) {
                  case 1:
                    // TODO: Type checking
                    result = new Op1Expr((Op1)op, argExprs.get(0));
                    break;	
                  case 2:
                    // TODO: Type checking
                    result = new Op2Expr((Op2)op, argExprs.get(0), argExprs.get(1));
                    break;	
                  case 3:
                    // TODO: Type checking
                    result = new Op3Expr((Op3)op, argExprs.get(0), argExprs.get(1), argExprs.get(2));
                    break;	
                }
                return result;
            }
        }
    }

    // Test input: "(add    123 654)"
    // Test input: "(add (mul 2 3) (mul 4 5))"
    // Test input: "(union (set \"foo\" \"bar bar\") (set \"bar bar\" \"baz\"))"
    //
    public static List<Expr> parse(String input) {
        Deque<Token> tokens = Tokenizer.tokenize(input);
        int currentTokenNumber = 0;
        List<Expr> exprTrees = new ArrayList<Expr>();

        while (!tokens.isEmpty()) {
            Token curToken = tokens.remove();
            TokenType tt = curToken.getTokenType();
            if (tt == TokenType.TT_COMMENT || tt == TokenType.TT_SPACE)
            {
                continue;  // discard comments, spaces
            }
            if (tt == TokenType.TT_PAREN_L) {
                Expr exprTree = completeExpr(tokens, 1);
		exprTrees.add(exprTree);
	    } else {
                // TODO: Replace ex with derived type.
                throw new SyntaxException("Found unexpected text outside expression syntax.");
	    }
        }
        return exprTrees;
    }
}
