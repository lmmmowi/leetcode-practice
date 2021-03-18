package com.lmmmowi.lcof.p5;

/**
 * @Author: lmmmowi
 * @Date: 2021/3/18
 * @Description: 剑指 Offer 05. 替换空格[https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/]
 */
public class Solution {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
