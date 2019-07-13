package com.lmmmowi.leetcode.p61;

/**
 * @Author: mowi
 * @Date: 2019/7/13
 * @Description: 61.旋转链表[https://leetcode-cn.com/problems/rotate-list/]
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        k = k % len;

        ListNode newHead = head, prev = null;
        if (k > 0) {
            for (int i = 0; i < len - k; i++) {
                prev = newHead;
                newHead = newHead.next;
            }
        }

        if (head != newHead) {
            tail.next = head;
            prev.next = null;
        }
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}