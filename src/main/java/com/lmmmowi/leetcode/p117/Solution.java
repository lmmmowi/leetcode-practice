package com.lmmmowi.leetcode.p117;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/11
 * @Description: 117. 填充每个节点的下一个右侧节点指针 II[https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/]
 */
public class Solution {

    public Node connect(Node root) {
        connect(root, null);
        return root;
    }

    private void connect(Node node, Node parent) {
        if (node == null) {
            return;
        }

        if (node.next == null && parent != null) {
            Node temp = parent.next;
            Node nextNode = null;
            while (nextNode == null && temp != null) {
                nextNode = temp.left != null ? temp.left : temp.right;
                temp = temp.next;
            }

            node.next = nextNode;
        }

        if (node.left != null) {
            node.left.next = node.right;
        }
        connect(node.right, node);
        connect(node.left, node);
    }
}
