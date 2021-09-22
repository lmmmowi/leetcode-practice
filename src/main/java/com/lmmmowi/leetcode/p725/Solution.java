package com.lmmmowi.leetcode.p725;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/22
 * @Description: 725. 分隔链表[https://leetcode-cn.com/problems/split-linked-list-in-parts/]
 */
public class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            n++;
        }

        int m = n / k;
        int remain = n - m * k;

        ListNode[] arr = new ListNode[k];
        node = head;
        for (int i = 0; i < k; i++) {
            int l = m;
            if (i < remain) {
                l++;
            }

            if (node != null) {
                arr[i] = node;
                for (int j = 0; j < l && node != null; j++) {
                    ListNode temp = node.next;
                    if (j + 1 == l) {
                        node.next = null;
                    }
                    node = temp;
                }
            }
        }
        return arr;
    }
}
