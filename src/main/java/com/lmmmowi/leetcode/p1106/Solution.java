package com.lmmmowi.leetcode.p1106;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: mowi
 * @Date: 2022/4/14
 * @Description: 1106. 解析布尔表达式[https://leetcode-cn.com/problems/parsing-a-boolean-expression/]
 */
public class Solution {

    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';
    private static final char COMMA = ',';
    private static final char TRUE = 't';
    private static final char FALSE = 'f';

    public boolean parseBoolExpr(String expression) {
        Deque<Operation> operations = new ArrayDeque<>();
        Deque<Boolean> values = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            switch (c) {
                case LEFT_BRACKET:
                case COMMA:
                    operations.peekLast().valueCount++;
                    break;
                case RIGHT_BRACKET:
                    calculate(operations, values);
                    break;
                case TRUE:
                    values.addLast(true);
                    break;
                case FALSE:
                    values.addLast(false);
                    break;
                default:
                    operations.addLast(new Operation(c));
                    break;
            }
        }

        return values.pollLast();
    }

    private void calculate(Deque<Operation> operations, Deque<Boolean> values) {
        Operation operation = operations.pollLast();
        boolean value = values.pollLast();
        int n = operation.valueCount;
        switch (operation.signal) {
            case '!':
                value = !value;
                break;
            case '&':
                for (int i = 0; i < n - 1; i++) {
                    value &= values.pollLast();
                }
                break;
            case '|':
                for (int i = 0; i < n - 1; i++) {
                    value |= values.pollLast();
                }
                break;
            default:
                return;
        }
        values.addLast(value);
    }

    private class Operation {
        private char signal;
        private int valueCount;

        private Operation(char signal) {
            this.signal = signal;
        }
    }
}
