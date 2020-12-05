package com.lmmmowi.leetcode.p630;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: lmmmowi
 * @Date: 2020/11/30
 * @Description: 630.课程表 III[https://leetcode-cn.com/problems/course-schedule-iii/]
 */
public class Solution {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt((Integer o) -> o).reversed());
        int m = 0;
        int time = 0;
        for (int[] c : courses) {
            if (time + c[0] > c[1]) {
                if (priorityQueue.peek() != null && priorityQueue.peek() > c[0]) {
                    time -= priorityQueue.poll();
                } else {
                    continue;
                }
            } else {
                m++;
            }

            priorityQueue.add(c[0]);
            time += c[0];
        }

        return m;
    }
}
