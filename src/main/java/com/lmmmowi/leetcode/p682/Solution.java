package com.lmmmowi.leetcode.p682;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2021/8/31
 * @Description: 682. 棒球比赛[https://leetcode-cn.com/problems/baseball-game/]
 */
public class Solution {

    public int calPoints(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        for (String op : ops) {
            int lastIndex = scores.size() - 1;
            int score;
            switch (op) {
                case "+":
                    score = scores.get(lastIndex) + scores.get(lastIndex - 1);
                    scores.add(score);
                    break;
                case "D":
                    score = scores.get(lastIndex) << 1;
                    scores.add(score);
                    break;
                case "C":
                    scores.remove(lastIndex);
                    break;
                default:
                    score = Integer.parseInt(op);
                    scores.add(score);
            }
        }
        return scores.stream().reduce(Integer::sum).get();
    }
}
