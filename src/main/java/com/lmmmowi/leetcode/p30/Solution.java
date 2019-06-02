package com.lmmmowi.leetcode.p30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: mowi
 * @Date: 2019/6/2
 * @Description: 30.串联所有单词的子串[https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/]
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length > 0) {
            // 将words转化为[单词->个数]的Map
            Map<String, Integer> wordsMap = new HashMap<>();
            for (String word : words) {
                wordsMap.computeIfPresent(word, (w, c) -> c + 1);
                wordsMap.putIfAbsent(word, 1);
            }

            for (int i = 0; i < words[0].length(); i++) {
                result.addAll(findSubstringByOffset(i, wordsMap, s, words));
            }
        }
        return result;
    }

    private List<Integer> findSubstringByOffset(int offset, Map<String, Integer> wordsMap, String s, String[] words) {
        // 将字符串转化为单词数组
        int wordLen = words[0].length();
        String[] arr = new String[(s.length() - offset) / wordLen];
        for (int i = 0; i < arr.length; i++) {
            int a = offset + i * wordLen;
            arr[i] = s.substring(a, a + wordLen);
        }

        // 复制wordsMap，避免每次重新构造
        Map<String, Integer> map = new HashMap<>(wordsMap);

        // 遍历单词数组，按照滑动窗口的思想寻找
        List<Integer> list = new ArrayList<>();
        Integer index = null;
        int m = words.length;
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            int wordCount;
            while ((wordCount = map.getOrDefault(word, 0)) > 0 || index != null) {
                if (wordCount > 0) {
                    map.put(word, wordCount - 1);

                    // 记录窗口起始位置
                    if (index == null) {
                        index = i;
                    }

                    // 找到目标结果
                    if (--m == 0) {
                        list.add(index * wordLen + offset);

                        // 缩进窗口起始位置
                        m++;
                        map.computeIfPresent(arr[index], (w, c) -> c + 1);
                        index = index < i ? index + 1 : null;
                    }

                    break;
                } else {
                    // 缩进窗口起始位置
                    m++;
                    map.computeIfPresent(arr[index], (w, c) -> c + 1);
                    index = index < i - 1 ? index + 1 : null;
                }
            }
        }
        return list;
    }
}
