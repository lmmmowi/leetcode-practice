package com.lmmmowi.leetcode.p744;

import java.util.Arrays;

/**
 * @Author: mowi
 * @Date: 2022/3/8
 * @Description: 744. 寻找比目标字母大的最小字母[https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/]
 */
public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }
}
