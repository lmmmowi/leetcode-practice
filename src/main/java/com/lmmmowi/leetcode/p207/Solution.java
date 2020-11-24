package com.lmmmowi.leetcode.p207;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: lmmmowi
 * @Date: 2020/11/24
 * @Description: 207.课程表[https://leetcode-cn.com/problems/course-schedule/]
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = this.prepareEdges(numCourses, prerequisites);

        Set<Integer> finishedCourses = new HashSet<>();
        Set<Integer> loopMarks = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!this.canFinish(i, edges, finishedCourses, loopMarks)) {
                return false;
            }
        }

        return true;
    }

    private boolean canFinish(int course, List<List<Integer>> edges, Set<Integer> finishedCourses, Set<Integer> loopMarks) {
        if (finishedCourses.contains(course)) {
            return true;
        }

        if (loopMarks.contains(course)) {
            return false;
        }

        List<Integer> prerequisites = edges.get(course);
        if (prerequisites != null) {
            loopMarks.add(course);

            for (Integer prerequisite : prerequisites) {
                if (!this.canFinish(prerequisite, edges, finishedCourses, loopMarks)) {
                    return false;
                }
            }

            loopMarks.remove(course);
        }

        finishedCourses.add(course);
        return true;
    }

    private List<List<Integer>> prepareEdges(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            List<Integer> list = edges.get(a);
            list.add(b);
        }

        return edges;
    }
}
