package com.lmmmowi.leetcode.p318;

/**
 * @Author: lmmmowi
 * @Date: 2020/8/17
 * @Description: 318.最大单词长度乘积[https://leetcode-cn.com/problems/maximum-product-of-word-lengths/]
 */
public class Solution {

    public int maxProduct(String[] words) {
        int result = 0;

        int[] bitSets = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            bitSets[i] = 0;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                bitSets[i] |= 1 << (c - 'a');
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitSets[i] & bitSets[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }

        return result;
    }
}
