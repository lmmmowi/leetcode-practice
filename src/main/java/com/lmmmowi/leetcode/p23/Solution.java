package com.lmmmowi.leetcode.p23;

import java.util.Arrays;

/**
 * @Author: mowi
 * @Date: 2019-05-31
 * @Description: 23.合并K个排序链表[https://leetcode-cn.com/problems/merge-k-sorted-lists/]
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, tail = null;
        if (lists.length > 0) {
            // 建立并初始化败者树
            ListNode[] leaves = Arrays.copyOf(lists, lists.length + 1);
            int[] loserTree = buildLoserTree(leaves);

            // 循环
            while (true) {
                // 取出败者树顶点，即胜者（数值最小的节点）
                int winnerIndex = loserTree[0];
                ListNode winner = leaves[winnerIndex];

                // 胜者为空，则合并结束
                if (winner == null) {
                    break;
                }

                // 将胜者节点插入结果尾部
                ListNode node = new ListNode(winner.val);
                if (head == null) {
                    head = node;
                }
                if (tail != null) {
                    tail.next = node;
                }
                tail = node;

                // 继续调整败者树
                leaves[winnerIndex] = winner.next;
                adjustLoserTree(loserTree, leaves, winnerIndex);
            }
        }
        return head;
    }

    private int[] buildLoserTree(ListNode[] leaves) {
        int k = leaves.length - 1;

        // 叶节点最后额外多加一位leaves[k]，并初始化为最小值，保证其每次比较都能获胜
        leaves[k] = new ListNode(Integer.MIN_VALUE);

        // 将败者树所有节点初始化为leaves[k]的下标
        int[] loserTree = new int[k];
        for (int i = 0; i < loserTree.length; i++) {
            loserTree[i] = k;
        }

        // 按照叶节点数组顺序依次调整败者树，调整完成即初始化完毕
        for (int i = 0; i < k; i++) {
            adjustLoserTree(loserTree, leaves, i);
        }
        return loserTree;
    }

    private void adjustLoserTree(int[] loserTree, ListNode[] leaves, int i) {
        int parent = (loserTree.length + i) / 2;
        while (parent > 0) {
            int loserIndex = loserTree[parent];
            ListNode loser = leaves[loserIndex];
            ListNode current = leaves[i];

            if (current == null || (loser != null && current.val > loser.val)) {
                loserTree[parent] = i;
                i = loserIndex;
            }

            parent /= 2;
        }
        loserTree[parent] = i;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}