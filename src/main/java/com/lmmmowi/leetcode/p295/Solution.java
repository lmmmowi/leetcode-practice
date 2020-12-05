package com.lmmmowi.leetcode.p295;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2020/11/6
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        for (int i = 1; i <= 10; i++) {
            medianFinder.addNum(i);
            System.out.println(medianFinder.findMedian());
        }
    }
}

class MedianFinder {

    private List<Integer> list = new ArrayList<>();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        for (int i = 0; i < list.size(); i++) {
            if (num < list.get(i)) {
                list.add(i, num);
                return;
            }
        }

        list.add(num);
    }

    public double findMedian() {
        int size = list.size();
        if (size == 0) {
            return 0;
        } else if (size % 2 == 1) {
            return list.get(size / 2);
        } else {
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
        }
    }
}