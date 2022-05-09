package com.lmmmowi.leetcode.p1942;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: lmmmowi
 * @Date: 2022/5/9
 * @Description: 1942. 最小未被占据椅子的编号[https://leetcode.cn/problems/the-number-of-the-smallest-unoccupied-chair/]
 */
public class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[] chairTaken = new int[n];

        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            chairs.add(i);
        }

        List<Action> actions = this.getActions(times);
        for (Action action : actions) {
            if (action.arrive) {
                int chairIndex = chairs.poll();
                chairTaken[action.friendIndex] = chairIndex;

                if (action.friendIndex == targetFriend) {
                    return chairIndex;
                }
            } else {
                int chairIndex = chairTaken[action.friendIndex];
                chairs.add(chairIndex);
            }
        }

        return -1;
    }

    private List<Action> getActions(int[][] times) {
        List<Action> actions = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            Action action = new Action(i, times[i][0], true);
            actions.add(action);

            action = new Action(i, times[i][1], false);
            actions.add(action);
        }
        actions.sort(Comparator
                .comparingInt((Action action) -> action.time)
                .thenComparingInt((Action action) -> action.arrive ? 1 : 0));
        return actions;
    }

    private class Action {
        private int friendIndex;
        private int time;
        private boolean arrive;

        Action(int friendIndex, int time, boolean arrive) {
            this.friendIndex = friendIndex;
            this.time = time;
            this.arrive = arrive;
        }
    }
}
