package com.lmmmowi.leetcode.p54;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: mowi
 * @Date: 2019/6/23
 * @Description: 54.螺旋矩阵[https://leetcode-cn.com/problems/spiral-matrix/]
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        final int RIGHT = 0, LEFT = 1, UP = 2, DOWN = 3;
        int direction = -1;
        int h = matrix.length, w = h > 0 ? matrix[0].length : 0;
        int l = 0, r = w - 1, t = 0, b = h - 1;
        int x = 0, y = 0;
        int size = w * h;
        int n = 0;

        List<Integer> list = new ArrayList<>();
        while (n++ < size) {
            switch (direction) {
                case RIGHT:
                    x++;
                    direction = x >= r ? DOWN : RIGHT;
                    t = direction == RIGHT ? t : t + 1;
                    break;
                case DOWN:
                    y++;
                    direction = y >= b ? LEFT : DOWN;
                    r = direction == DOWN ? r : r - 1;
                    break;
                case LEFT:
                    x--;
                    direction = x <= l ? UP : LEFT;
                    b = direction == LEFT ? b : b - 1;
                    break;
                case UP:
                    y--;
                    direction = y <= t ? RIGHT : UP;
                    l = direction == UP ? l : l + 1;
                    break;
                default:
                    direction = x >= r ? DOWN : RIGHT;
                    t = direction == RIGHT ? t : t + 1;
            }

            list.add(matrix[y][x]);
        }

        return list;
    }
}
