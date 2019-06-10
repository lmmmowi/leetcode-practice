package com.lmmmowi.leetcode.p44;

/**
 * @Author: mowi
 * @Date: 2019-06-10
 * @Description: 44.通配符匹配[https://leetcode-cn.com/problems/wildcard-matching/]
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        int plen = p.length(), slen = s.length();
        boolean[][] dp = new boolean[plen + 1][slen + 1];
        dp[0][0] = true;

        for (int i = 1; i <= plen; i++) {
            char pc = p.charAt(i - 1);
            dp[i][0] = dp[i - 1][0] && pc == '*';

            for (int j = 1; j <= slen; j++) {
                char sc = s.charAt(j - 1);

                if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (pc == '?' || pc == sc);
                }
            }
        }

        return dp[plen][slen];
    }
}
