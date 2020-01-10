package com.lmmmowi.leetcode.p935;

/**
 * @Author: 11102942
 * @Date: 2020/1/10
 * @Description: 935.骑士拨号器[https://leetcode-cn.com/problems/knight-dialer/]
 */
public class Solution {

    public int knightDialer(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 10;
        }

        long[] arr = new long[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = 1;
        }

        // 注意到，1379是等价的，28是等价的，46是等价的，可以减少重复计算
        long mod = 1000000007;
        long[] temp = new long[10];
        for (int i = 1; i < N; i++) {
            temp[0] = (arr[4] << 1) % mod;
            temp[1] = (arr[6] + arr[8]) % mod;
            temp[2] = (arr[7] << 1) % mod;
            temp[3] = temp[1];
            temp[4] = ((arr[3] << 1) + arr[0]) % mod;
            temp[5] = 0;
            temp[6] = temp[4];
            temp[7] = temp[1];
            temp[8] = temp[2];
            temp[9] = temp[7];

            long[] swap = arr;
            arr = temp;
            temp = swap;
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += arr[i];
        }

        return (int) (sum % mod);
    }

}
