package com.lmmmowi.leetcode.p382;

import java.util.Random;

/**
 * @Author: lmmmowi
 * @Date: 2020/12/28
 * @Description: 382.链表随机节点[https://leetcode-cn.com/problems/linked-list-random-node/]
 */
public class Solution {

    private ListNode head;
    private int length;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
        this.length = getLength();
    }

    private int getLength() {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    public int getRandom() {
        int index = random.nextInt(length);
        long n = 0;
        ListNode node = head;
        while (n++ < index) {
            if (node.next != null) {
                node = node.next;
            } else {
                node = head;
            }
        }
        return node.val;
    }
}
