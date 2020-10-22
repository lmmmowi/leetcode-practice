package com.lmmmowi.leetcode.p297;

/**
 * @Author: lmmmowi
 * @Date: 2020/10/22
 * @Description: 297.二叉树的序列化与反序列化[https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/]
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(3);

        Codec codec = new Codec();
        String s = codec.serialize(root);
        TreeNode tree = codec.deserialize(s);
        print(tree);
    }

    private static void print(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            System.out.print("L == ");
            print(node.left);
        }

        if (node.right != null) {
            System.out.print("R == ");
            print(node.right);
        }
    }
}
