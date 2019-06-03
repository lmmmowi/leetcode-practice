package com.lmmmowi.leetcode.p31;

/**
 * @Author: mowi
 * @Date: 2019-06-03
 * @Description: 31.下一个排列[https://leetcode-cn.com/problems/next-permutation/]
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        boolean ok = handle(nums, 0);

        // 如果调整失败，说明nums已经是最大序列，直接将其反转
        if (!ok) {
            reverse(nums, 0, nums.length - 1);
        }
    }

    private boolean handle(int[] nums, int k) {
        // 只剩下最后一位，无法调整
        if (k >= nums.length - 1) {
            return false;
        }

        // 该方法保持第k位不动，尝试通过调整k之后的数字找到下一个更大的系列
        boolean ok = handle(nums, k + 1);

        // 如果无法调整成功（说明从k+1开始的数组已经是降序）
        if (!ok) {
            // 从k之后找到比nums[k]更大的数字，取其中最小的一个（因为已经是降序，所以从数组最后开始找，找到比nums[k]小的数即可）
            int index = -1;
            for (int i = nums.length - 1; i >= k + 1; i--) {
                if (nums[i] > nums[k]) {
                    index = i;
                    break;
                }
            }

            // 如果找到这样的数字，则与第k位进行交换，并将k+1到数组末尾的部分进行反转
            if (index >= 0) {
                swap(nums, k, index);
                reverse(nums, k + 1, nums.length - 1);

                // 标记调整成功
                ok = true;
            }
        }

        return ok;
    }

    /**
     * 交换数组两个位置上的数字
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    /**
     * 反转数组的一部分
     * @param nums
     * @param i
     * @param j
     */
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
