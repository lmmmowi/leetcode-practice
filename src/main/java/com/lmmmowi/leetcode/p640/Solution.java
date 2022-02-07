package com.lmmmowi.leetcode.p640;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: mowi
 * @Date: 2022/2/7
 * @Description: 640. 求解方程[https://leetcode-cn.com/problems/solve-the-equation/]
 */
public class Solution {

    public String solveEquation(String equation) {
        String[] expressions = equation.split("=");
        int[] left = parse(expressions[0]);
        int[] right = parse(expressions[1]);

        int x = left[0] - right[0];
        int number = right[1] - left[1];
        if (number == 0 && x == 0) {
            return "Infinite solutions";
        } else if (x == 0) {
            return "No solution";
        } else {
            return "x=" + number / x;
        }
    }

    private int[] parse(String expression) {
        String[] parts = expression.split("-");
        for (int i = 1; i < parts.length; i++) {
            parts[i] = "-" + parts[i];
        }

        List<String> tokens = Arrays.stream(parts)
                .filter(s -> s.length() > 0)
                .map(s -> Arrays.asList(s.split("\\+")))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        int number = 0;
        int x = 0;
        for (String token : tokens) {
            if (token.endsWith("x")) {
                token = token.substring(0, token.length() - 1);
                if (token.length() == 0) {
                    x += 1;
                } else if ("-".equals(token)) {
                    x -= 1;
                } else {
                    x += Integer.parseInt(token);
                }
            } else {
                number += Integer.parseInt(token);
            }
        }
        return new int[]{x, number};
    }
}
