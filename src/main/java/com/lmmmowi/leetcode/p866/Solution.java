package com.lmmmowi.leetcode.p866;

/**
 * @Author: lmmmowi
 * @Date: 2020/8/12
 * @Description: 866.回文素数[https://leetcode-cn.com/problems/prime-palindrome/]
 */
public class Solution {

    public int primePalindrome(int n) {
        int x = isPalindrome(n) ? n : nextPalindrome(n - 1);
        while (!isPrime(x)) {
            x = nextPalindrome(x);
        }
        return x;
    }

    private int nextPalindrome(int x) {
        int length = getLength(x);

        for (int i = 0; i < length / 2; i++) {
            x /= 10;
        }
        x += 1;

        int reverse = reverse(x);
        if (length % 2 == 1) {
            x = x / 10 * 10;
        }
        for (int i = 0; i < length / 2; i++) {
            x *= 10;
        }
        x += reverse;

        return x;
    }

    private int getLength(int x) {
        if (x == 0) {
            return 1;
        }
        int length = 0;
        while (x > 0) {
            x /= 10;
            length++;
        }
        return length;
    }

    private boolean isPalindrome(int x) {
        return x == reverse(x);
    }

    private int reverse(int x) {
        int y = 0;
        while (x > 0) {
            y = y * 10 + (x % 10);
            x /= 10;
        }
        return y;
    }

    private boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        int limit = (int) Math.sqrt(x);
        for (int i = 2; i <= limit; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
