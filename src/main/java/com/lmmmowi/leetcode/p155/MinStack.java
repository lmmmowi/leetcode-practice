package com.lmmmowi.leetcode.p155;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/8
 * @Description:
 */
public class MinStack {

    private List<Integer> list;
    private List<Integer> minValues;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        list = new ArrayList<>();
        minValues = new ArrayList<>();
    }

    public void push(int x) {
        int min = list.isEmpty() ? x : Math.min(getMin(), x);
        list.add(x);
        minValues.add(min);
    }

    public void pop() {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
        minValues.remove(lastIndex);
    }

    public int top() {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public int getMin() {
        int lastIndex = list.size() - 1;
        return minValues.get(lastIndex);
    }
}
