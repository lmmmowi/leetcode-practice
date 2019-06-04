package com.lmmmowi.leetcode.scala.p35

/**
  * @Author: mowi
  * @Date: 2019-06-04
  * @Description: 35.搜索插入位置[https://leetcode-cn.com/problems/search-insert-position/]
  */
object Solution {

    def searchInsert(nums: Array[Int], target: Int): Int = {
        for (i <- nums.indices) {
            if (nums(i) >= target) {
                return i
            }
        }

        nums.length
    }
}
