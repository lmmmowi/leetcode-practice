package com.lmmmowi.leetcode.p310;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lmmmowi
 * @Date: 2023/4/10
 * @Description: 310. 最小高度树[https://leetcode.cn/problems/minimum-height-trees/]
 */
public class Solution {

    private Map<Integer, Integer>[] connectedMaps;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        connectedMaps = new Map[n];
        for (int i = 0; i < n; i++) {
            connectedMaps[i] = new HashMap<>();
        }

        for (int[] edge : edges) {
            connectedMaps[edge[0]].put(edge[1], null);
            connectedMaps[edge[1]].put(edge[0], null);
        }

        int minHeight = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            int height = calcHeight(i, visited);
            if (minHeight > height) {
                minHeight = height;
                result.clear();
            }
            if (minHeight == height) {
                result.add(i);
            }
        }

        return result;
    }

    public int calcHeight(int cur, boolean[] visited) {
        visited[cur] = true;

        Map<Integer, Integer> connectedNodes = connectedMaps[cur];
        if (connectedNodes.size() == 1) {
            return Integer.MAX_VALUE;
        }

        int height = 0;
        for (Integer child : connectedNodes.keySet()) {
            if (visited[child]) {
                continue;
            }

            Integer childHeight = connectedNodes.get(child);
            if (childHeight == null) {
                childHeight = calcHeight(child, visited);
                connectedNodes.put(child, childHeight);
            }

            height = Math.max(height, childHeight + 1);
        }
        return height;
    }
}
