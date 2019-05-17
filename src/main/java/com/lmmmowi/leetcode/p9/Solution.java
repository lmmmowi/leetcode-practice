package com.lmmmowi.leetcode.p9;

/**
 * @Author: mowi
 * @Date: 2019-05-17
 * @Description: 9.回文数[https://leetcode-cn.com/problems/palindrome-number/]
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().isPalindrome(2147483647);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int[] arr = new int[11];
        int n = 0;
        while (x > 0) {
            arr[n++] = x % 10;
            x /= 10;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            if (arr[l++] != arr[r--]) {
                return false;
            }
        }

        return true;
    }
}
