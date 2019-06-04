package com.lmmmowi.leetcode.scala.p34

/**
  * @Author: mowi
  * @Date: 2019-06-04
  * @Description: 34.在排序数组中查找元素的第一个和最后一个位置[https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/]
  */
object Solution {

    def searchRange(nums: Array[Int], target: Int): Array[Int] = {
        val left = search(nums, target, 0, nums.length - 1, true)
        val right = if (left == -1) -1 else search(nums, target, 0, nums.length - 1, false)
        Array[Int](left, right)
    }

    def search(nums: Array[Int], target: Int, start: Int, end: Int, findLeft: Boolean): Int = {
        if (start > end) {
            return -1
        }

        val mid = (start + end) / 2
        if (nums(mid) == target) {
            if (findLeft) {
                if (mid - 1 >= 0 && nums(mid - 1) == target) {
                    return search(nums, target, start, mid - 1, findLeft)
                }
                else {
                    return mid
                }
            }
            else {
                if (mid + 1 < nums.length && nums(mid + 1) == target) {
                    return search(nums, target, mid + 1, end, findLeft)
                }
                else {
                    return mid
                }
            }
        }
        else if (nums(mid) > target) {
            return search(nums, target, start, mid - 1, findLeft)
        }
        else {
            return search(nums, target, mid + 1, end, findLeft)
        }
    }

}
