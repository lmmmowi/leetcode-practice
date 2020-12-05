package com.lmmmowi.leetcode.p1632;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2020/12/5
 * @Description: 1632.矩阵转换后的秩[https://leetcode-cn.com/problems/rank-transform-of-a-matrix/]
 */
public class Solution {

    public int[][] matrixRankTransform(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        // 创建节点列表
        List<Node> nodes = new ArrayList<>();
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                Node node = new Node(r, c, matrix[r][c]);
                nodes.add(node);
            }
        }

        // 构建并查关系
        this.unionNodes(nodes, rowNum, colNum);

        // 初始化各行各列的秩
        int[] rowRanks = new int[rowNum];
        int[] colRanks = new int[colNum];

        // 排序并计算各节点的秩
        nodes.sort(Comparator.comparingInt(o -> o.value));
        for (Node node : nodes) {
            if (node == node.parent) {
                this.setRank(node, rowRanks, colRanks);
            }
        }

        for (Node node : nodes) {
            matrix[node.row][node.col] = node.rank;
        }
        return matrix;
    }

    private void setRank(Node node, int[] rowRanks, int[] colRanks) {
        // 求出并查集所有节点所在行列中最大的秩
        int maxRank = Math.max(rowRanks[node.row], colRanks[node.col]);
        if (node.unionNodes != null) {
            for (Node unionNode : node.unionNodes) {
                maxRank = Math.max(maxRank, rowRanks[unionNode.row]);
                maxRank = Math.max(maxRank, colRanks[unionNode.col]);
            }
        }

        // 当前最大的秩加一，并更新到并查集所有节点以及其所在行列的记录数组
        int rank = maxRank + 1;
        node.rank = rowRanks[node.row] = colRanks[node.col] = rank;
        if (node.unionNodes != null) {
            for (Node unionNode : node.unionNodes) {
                unionNode.rank = rowRanks[unionNode.row] = colRanks[unionNode.col] = rank;
            }
        }
    }

    private void unionNodes(List<Node> nodes, int rowNum, int colNum) {
        // 逐行合并
        Node[] line = new Node[colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                line[j] = nodes.get(i * colNum + j);
            }
            this.union(line);
        }

        // 逐列合并
        line = new Node[rowNum];
        for (int j = 0; j < colNum; j++) {
            for (int i = 0; i < rowNum; i++) {
                line[i] = nodes.get(i * colNum + j);
            }
            this.union(line);
        }

        // 聚合并查集所有节点到Leader中
        for (Node node : nodes) {
            if (node != node.parent) {
                Node leader = this.findLeader(node);
                leader.addUnionNode(node);
            }
        }
    }

    private void union(Node[] line) {
        Arrays.sort(line, Comparator.comparingInt(o -> o.value));
        for (int i = 1; i < line.length; i++) {
            Node prev = line[i - 1];
            Node next = line[i];
            if (prev.value == next.value) {
                Node nextLeader = this.findLeader(next);
                Node prevLeader = this.findLeader(prev);
                nextLeader.parent = prevLeader;
            }
        }
    }

    private Node findLeader(Node node) {
        Node leader = node.parent;
        if (leader == leader.parent) {
            return leader;
        } else {
            leader = this.findLeader(leader);
            node.parent = leader;
            return leader;
        }
    }

    private class Node {
        private int row;
        private int col;
        private int value;
        private int rank;
        private Node parent;
        private List<Node> unionNodes;

        Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.parent = this;
        }

        public void addUnionNode(Node node) {
            if (unionNodes == null) {
                unionNodes = new ArrayList<>();
            }
            unionNodes.add(node);
        }
    }
}
