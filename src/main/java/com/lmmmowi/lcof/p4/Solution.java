package com.lmmmowi.lcof.p4;

/**
 * @Author: 11102942
 * @Date: 2021/3/18
 * @Description: 剑指 Offer 04. 二维数组中的查找[https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/]
 */
public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0 && matrix[i][0] <= target) {
                boolean found = find(matrix[i], target);
                if (found) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    private boolean find(int[] row, int target) {
        int head = 0;
        int tail = row.length - 1;
        while (head <= tail) {
            int middle = (head + tail) / 2;
            if (row[middle] > target) {
                tail = middle - 1;
            } else if (row[middle] < target) {
                head = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
