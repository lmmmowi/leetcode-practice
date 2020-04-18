package com.lmmmowi.leetcode.p138;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: mowi
 * @Date: 2020/2/3
 * @Description: 138.复制带随机指针的链表[https://leetcode-cn.com/problems/copy-list-with-random-pointer/]
 */
public class Solution {

    public static void main(String[] args) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node0.next = node1;
        node1.next = node2;
        node1.random = node0;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.random = node0;

        Node newList = new Solution().copyRandomList(node0);
        print(node0);
        print(newList);
    }

    private static void print(Node node) {
        while (node != null) {
            System.out.println(node.val + " " + node.random);
            node = node.next;
        }
        System.out.println("=====================");
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> hash = new HashMap<>();
        return copyNode(head, hash);
    }

    private Node copyNode(Node origin, Map<Node, Node> hash) {
        if (origin == null) {
            return null;
        }

        Node node = hash.get(origin);
        if (node == null) {
            node = new Node(origin.val);
            hash.put(origin, node);

            node.random = copyNode(origin.random, hash);
            node.next = copyNode(origin.next, hash);
        }
        return node;
    }

}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}