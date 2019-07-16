package com.lmmmowi.leetcode.p65;

/**
 * @Author: 11102942
 * @Date: 2019/7/16
 * @Description: 65.有效数字[https://leetcode-cn.com/problems/valid-number/]
 */
public class Solution {

    public boolean isNumber(String s) {
        s = s.trim();

        int index = s.indexOf("e");
        if (index >= 0) {
            return isNumber2(s.substring(0, index), false) && isNumber2(s.substring(index + 1), true);
        } else {
            return isNumber2(s, false);
        }
    }

    private boolean isNumber2(String s, boolean strictInt) {
        if (s.length() == 0) {
            return false;
        }

        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }

        boolean numberAppear = false;
        boolean dotAppear = strictInt;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '.') {
                if (dotAppear) {
                    return false;
                } else {
                    dotAppear = true;
                }
            } else if (c >= '0' && c <= '9') {
                numberAppear = true;
            } else {
                return false;
            }
        }

        return numberAppear;
    }
}

