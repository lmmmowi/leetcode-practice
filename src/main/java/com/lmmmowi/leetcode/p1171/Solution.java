package com.lmmmowi.leetcode.p1171;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/31
 * @Description: 1171. 从链表中删去总和值为零的连续节点[https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/]
 */
public class Solution {

    public ListNode removeZeroSumSublists(ListNode head) {
        List<Record> records = new ArrayList<>();

        ListNode node = head, prev = null;
        while (node != null) {
            records.add(new Record(node, prev));

            int targetIndex = -1;
            for (int i = records.size() - 1; i >= 0; i--) {
                Record record = records.get(i);
                int sum = record.sum + node.val;
                if (sum == 0) {
                    targetIndex = i;
                } else {
                    record.sum = sum;
                }
            }

            if (targetIndex >= 0) {
                Record targetRecord = records.get(targetIndex);
                for (int i = records.size() - 1; i >= targetIndex; i--) {
                    records.remove(i);
                }

                prev = targetRecord.prev;
                if (prev == null) {
                    head = node.next;
                } else {
                    prev.next = node.next;
                }
            } else {
                prev = node;
            }

            node = node.next;
        }
        return head;
    }


    private class Record {
        ListNode node;
        ListNode prev;
        int sum;

        private Record(ListNode node, ListNode prev) {
            this.node = node;
            this.prev = prev;
        }
    }
}
