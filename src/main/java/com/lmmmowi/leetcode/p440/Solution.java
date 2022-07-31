package com.lmmmowi.leetcode.p440;


/**
 * @Author: mowi
 * @Date: 2022/07/31
 * @Description: 440. 字典序的第K小数字[https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/]
 */
public class Solution {

    public int findKthNumber(int n, int k) {
        int cur = 1;
        while (true) {
            if (--k == 0) {
                return cur;
            }

            int childCount = this.getChildCount(n, cur);
            if (childCount < k) {
                cur += 1;
                k -= childCount;
            } else {
                cur *= 10;
            }
        }
    }

    private int getChildCount(int n, int cur) {
        int count = 0;
        int next = cur + 1;
        long first = cur;
        long last = next;

        while (true) {
            first *= 10;
            last *= 10;

            if (n >= last) {
                count += last - first;
            } else {
                if (n >= first) {
                    count += n + 1 - first;
                }

                return count;
            }
        }
    }
}
