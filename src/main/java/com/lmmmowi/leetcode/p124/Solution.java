package com.lmmmowi.leetcode.p124;

/**
 * @Author: lmmmowi
 * @Date: 2022/5/10
 * @Description: 124. 二叉树中的最大路径和[https://leetcode.cn/problems/binary-tree-maximum-path-sum/]
 */
public class Solution {

    private int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathVal(root);
        return maxVal;
    }

    private int getMaxPathVal(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(getMaxPathVal(node.left), 0);
        int right = Math.max(getMaxPathVal(node.right), 0);
        maxVal = Math.max(maxVal, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
