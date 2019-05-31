package com.lmmmowi.leetcode.p25;

/**
 * @Author: mowi
 * @Date: 2019-05-31
 * @Description: 25.K 个一组翻转链表[https://leetcode-cn.com/problems/reverse-nodes-in-k-group/]
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        ListNode[] arr = new ListNode[k];
        ListNode result = null, tracker = null, current = head;
        int n = 0;

        while (current != null) {
            if (n < k) {
                arr[n++] = current;
                current = current.next;
            }

            if (n >= k) {
                while (n > 0) {
                    ListNode node = arr[--n];
                    if (result == null) {
                        result = node;
                    }
                    if (tracker != null) {
                        tracker.next = node;
                    }
                    tracker = node;
                    tracker.next = null;
                }
            }
        }

        if (n > 0 && tracker != null) {
            tracker.next = arr[0];
        }

        return result == null ? head : result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
