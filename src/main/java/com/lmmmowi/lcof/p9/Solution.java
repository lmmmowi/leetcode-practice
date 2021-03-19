package com.lmmmowi.lcof.p9;

import java.util.Stack;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/19
 * @Description: 剑指 Offer 09. 用两个栈实现队列[https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/]
 */
public class Solution {

    class CQueue {
        private Stack<Integer> in = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    int a = in.pop();
                    out.push(a);
                }
            }

            return out.isEmpty() ? -1 : out.pop();
        }
    }
}
