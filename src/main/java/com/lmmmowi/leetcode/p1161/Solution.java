package com.lmmmowi.leetcode.p1161;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: mowi
 * @Date: 2022/07/31
 * @Description: 1161. 最大层内元素和[https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/]
 */
public class Solution {

    public int maxLevelSum(TreeNode root) {
        int maxVal = Integer.MIN_VALUE;
        int maxLayer = 0;
        int layer = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            layer++;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (sum > maxVal) {
                maxVal = sum;
                maxLayer = layer;
            }
        }
        return maxLayer;
    }
}
