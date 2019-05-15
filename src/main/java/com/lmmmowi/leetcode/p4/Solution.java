package com.lmmmowi.leetcode.p4;

/**
 * @Author: mowi
 * @Date: 2019-05-14
 * @Description: 4.寻找两个有序数组的中位数[https://leetcode-cn.com/problems/median-of-two-sorted-arrays/]
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 交换数组顺序，保证l的长度大于s，且l的Min元素不大于s的Max元素
         */
        int[][] arr = sortArrayReference(nums1, nums2);
        int[] l = arr[0], s = arr[1];

        /**
         * 通过二分查找的方式，每次把l数组切割成以lp为分界的两个部分，同时把s数组切割成以sp为分界的两部分，
         * l和s的前半部分组合为LEFT_PART，l和s的后半部分组合为RIGHT_PART，
         * 使得 LEFT_PART.length = RIGHT_PART.length || LEFT_PART.length = RIGHT_PART.length + 1
         * 并且满足 Max(LEFT_PART) < Min(RIGHT_PART)，此时即可得到答案
         * 如无法满足，则继续调整通过二分法调整lp和sp
         */
        int llen = l.length, slen = s.length;
        int head = 0, tail = l.length - 1;
        while (true) {
            int lp = (head + tail) / 2;
            int ssize = (llen + slen + 1) / 2 - (lp + 1);
            int sp = ssize - 1;

            // s数组分割的位置不合法，需要调整
            if (ssize < 0) {
                tail = lp;
                continue;
            } else if (ssize > slen) {
                head = lp + 1;
                continue;
            }

            int rightMin = Math.min(lp + 1 < llen ? l[lp + 1] : Integer.MAX_VALUE, sp + 1 < slen ? s[sp + 1] : Integer.MAX_VALUE);
            if (l[lp] > rightMin) {
                tail = lp;
            } else if (ssize > 0 && s[sp] > rightMin) {
                head = lp + 1;
            } else {
                int leftMax = Math.max(lp >= 0 ? l[lp] : Integer.MIN_VALUE, sp >= 0 ? s[sp] : Integer.MIN_VALUE);
                if ((llen + slen) % 2 == 1) {
                    return leftMax;
                } else {
                    return (leftMax + rightMin) / 2.0;
                }
            }
        }
    }

    private int[][] sortArrayReference(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return new int[][]{nums1, nums2};
        } else if (nums1.length < nums2.length) {
            return new int[][]{nums2, nums1};
        } else if (nums1[0] >= nums2[nums2.length - 1]) {
            return new int[][]{nums2, nums1};
        } else {
            return new int[][]{nums1, nums2};
        }
    }
}
