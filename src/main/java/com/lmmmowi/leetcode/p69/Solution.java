package com.lmmmowi.leetcode.p69;

/**
 * @Author: mowi
 * @Date: 2019/7/28
 * @Description: 69.x 的平方根[https://leetcode-cn.com/problems/sqrtx/]
 */
public class Solution {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int k = 1;
        while (k * k < x && k * k > 0) {
            k *= 2;
        }


        int low = (k + 1) / 2;
        int high = k;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int y = mid * mid;
            if (y > 0 && y == x) {
                return mid;
            } else if (y > 0 && y < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}
