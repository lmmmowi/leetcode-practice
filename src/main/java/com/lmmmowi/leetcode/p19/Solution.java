package com.lmmmowi.leetcode.p19;

/**
 * @Author: mowi
 * @Date: 2019-05-29
 * @Description: 19.删除链表的倒数第N个节点[https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/]
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode k, nthNode, nthPreNode;
        k = nthNode = nthPreNode = head;

        // 遍历
        do {
            k = k.next;
            if (n > 0) {
                n--;
            } else {
                nthPreNode = nthNode;
                nthNode = nthNode.next;
            }
        } while (k != null);

        // 删除节点
        if (nthNode == head) {
            head = nthNode.next;
        } else {
            nthPreNode.next = nthNode.next;
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
