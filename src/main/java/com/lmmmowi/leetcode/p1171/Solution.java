package com.lmmmowi.leetcode.p1171;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/31
 * @Description: 1171. 从链表中删去总和值为零的连续节点[https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/]
 */
public class Solution {

    public ListNode removeZeroSumSublists(ListNode head) {
        int sum = 0;
        ListNode node = head;
        while (node != null) {
            sum += node.val;
            node = node.next;

            if (sum == 0) {
                head = node;
            }
        }

        if (head != null) {
            head.next = removeZeroSumSublists(head.next);
        }
        return head;
    }
}
