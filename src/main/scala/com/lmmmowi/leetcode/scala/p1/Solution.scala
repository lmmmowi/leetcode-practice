package com.lmmmowi.leetcode.scala.p1

import scala.collection.mutable

/**
  * @Author: mowi
  * @Date: 2019-05-11
  * @Description:
  */
object Solution {

    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val map = new mutable.HashMap[Int, Int]()

        for (i <- nums.indices) {
            val foundIndex = map.get(target - nums(i))
            if (foundIndex.isDefined) {
                return Array(i, foundIndex.get)
            }
            else {
                map.put(nums(i), i)
            }
        }

        null
    }
}
