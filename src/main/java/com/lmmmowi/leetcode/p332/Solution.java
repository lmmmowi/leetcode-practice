package com.lmmmowi.leetcode.p332;

import java.util.*;

/**
 * @Author: 11102942
 * @Date: 2020/8/28
 * @Description: 332.重新安排行程[https://leetcode-cn.com/problems/reconstruct-itinerary/]
 */
public class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            PriorityQueue<String> queue = graph.computeIfAbsent(from, o -> new PriorityQueue<>());
            queue.add(to);
        }

        LinkedList<String> routine = new LinkedList<>();
        dfs(graph, "JFK", routine);
        return routine;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String currentAirport, LinkedList<String> routine) {
        PriorityQueue<String> options = graph.get(currentAirport);
        while (options != null && !options.isEmpty()) {
            String nextAirport = options.poll();
            dfs(graph, nextAirport, routine);
        }
        routine.addFirst(currentAirport);
    }
}
