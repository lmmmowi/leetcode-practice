package com.lmmmowi.leetcode.p1281;

/**
 * @Author: mowi
 * @Date: 2021/7/11
 * @Description: 1281. 整数的各位积和之差[https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/]
 */
public class Solution {

    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            product *= a;
            sum += a;
        }

        return product - sum;
    }
}
