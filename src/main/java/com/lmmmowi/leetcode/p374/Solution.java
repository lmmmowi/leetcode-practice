package com.lmmmowi.leetcode.p374;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/10
 * @Description: 374.猜数字大小[https://leetcode-cn.com/problems/guess-number-higher-or-lower/]
 */
public class Solution {

    public int guessNumber(int n) {
        int min = 1;
        int max = n;
        int result;

        do {
            result = min + (max - min) / 2;
            int flag = guess(result);
            if (flag == -1) {
                max = result - 1;
            } else if (flag == 1) {
                min = result + 1;
            } else {
                break;
            }
        } while (true);

        return result;
    }

    int guess(int num) {
        return 0;
    }
}
