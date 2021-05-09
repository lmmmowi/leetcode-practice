package com.lmmmowi.leetcode.p1656;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: mowi
 * @Date: 2021/5/10
 * @Description: 1656. 设计有序流[https://leetcode-cn.com/problems/design-an-ordered-stream/]
 */
public class Solution {

}

class OrderedStream {

    private String[] array;
    private int ptr;

    public OrderedStream(int n) {
        array = new String[n];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        int index = idKey - 1;
        array[index] = value;

        List<String> result = Collections.emptyList();
        if (ptr == idKey) {
            result = new ArrayList<>();
            while (ptr <= array.length && array[ptr - 1] != null) {
                result.add(array[ptr - 1]);
                ptr++;
            }
        }
        return result;
    }
}
