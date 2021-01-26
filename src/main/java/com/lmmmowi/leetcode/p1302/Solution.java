package com.lmmmowi.leetcode.p1302;


/**
 * @Author: lmmmowi
 * @Date: 2021/1/26
 * @Description: 1302.层数最深叶子节点的和[https://leetcode-cn.com/problems/deepest-leaves-sum/]
 */
public class Solution {

    private int maxLevel = -1;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root, 0);
        return sum;
    }

    private void deepestLeavesSum(TreeNode node, int currentLevel) {
        if (node == null) {
            return;
        }

        if (currentLevel > maxLevel) {
            sum = node.val;
            maxLevel = currentLevel;
        } else if (currentLevel == maxLevel) {
            sum += node.val;
        }

        deepestLeavesSum(node.left, currentLevel + 1);
        deepestLeavesSum(node.right, currentLevel + 1);
    }
}
