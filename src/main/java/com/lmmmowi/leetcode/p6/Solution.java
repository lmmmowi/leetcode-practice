package com.lmmmowi.leetcode.p6;

/**
 * @Author: mowi
 * @Date: 2019-05-25
 * @Description: 6.Z 字形变换[https://leetcode-cn.com/problems/zigzag-conversion/]
 */
public class Solution {

    public String convert(String s, int numRows) {
        StringBuilder stringBuilder = new StringBuilder();

        int length = s.length();
        if (length > 0) {
            int batchSize = numRows == 1 ? 1 : numRows + numRows - 2;

            for (int i = 0; i < numRows; i++) {
                int ra = i;
                int rb = (numRows - 1) * 2 - i;

                if ((rb - ra) % batchSize == 0) {
                    rb = length;
                }

                while (ra < length || rb < length) {
                    if (ra < length) {
                        stringBuilder.append(s.charAt(ra));
                        ra += batchSize;
                    }

                    if (rb < length) {
                        stringBuilder.append(s.charAt(rb));
                        rb += batchSize;
                    }
                }
            }
        }

        return stringBuilder.toString();
    }
}
