package com.lmmmowi.lcof.p6;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/18
 * @Description: 剑指 Offer 06. 从尾到头打印链表[https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/]
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(n - 1 - i);
        }
        return array;
    }
}
