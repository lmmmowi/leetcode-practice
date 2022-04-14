package com.lmmmowi.leetcode.p513;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: mowi
 * @Date: 2022/4/14
 * @Description: 513. 找树左下角的值[https://leetcode-cn.com/problems/find-bottom-left-tree-value/]
 */
public class Solution {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int leftValue = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    leftValue = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return leftValue;
    }
}
