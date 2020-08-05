/*
 * Class: Operators
 * Copyright 2020 by Jay M. Coskey
 */

// package cranko;

import java.util.HashMap;
import java.util.Map;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

/**
 * Definitions of operators, plus static methods for creation, test, and lookup
 */
public final class Operators {

    public static final Map<String, Op> ops = new HashMap<>();

    // Unary
    public static final Op1<Integer> NEG = Operators.make1("neg", "-", (a) -> -a);
    public static final Op1<Boolean> NOT = Operators.make1("not", "!", (a) -> !a);

    // Binary: Arithmetic
    public static final Op2<Integer, Integer, Integer> ADD = Operators.make2("add", "+",  (a,b) -> a +  b);
    public static final Op2<Integer, Integer, Integer> SUB = Operators.make2("sub", "-",  (a,b) -> a -  b);
    public static final Op2<Integer, Integer, Integer> MUL = Operators.make2("mul", "*",  (a,b) -> a *  b);
    public static final Op2<Integer, Integer, Integer> DIV = Operators.make2("div", "/",  (a,b) -> a /  b);

    public static final Op2<Integer, Integer, Integer> MOD = Operators.make2("mod", "%",  (a,b) -> a %  b);

    // Binary: Boolean
    public static final Op2<Boolean, Boolean, Boolean> AND = Operators.make2("and", "&&", (a,b) -> a && b);
    public static final Op2<Boolean, Boolean, Boolean> OR  = Operators.make2("or",  "||", (a,b) -> a || b);

    // Binary: Equality & Inequality
    public static final Op2<Integer, Integer, Boolean> IEQ  = Operators.make2("ieq", "==", (a,b) -> a == b);
    public static final Op2<Integer, Integer, Boolean> INEQ = Operators.make2("ine", "!=", (a,b) -> a != b);

    public static final Op2<Integer, Integer, Boolean> ILT  = Operators.make2("ilt", "<",  (a,b) -> a <  b );
    public static final Op2<Integer, Integer, Boolean> ILE  = Operators.make2("ile", "<=", (a,b) -> a <= b);
    public static final Op2<Integer, Integer, Boolean> IGT  = Operators.make2("igt", ">",  (a,b) -> a >  b );
    public static final Op2<Integer, Integer, Boolean> IGE  = Operators.make2("ige", ">=", (a,b) -> a >= b);

    // ----------------------------------------

    public static Op get(String name) {
        return Operators.ops.get(name);
    }

    public static <T> Op1<T> make1(String name, String display, UnaryOperator<T> evalf) {
        synchronized (ops) {
            Op prev = ops.get(name);
            if (prev != null) {
                throw new IllegalArgumentException("1-argument operator '" + name + "' already exists");
            }
            Op1<T> op1 = new Op1<T>(name, display, evalf);
            ops.put(name, op1);
            return op1;
        }
    }

    public static <A,B,R> Op2<A,B,R> make2(String name, String display, BiFunction<A,B,R> evalf) {
        synchronized (ops) {
            Op prev = ops.get(name);
            if (prev != null) {
                throw new IllegalArgumentException("2-argument operator '" + name + "' already exists");
            }
            Op2<A,B,R> op2 = new Op2<A,B,R>(name, display, evalf);
            Operators.ops.put(name, op2);
            return op2;
        }
    }

    public static boolean isOperator(String name) {
        Op op = ops.get(name);
        return op == null ? false : true;
    }

    // ----------------------------------------

    private Operators() {}
}
