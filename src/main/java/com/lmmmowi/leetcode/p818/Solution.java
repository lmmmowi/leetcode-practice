package com.lmmmowi.leetcode.p818;

/**
 * @Author: lmmmowi
 * @Date: 2021/8/10
 * @Description: 818. 赛车[https://leetcode-cn.com/problems/race-car/]
 */
public class Solution {

    public static void main(String[] args) {
        int count = new Solution().racecar(10000);
        System.out.println(count);
    }

    public int racecar(int target) {
        Integer[] dp = new Integer[target + 1];
        dp[0] = 0;
        return racecar(target, dp);
    }

    private int racecar(int target, Integer[] dp) {
        if (dp[target] != null) {
            return dp[target];
        }

        int pos = 0;
        int speed = 1;
        int count = 0;

        while (pos + speed < target) {
            count++;
            pos += speed;
            speed *= 2;
        }

        if (pos + speed == target) {
            count++;
        } else {
            // A+R
            int a = 2 + racecar(pos + speed - target, dp);

            // R+R
            int b = 2 + racecar(target - pos, dp);

            int min = Math.min(a, b);
            int backSpeed = 1;
            int backDistance = 0;
            for (int i = 1; i < count; i++) {
                backDistance += backSpeed;

                // R+A{i}+R
                int temp = i + 2 + racecar(target - (pos - backDistance), dp);
                backSpeed *= 2;
                min = Math.min(min, temp);
            }

            count += min;
        }

        dp[target] = count;
        return count;
    }
}
