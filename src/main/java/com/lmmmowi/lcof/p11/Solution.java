package com.lmmmowi.lcof.p11;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/19
 * @Description: 剑指 Offer 11. 旋转数组的最小数字[https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/]
 */
public class Solution {

    public int minArray(int[] numbers) {
        int head = 0;
        int tail = numbers.length - 1;

        while (head < tail) {
            int middle = (head + tail) / 2;
            if (numbers[middle] > numbers[tail]) {
                head = middle + 1;
            } else if (numbers[head] > numbers[middle]) {
                tail = middle;
            } else {
                tail -= 1;
            }
        }

        return numbers[tail];
    }
}
