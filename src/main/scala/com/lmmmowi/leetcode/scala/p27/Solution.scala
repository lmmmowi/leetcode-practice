package com.lmmmowi.leetcode.scala.p27

/**
  * @Author: mowi
  * @Date: 2019-06-01
  * @Description: 27.移除元素[https://leetcode-cn.com/problems/remove-element/]
  */
object Solution {

    def removeElement(nums: Array[Int], `val`: Int): Int = {
        var n = 0
        for (i <- nums.indices) {
            if (nums(i) != `val`) {
                nums(n) = nums(i)
                n += 1
            }
        }
        n
    }
}
