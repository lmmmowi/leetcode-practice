package com.lmmmowi.leetcode.p1598;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: mowi
 * @Date: 2022/2/7
 * @Description: 1598. 文件夹操作日志搜集器[https://leetcode-cn.com/problems/crawler-log-folder/]
 */
public class Solution {

    public int minOperations(String[] logs) {
        Deque<String> stack = new LinkedList<>();
        for (String log : logs) {
            if ("./".equals(log)) {
                continue;
            }

            if ("../".equals(log)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(log);
            }
        }
        return stack.size();
    }
}
