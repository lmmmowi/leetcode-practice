package com.lmmmowi.leetcode.p874;

import java.util.*;

/**
 * @Author: lmmmowi
 * @Date: 2020/9/1
 * @Description: 874.模拟行走机器人[https://leetcode-cn.com/problems/walking-robot-simulation/]
 */
public class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        int maxDistance = 0;

        ObstacleMap obstacleMap = new ObstacleMap(obstacles);
        Robot robot = new Robot(0, 0, Direction.UP);
        for (int command : commands) {
            switch (command) {
                case -1:
                    robot.turnRight();
                    break;
                case -2:
                    robot.turnLeft();
                    break;
                default:
                    robot.move(command, obstacleMap);
                    maxDistance = Math.max(maxDistance, robot.getDistance(0, 0));
            }
        }

        return maxDistance;
    }

    private class Robot {

        private int x;
        private int y;
        private Direction direction;

        public Robot(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public void turnLeft() {
            this.direction = this.direction.getLeft();
        }

        public void turnRight() {
            this.direction = this.direction.getRight();
        }

        public void move(int step, ObstacleMap obstacleMap) {
            for (int i = 0; i < step; i++) {
                int targetX = x + direction.getMoveX();
                int targetY = y + direction.getMoveY();

                if (obstacleMap.hasObstacle(targetX, targetY)) {
                    break;
                } else {
                    this.x = targetX;
                    this.y = targetY;
                }
            }
        }

        public int getDistance(int targetX, int targetY) {
            int a = x - targetX;
            int b = y - targetY;
            return a * a + b * b;
        }
    }

    private class ObstacleMap {

        private Set<Long> set = new HashSet<>();

        public ObstacleMap(int[][] obstacles) {
            for (int[] obstacle : obstacles) {
                int x = obstacle[0];
                int y = obstacle[1];
                long val = getVal(x, y);
                set.add(val);
            }
        }

        public boolean hasObstacle(int x, int y) {
            long val = getVal(x, y);
            return set.contains(val);
        }

        private long getVal(int x, int y) {
            return ((x + 30000) << 16) + (y + 30000);
        }
    }

    private enum Direction {
        UP(0, 1),
        RIGHT(1, 0),
        DOWN(0, -1),
        LEFT(-1, 0);

        private int moveX;
        private int moveY;

        Direction(int moveX, int moveY) {
            this.moveX = moveX;
            this.moveY = moveY;
        }

        public int getMoveX() {
            return moveX;
        }

        public int getMoveY() {
            return moveY;
        }

        public Direction getRight() {
            int index = (this.ordinal() + 1) % 4;
            return values()[index];
        }

        public Direction getLeft() {
            int index = (this.ordinal() + 3) % 4;
            return values()[index];
        }
    }
}
