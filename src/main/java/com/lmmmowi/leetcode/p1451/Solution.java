package com.lmmmowi.leetcode.p1451;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: lmmmowi
 * @Date: 2021/2/8
 * @Description: 1451.重新排列句子中的单词[https://leetcode-cn.com/problems/rearrange-words-in-a-sentence/]
 */
public class Solution {

    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        String newText = IntStream.range(0, words.length)
                .boxed()
                .map(index -> new Word(index, words[index]))
                .sorted(Comparator.comparingInt((Word o) -> o.value.length()).thenComparing((Word o) -> o.index))
                .map(o -> o.value.toLowerCase())
                .collect(Collectors.joining(" "));
        return newText.substring(0, 1).toUpperCase() + newText.substring(1);
    }

    private class Word {
        private int index;
        private String value;

        Word(int index, String value) {
            this.index = index;
            this.value = value;
        }
    }
}
