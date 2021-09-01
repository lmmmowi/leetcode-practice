package com.lmmmowi.leetcode.p743;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/1
 * @Description: 743. 网络延迟时间[https://leetcode-cn.com/problems/network-delay-time/]
 */
public class Solution {

    public static final int MAX_VALUE = 1000;

    public int networkDelayTime(int[][] times, int n, int k) {
        // edges[i][j]表示点i到点j的距离，不可达用MAX_VALUE表示
        int[][] edges = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    edges[i][j] = MAX_VALUE;
                }
            }
        }
        for (int[] time : times) {
            edges[time[0]][time[1]] = time[2];
        }

        // distances[i]表示点i到点k的距离
        int[] distances = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distances[i] = edges[k][i];
        }
        // 点k加入生成树，-1表示已加入
        distances[k] = -1;

        // 循环n-1次，依次选择距离点k最近的点加入生成树
        int maxCost = 0;
        for (int t = 1; t < n; t++) {
            int minDis = MAX_VALUE;
            int vertex = -1;

            // 遍历进行选择
            for (int i = 1; i <= n; i++) {
                if (distances[i] >= 0 && distances[i] < minDis) {
                    minDis = distances[i];
                    vertex = i;
                }
            }

            // 找不到说明存在某些点不可达
            if (vertex == -1) {
                return -1;
            }

            // 以新加入的点为基础，更新其他未加入生成树的点到k的距离
            for (int i = 1; i <= n; i++) {
                if (distances[i] >= 0) {
                    distances[i] = Math.min(distances[i], distances[vertex] + edges[vertex][i]);
                }
            }

            // 更新最大的最短路径
            maxCost = Math.max(maxCost, distances[vertex]);
            distances[vertex] = -1;
        }

        return maxCost;
    }
}
