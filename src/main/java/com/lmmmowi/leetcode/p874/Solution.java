package com.lmmmowi.leetcode.p874;

import java.util.*;

/**
 * @Author: 11102942
 * @Date: 2020/9/1
 * @Description: 874.模拟行走机器人[https://leetcode-cn.com/problems/walking-robot-simulation/]
 */
public class Solution {

    private static final int ORIGIN_X = 0;
    private static final int ORIGIN_Y = 0;

    private static final int UP = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;

    private int cx = ORIGIN_X;
    private int cy = ORIGIN_Y;
    private int direction = UP;

    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] obstacle : obstacles) {
            int x = obstacle[0];
            int y = obstacle[1];

            Set<Integer> set = map.computeIfAbsent(x, o -> new HashSet<>());
            set.add(y);
        }

        int distance = 0;
        for (int command : commands) {
            switch (command) {
                case -1:
                    turnRight();
                    break;
                case -2:
                    turnLeft();
                    break;
                default:
                    int step = 0;
                    while (step < command && move(map)) {
                        step++;
                    }
                    distance = Math.max(distance, calculateDistance());
            }
        }

        return distance;
    }

    private int calculateDistance() {
        return cx * cx + cy * cy;
    }

    private void turnRight() {
        direction = (direction + 1) % 4;
    }

    private void turnLeft() {
        direction = (direction + 3) % 4;
    }

    private boolean move(Map<Integer, Set<Integer>> map) {
        int x = cx;
        int y = cy;

        switch (direction) {
            case UP:
                y++;
                break;
            case RIGHT:
                x++;
                break;
            case DOWN:
                y--;
                break;
            case LEFT:
                x--;
                break;
            default:
        }

        boolean isBlocked = map.getOrDefault(x, Collections.emptySet()).contains(y);
        if (isBlocked) {
            return false;
        } else {
            cx = x;
            cy = y;
            return true;
        }
    }
}
