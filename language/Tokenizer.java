/*
 * Class: Tokenizer
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

import java.util.ArrayDeque;
import java.util.Deque;
// import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Convert input into tokens (as a list, stream, etc.)
 */
public class Tokenizer {

    public static Deque<Token> tokenize(String text) {
        String filename = "Filename";
        int lineNumber = 1;
        int column = 1;
        // InputStream stream = new ByteArrayInputStream(txt.getBytes(StandardCharsets.UTF_8));

        String delims = " ()\"";
        StringTokenizer st = new StringTokenizer(text, delims, true);
        Deque<Token> tokens = new ArrayDeque<>();
        while (st.hasMoreTokens()) {
            String tokstr = st.nextToken();
            Token token = new Token(filename, lineNumber, column, tokstr);
            if (token.getTokenType() != TokenType.TT_QUOTE_D) {
                tokens.add(token);
                column += tokstr.length();
            } else {
                StringBuilder sb = new StringBuilder(tokstr);
                boolean isFoundClosingQuote = false;
                while (!isFoundClosingQuote) {
                    String nextTok = st.nextToken();
                    if (TokenType.get(nextTok) == TokenType.TT_QUOTE_D) {
                        // TODO: Handle escaped quotes within the quoted string
                        // TODO: Handle non-completed double-quoted string
                        isFoundClosingQuote = true;
                    }
                    sb.append(nextTok);
                }
                tokens.add(new Token(filename, lineNumber, column, sb.toString()));
                column += sb.length();
            }
            // System.out.println(token.toString());
        }
        return tokens;
    }
}
