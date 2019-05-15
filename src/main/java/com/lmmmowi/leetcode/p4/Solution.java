package com.lmmmowi.leetcode.p4;

/**
 * @Author: mowi
 * @Date: 2019-05-14
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        double d = new Solution().findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        System.out.println(d);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] l, s;

        if (nums1.length >= nums2.length) {
            l = nums1;
            s = nums2;
        } else {
            l = nums2;
            s = nums1;
        }

        int llen = l.length, slen = s.length;
        if (slen == 0) {
            return llen % 2 == 1 ? l[llen / 2] : (l[llen / 2 - 1] + l[llen / 2]) / 2.0;
        }

        int head = 0, tail = llen - 1;
        while (true) {
            int i = (head + tail+1) / 2;
            int j = (llen + slen) / 2 - (i + 1) - 1;

            int rightMin = Math.min(i + 1 < llen ? l[i + 1] : Integer.MAX_VALUE, j + 1 < slen ? s[j + 1] : Integer.MAX_VALUE);

            System.out.println(i + " == " + j);

            if (i >= 0 && l[i] > rightMin) {
                tail = i;

                if (head == 0 && tail == 0) {
                    head = tail = -1;
                }
            } else if (j >= 0 && s[j] > rightMin) {
                head = i + 1;
            } else {
                if ((llen + slen) % 2 == 1) {
                    return rightMin;
                } else {
                    int leftMax = Math.max(i >= 0 ? l[i] : Integer.MIN_VALUE, j >= 0 ? s[j] : Integer.MIN_VALUE);
                    return (leftMax + rightMin) / 2.0;
                }
            }
        }
    }
}
