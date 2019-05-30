package com.lmmmowi.leetcode.p24;

/**
 * @Author: mowi
 * @Date: 2019-05-30
 * @Description: 24.两两交换链表中的节点[https://leetcode-cn.com/problems/swap-nodes-in-pairs/]
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode a = head, b, tail = null;

        while (a != null && (b = a.next) != null) {
            a.next = b.next;
            b.next = a;
            if (tail != null) {
                tail.next = b;
            } else {
                head = b;
            }
            tail = a;

            a = a.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}