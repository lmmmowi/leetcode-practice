package com.lmmmowi.leetcode.p5;

/**
 * @Author: mowi
 * @Date: 2019-05-16
 * @Description: 5.最长回文子串[https://leetcode-cn.com/problems/longest-palindromic-substring/]
 */
public class Solution {

    public String longestPalindrome(String s) {
        int start = 0, end = -1;
        int length = s.length();

        // 依次以i为中心点，寻找最长的回文串
        for (int i = 0; i < length; i++) {
            // k=0按奇数长度查找，k=1按偶数长度查找
            for (int k = 0; k <= 1; k++) {
                // l和r分别代表当前处理字符子串的头尾下标
                int l = i, r = i - k;

                // 如果下标不越界，且头尾字符相同，则头尾各向前扩展一位
                while (l - 1 >= 0 && r + 1 < length && s.charAt(l - 1) == s.charAt(r + 1)) {
                    l--;
                    r++;
                }

                // 如果寻找到的子串长度比暂存的最长结果更大，则替换
                if (r - l > end - start) {
                    start = l;
                    end = r;
                }
            }
        }

        return end == -1 ? "" : s.substring(start, end + 1);
    }
}
