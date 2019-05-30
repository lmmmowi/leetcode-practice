package com.lmmmowi.leetcode.p22;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: mowi
 * @Date: 2019-05-30
 * @Description: 22.括号生成[https://leetcode-cn.com/problems/generate-parentheses/]
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, new StringBuilder(String.valueOf(new char[n * 2])), n, 0, 0);
        return result;
    }

    private void generate(List<String> result, StringBuilder sb, int n, int k, int i) {
        if (i >= n * 2) {
            result.add(sb.toString());
            return;
        }

        if (k < n) {
            sb.setCharAt(i, '(');
            generate(result, sb, n, k + 1, i + 1);
        }

        if (i < k * 2) {
            sb.setCharAt(i, ')');
            generate(result, sb, n, k, i + 1);
        }
    }
}
