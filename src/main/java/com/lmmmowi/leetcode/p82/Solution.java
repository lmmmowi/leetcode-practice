package com.lmmmowi.leetcode.p82;

/**
 * @Author: lmmmowi
 * @Date: 2019/8/9
 * @Description: 82.删除排序链表中的重复元素 II[https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/]
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;

        ListNode pre = tmp;
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.next.val == node.val) {
                while (node.next != null && node.next.val == node.val) {
                    node.next = node.next.next;
                }

                pre.next = node.next;
                node = node.next;
            } else {
                pre = node;
                node = node.next;
            }
        }

        return tmp.next;
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}