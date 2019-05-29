package com.lmmmowi.leetcode.p21;

/**
 * @Author: mowi
 * @Date: 2019-05-29
 * @Description: 21.合并两个有序链表[https://leetcode-cn.com/problems/merge-two-sorted-lists/]
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;

        while (l1 != null || l2 != null) {
            ListNode node = l1 == null ? l2 : (l2 == null ? l1 : (l1.val < l2.val ? l1 : l2));
            if (head == null) {
                head = tail = new ListNode(node.val);
            } else {
                tail.next = new ListNode(node.val);
                tail = tail.next;
            }

            if (node == l1) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
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