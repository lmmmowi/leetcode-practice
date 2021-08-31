package com.lmmmowi.leetcode.p1584;

/**
 * @Author: lmmmowi
 * @Date: 2021/8/31
 * @Description: 1584. 连接所有点的最小费用[https://leetcode-cn.com/problems/min-cost-to-connect-all-points/]
 */
public class Solution {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int cost = 0;

        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }

        // 将节点0加入生成树
        boolean[] vertexes = new boolean[n];
        vertexes[0] = true;

        // 初始化所有点到生成树的最短距离
        int[] distanceToTree = new int[n];
        for (int i = 0; i < n; i++) {
            distanceToTree[i] = distances[0][i];
        }

        // 依次选择K条边加入
        for (int k = 0; k < n - 1; k++) {
            int newVertex = 0;
            int minDistance = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                // 选择一个未加入生成树的节点
                if (!vertexes[i]) {
                    if (distanceToTree[i] < minDistance) {
                        minDistance = distanceToTree[i];
                        newVertex = i;
                    }
                }
            }

            // 把边加入生成树
            vertexes[newVertex] = true;
            cost += minDistance;

            // 更新所有点到生成树的最短距离
            for (int i = 0; i < n; i++) {
                distanceToTree[i] = Math.min(distances[newVertex][i], distanceToTree[i]);
            }
        }

        return cost;
    }
}
