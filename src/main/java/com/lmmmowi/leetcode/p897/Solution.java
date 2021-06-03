package com.lmmmowi.leetcode.p897;

/**
 * @Author: lmmmowi
 * @Date: 2021/6/2
 * @Description: 897. 递增顺序搜索树[https://leetcode-cn.com/problems/increasing-order-search-tree/]
 */
public class Solution {

    public TreeNode increasingBST(TreeNode root) {
        return dfs(root)[0];
    }

    private TreeNode[] dfs(TreeNode root) {
        TreeNode head;
        TreeNode tail;

        if (root.left == null) {
            head = root;
        } else {
            TreeNode[] nodes = dfs(root.left);
            nodes[1].right = root;
            root.left = null;
            head = nodes[0];
        }

        if (root.right == null) {
            tail = root;
        } else {
            TreeNode[] nodes = dfs(root.right);
            root.right = nodes[0];
            tail = nodes[1];
        }

        return new TreeNode[]{head, tail};
    }
}
