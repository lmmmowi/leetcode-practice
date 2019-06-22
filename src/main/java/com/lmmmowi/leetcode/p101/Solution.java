package com.lmmmowi.leetcode.p101;

/**
 * @Author: mowi
 * @Date: 2019-06-22
 * @Description: 101.对称二叉树[https://leetcode-cn.com/problems/symmetric-tree/]
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return root == null || compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return compare(left.left, right.right) && compare(left.right , right.left);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}