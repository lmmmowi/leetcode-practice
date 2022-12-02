package com.lmmmowi.leetcode.p826;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: lmmmowi
 * @Date: 2022/12/2
 * @Description: 826. 安排工作以达到最大收益[https://leetcode.cn/problems/most-profit-assigning-work/]
 */
public class Solution {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Job[] jobs = new Job[difficulty.length];
        for (int i=0; i<jobs.length; i++){
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job->job.d));
        Arrays.sort(worker);

        int result = 0;
        int i = 0;
        int maxProfit = 0;
        for (int w : worker) {
            for (; i<jobs.length; i++){
                if (jobs[i].d > w){
                    break;
                }
                maxProfit = Math.max(maxProfit, jobs[i].p);
            }
            result += maxProfit;
        }
        return result;
    }

    private static class Job {
        private final int d;
        private final int p;

        public Job(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }
}
