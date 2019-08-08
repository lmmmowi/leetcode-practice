package com.lmmmowi.leetcode.p93;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 11102942
 * @Date: 2019/8/8
 * @Description: 93.复原IP地址[https://leetcode-cn.com/problems/restore-ip-addresses/]
 */
public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restore(result, s, new int[4], 0, 0);
        return result;
    }

    private void restore(List<String> result, String s, int[] parts, int index, int partIndex) {
        int length = s.length();
        if (partIndex == 4) {
            if (index == length) {
                String r = parts[0] + "." + parts[1] + "." + parts[2] + "." + parts[3];
                result.add(r);
            }
            return;
        }

        // 根据剩余长度提前作剪枝判断
        if (length - index > 3 * (4 - partIndex)) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            int n = index + i;
            if (n > s.length()) {
                break;
            }

            String k = s.substring(index, n);
            int v = k.charAt(0) == '0' && k.length() > 1 ? 256 : Integer.valueOf(k);
            if (v > 255) {
                break;
            } else {
                parts[partIndex] = v;
                restore(result, s, parts, n, partIndex + 1);
            }
        }
    }
}
