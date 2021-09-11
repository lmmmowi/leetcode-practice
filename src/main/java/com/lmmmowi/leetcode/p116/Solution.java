package com.lmmmowi.leetcode.p116;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/11
 * @Description: 116. 填充每个节点的下一个右侧节点指针[https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/]
 */
public class Solution {

    public Node connect(Node root) {
        if (root != null) {
            connect(root, null);
        }
        return root;
    }

    private void connect(Node node, Node parent) {
        if (node.next == null && parent != null && parent.next != null) {
            node.next = parent.next.left;
        }
        if (node.left != null) {
            node.left.next = node.right;
            connect(node.left, node);
            connect(node.right, node);
        }
    }
}
