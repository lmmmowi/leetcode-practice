package com.lmmmowi.leetcode.p32;

/**
 * @Author: mowi
 * @Date: 2019-06-03
 * @Description: 32.最长有效括号[https://leetcode-cn.com/problems/longest-valid-parentheses/]
 */
public class Solution {

    public int longestValidParentheses(String s) {
        int longest = 0;
        int length = s.length();
        int[] arr = new int[length];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int center = i;
                int m = 0;

                // 找到一组相邻的合法括号后，开始不断向两边扩散，m表示扩散长度，center表示扩散中心
                while (true) {
                    int a = center - m;
                    int b = center + m + 1;

                    if (a >= 0 && b < length && s.charAt(a) == '(' && s.charAt(b) == ')') {
                        // 累加扩散长度
                        m++;
                    } else {
                        // 如果扩散长度大于0，且当前扩散范围的左边也是合法的子串，则将两个子串合并，并继续尝试向外扩散
                        int k = center - m;
                        if (m > 0 && k >= 0 && arr[k] > 0) {
                            // 调整合并后的扩散中心和扩散长度
                            center -= arr[k];
                            m += arr[k];
                        } else {
                            // 如果无法扩散且无法合并，则跳出
                            break;
                        }
                    }
                }

                // 如果扩散长度大于0，则将合法子串的最右边标记为扩散长度
                if (m > 0) {
                    arr[center + m] = m;
                    longest = Math.max(m * 2, longest);
                }
            }
        }

        return longest;
    }
}
