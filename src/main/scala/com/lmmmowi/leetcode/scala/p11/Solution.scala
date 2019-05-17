package com.lmmmowi.leetcode.scala.p11

/**
  * @Author: mowi
  * @Date: 2019-05-17
  * @Description: 11.盛最多水的容器[https://leetcode-cn.com/problems/container-with-most-water/]
  */
object Solution {

    def main(args: Array[String]): Unit = {
        val a = Solution.maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7))
        println(a)
    }

    def maxArea(height: Array[Int]): Int = {
        var l = 0
        var r = height.length - 1
        var max = 0

        while (l < r) {
            val lh = height(l)
            val rh = height(r)
            val h = if (lh < rh) lh else rh
            val w = r - l
            val area = h * w
            if (area > max) {
                max = area
            }

            if (h == lh) {
                l += 1
            }
            else {
                r -= 1
            }
        }

        max
    }

}
