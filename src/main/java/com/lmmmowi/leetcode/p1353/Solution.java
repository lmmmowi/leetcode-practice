package com.lmmmowi.leetcode.p1353;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: lmmmowi
 * @Date: 2022/1/17
 * @Description: 1353. 最多可以参加的会议数目[https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended/]
 */
public class Solution {

    public int maxEvents(int[][] events) {
        // 按照起始时间分组
        Map<Integer, List<Integer>> map = IntStream.range(0, events.length).boxed()
                .collect(Collectors.groupingBy(
                        i -> events[i][0],
                        Collectors.mapping(i -> events[i][1], Collectors.toList())
                ));

        // 创建一个按照结束时间排序的优先队列
        PriorityQueue<Integer> startedQueue = new PriorityQueue<>();

        int n = 0;
        for (int day = 1; !map.isEmpty() || !startedQueue.isEmpty(); day++) {
            List<Integer> list = map.remove(day);
            if (list != null) {
                startedQueue.addAll(list);
            }

            while (!startedQueue.isEmpty()) {
                int endDay = startedQueue.poll();
                if (day <= endDay) {
                    n++;
                    break;
                }
            }
        }
        return n;
    }
}
