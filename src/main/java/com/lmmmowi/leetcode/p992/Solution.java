package com.lmmmowi.leetcode.p992;

/**
 * @Author: lmmmowi
 * @Date: 2021/2/10
 * @Description: 992.K 个不同整数的子数组[https://leetcode-cn.com/problems/subarrays-with-k-different-integers/]
 */
public class Solution {

    public int subarraysWithKDistinct(int[] array, int k) {
        return subarraysWithAtMostKDistinct(array, k) - subarraysWithAtMostKDistinct(array, k - 1);
    }

    private int subarraysWithAtMostKDistinct(int[] array, int k) {
        int sum = 0;
        if (k > 0) {
            int length = array.length, left = 0, right = -1, distinctSize = 0, lastCount = 1;
            int[] frequencies = new int[length + 1];
            while (left < length) {
                int count = lastCount - 1;

                while (right < length - 1) {
                    // 右指针前进
                    if (frequencies[array[++right]]++ == 0) {
                        distinctSize++;
                    }

                    if (distinctSize <= k) {
                        count++;
                    } else {
                        // 右指针后退
                        frequencies[array[right--]] = 0;
                        distinctSize--;
                        break;
                    }
                }

                sum += (lastCount = count);

                // 左指针前进
                if (--frequencies[array[left++]] == 0) {
                    distinctSize--;
                }
            }
        }
        return sum;
    }
}
