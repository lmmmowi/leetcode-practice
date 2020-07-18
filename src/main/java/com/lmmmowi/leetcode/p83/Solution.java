package com.lmmmowi.leetcode.p83;

/**
 * @Author: lmmmowi
 * @Date: 2019/8/9
 * @Description: 83.删除排序链表中的重复元素[https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/]
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.next.val == node.val) {
                while (node.next != null && node.next.val == node.val) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
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
