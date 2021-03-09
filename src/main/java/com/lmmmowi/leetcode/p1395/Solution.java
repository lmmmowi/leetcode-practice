package com.lmmmowi.leetcode.p1395;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/9
 * @Description: 1395.统计作战单位数[https://leetcode-cn.com/problems/count-number-of-teams/]
 */
public class Solution {

    public int numTeams(int[] rating) {
        int num = 0;
        for (int i = 0; i < rating.length; i++) {
            int l1 = 0, l2 = 0, r1 = 0, r2 = 0;

            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    l1++;
                } else {
                    l2++;
                }
            }

            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > rating[i]) {
                    r1++;
                } else {
                    r2++;
                }
            }

            num += l1 * r1 + l2 * r2;
        }
        return num;
    }
}
