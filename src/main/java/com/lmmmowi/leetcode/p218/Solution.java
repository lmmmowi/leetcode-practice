package com.lmmmowi.leetcode.p218;

import java.util.*;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/9
 * @Description: 218. 天际线问题[https://leetcode-cn.com/problems/the-skyline-problem/]
 */
public class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        Comparator<Integer> comparator = Comparator.comparingInt((Integer index) -> buildings[index][2]).reversed();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(comparator);

        List<List<Integer>> result = new ArrayList<>();
        int prevHeight = -1;
        int prevX = -1;
        boolean[] included = new boolean[buildings.length];

        List<Boundary> boundaries = this.getSortedBoundaries(buildings);
        for (Boundary boundary : boundaries) {
            int curIndex = boundary.buildingIndex;
            if (included[curIndex]) {
                included[curIndex] = false;

                // 延迟删除，只有当无效index到达优先队列顶部时才进行删除，使得删除的复杂度从O(n)提升到O(1)
                while (!maxQueue.isEmpty() && !included[maxQueue.peek()]) {
                    maxQueue.poll();
                }
            } else {
                maxQueue.offer(curIndex);
                included[curIndex] = true;
            }

            int maxHeight = maxQueue.isEmpty() ? 0 : buildings[maxQueue.peek()][2];
            if (maxHeight != prevHeight) {
                if (boundary.x != prevX) {
                    result.add(Arrays.asList(boundary.x, maxHeight));
                } else {
                    List<Integer> list = result.get(result.size() - 1);
                    list.set(1, maxHeight);
                }

                prevX = boundary.x;
                prevHeight = maxHeight;
            }
        }
        return result;
    }

    private List<Boundary> getSortedBoundaries(int[][] buildings) {
        List<Boundary> boundaries = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            boundaries.add(new Boundary(i, building[0]));
            boundaries.add(new Boundary(i, building[1]));
        }
        Collections.sort(boundaries);
        return boundaries;
    }

    private class Boundary implements Comparable<Boundary> {
        private Integer buildingIndex;
        private Integer x;

        private Boundary(int buildingIndex, int x) {
            this.buildingIndex = buildingIndex;
            this.x = x;
        }

        @Override
        public int compareTo(Boundary o) {
            int result = x.compareTo(o.x);
            return result != 0 ? result : o.buildingIndex.compareTo(buildingIndex);
        }
    }
}
