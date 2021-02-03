package com.lmmmowi.leetcode.p98;

/**
 * @Author: lmmmowi
 * @Date: 2021/2/3
 * @Description: 98.验证二叉搜索树[https://leetcode-cn.com/problems/validate-binary-search-tree/]
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        return (node == null)
                || ((min == null || node.val > min)
                && (max == null || node.val < max)
                && isValidBST(node.left, min, node.val)
                && isValidBST(node.right, node.val, max));
    }
}
