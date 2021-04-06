package com.lmmmowi.leetcode.p452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: lmmmowi
 * @Date: 2021/4/6
 * @Description: 452. 用最少数量的箭引爆气球[https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/]
 */
public class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(arr -> arr[1]));

        int arrow = 0, shots = 0;
        for (int i = 0; i < points.length; i++) {
            if (i == 0 || points[i][0] > arrow) {
                arrow = points[i][1];
                shots += 1;
            }
        }
        return shots;
    }
}
