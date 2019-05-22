package com.lmmmowi.leetcode.p14;

/**
 * @Author: mowi
 * @Date: 2019-05-22
 * @Description: 14.最长公共前缀[https://leetcode-cn.com/problems/longest-common-prefix/]
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int n = 0;
        boolean ok = true;

        while (ok) {
            n++;

            char c = 0;
            for (String str : strs) {
                if (str.length() < n) {
                    ok = false;
                    break;
                }

                if (c == 0) {
                    c = str.charAt(n - 1);
                } else if (c != str.charAt(n - 1)) {
                    ok = false;
                    break;
                }
            }
        }

        return strs[0].substring(0, n - 1);
    }
}
