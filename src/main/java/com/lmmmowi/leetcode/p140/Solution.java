package com.lmmmowi.leetcode.p140;

import java.util.*;

/**
 * @Author: lmmmowi
 * @Date: 2020/7/4
 * @Description: 140.单词拆分 II[https://leetcode-cn.com/problems/word-break/submissions-ii/]
 */
public class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Range[] ranges = new Range[s.length() + 1];
        ranges[0] = new Range(0);

        Map<Integer, List<String>> wordMap = new HashMap<>();
        wordDict.forEach(word -> {
            List<String> list = wordMap.computeIfAbsent(word.length(), o -> new ArrayList<>());
            list.add(word);
        });

        for (int i = 1; i <= s.length(); i++) {
            Range range = null;

            for (String word : wordDict) {
                int beginIndex = i - word.length();
                if (beginIndex < 0 || ranges[beginIndex] == null) {
                    continue;
                }

                String temp = s.substring(beginIndex, i);
                if (temp.equals(word)) {
                    if (range == null) {
                        range = new Range(word.length());
                    } else {
                        range.add(word.length());
                    }
                }
            }
            ranges[i] = range;
        }

        Range range = ranges[s.length()];
        if (range == null) {
            return Collections.emptyList();
        }

        List<String> sentences = new ArrayList<>();
        getSentences(s, ranges, s.length(), sentences, new Stack<>());

        return sentences;
    }

    private void getSentences(String s, Range[] ranges, int position, List<String> sentences, Stack<String> stack) {
        if (position == 0) {
            Collections.reverse(stack);
            String sentence = String.join(" ", stack);
            sentences.add(sentence);
            Collections.reverse(stack);
            return;
        }

        Range range = ranges[position];
        range.forEach(length -> {
            String word = s.substring(position - length, position);
            stack.push(word);
            getSentences(s, ranges, position - length, sentences, stack);
            stack.pop();
        });
    }

    private class Range extends ArrayList<Integer> {
        Range(Integer data) {
            this.add(data);
        }
    }
}
