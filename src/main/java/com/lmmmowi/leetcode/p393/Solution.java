package com.lmmmowi.leetcode.p393;

/**
 * @Author: mowi
 * @Date: 2022/4/14
 * @Description: 393. UTF-8 编码验证[https://leetcode-cn.com/problems/utf-8-validation/]
 */
public class Solution {

    private static final int BYTE_10000000 = 0x80;
    private static final int BYTE_11000000 = 0xC0;

    public boolean validUtf8(int[] data) {
        int n = data.length;
        int ptr = 0;
        while (ptr < n) {
            int firstByte = data[ptr++];
            if ((firstByte & BYTE_10000000) == 0) {
                continue;
            }

            int len = detectBytesLength(firstByte);
            if (len <= 1 || len > 4) {
                return false;
            }

            for (int i = 0; i < len - 1; i++) {
                if (ptr >= n || (data[ptr++] & BYTE_11000000) != BYTE_10000000) {
                    return false;
                }
            }
        }
        return true;
    }

    private int detectBytesLength(int b) {
        int len = 0;
        while ((b & BYTE_10000000) > 0) {
            len++;
            b <<= 1;
        }
        return len;
    }
}
