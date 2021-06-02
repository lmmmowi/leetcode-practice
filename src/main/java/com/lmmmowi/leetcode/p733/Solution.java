package com.lmmmowi.leetcode.p733;

/**
 * @Author: lmmmowi
 * @Date: 2021/6/2
 * @Description: 733. 图像渲染[https://leetcode-cn.com/problems/flood-fill/]
 */
public class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
            new int[]{0, 1}, new int[]{0, -1},
            new int[]{1, 0}, new int[]{-1, 0},
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            fill(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    private void fill(int[][] image, int row, int col, int oldColor, int newColor) {
        image[row][col] = newColor;
        int rowCount = image.length;
        int colCount = image[0].length;
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount && image[nextRow][nextCol] == oldColor) {
                fill(image, nextRow, nextCol, oldColor, newColor);
            }
        }
    }
}
