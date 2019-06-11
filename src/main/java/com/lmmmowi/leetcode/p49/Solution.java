package com.lmmmowi.leetcode.p49;

import java.util.*;

/**
 * @Author: mowi
 * @Date: 2019-06-11
 * @Description: 49.字母异位词分组[https://leetcode-cn.com/problems/group-anagrams/]
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String stamp = getStamp(str);
            List<String> list = map.get(stamp);
            if (list == null) {
                list = new ArrayList<>();
                map.put(stamp, list);
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String getStamp(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
