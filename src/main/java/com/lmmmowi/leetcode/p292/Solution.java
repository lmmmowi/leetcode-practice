package com.lmmmowi.leetcode.p292;

/**
 * @Author: lmmmowi
 * @Date: 2021/9/18
 * @Description: 292. Nim 游戏[https://leetcode-cn.com/problems/nim-game/]
 */
public class Solution {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
