package com.lmmmowi.leetcode.p1328;

/**
 * @Author: 11102942
 * @Date: 2020/9/12
 * @Description: 1328.破坏回文串[https://leetcode-cn.com/problems/break-a-palindrome/]
 */
public class Solution {

    public String breakPalindrome(String palindrome) {
        int length = palindrome.length();
        if (length <= 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder(palindrome);

        int middle = length % 2 == 0 ? -1 : length / 2;
        for (int i = 0; i < length; i++) {
            if (i != middle) {
                if (palindrome.charAt(i) != 'a') {
                    sb.setCharAt(i, 'a');
                    return sb.toString();
                }
            }
        }

        sb.setCharAt(length - 1, 'b');
        return sb.toString();
    }

}
