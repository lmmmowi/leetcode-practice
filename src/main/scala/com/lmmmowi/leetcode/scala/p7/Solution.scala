package com.lmmmowi.leetcode.scala.p7

/**
  * @Author: mowi
  * @Date: 2019-05-16
  * @Description: 7.整数反转[https://leetcode-cn.com/problems/reverse-integer/]
  */
object Solution {

    def reverse(x: Int): Int = {
        // 32位整数，转换成10进制最多9位
        val arr = new Array[Int](10)

        // 提取符号
        val signalValue = if (x < 0) -1 else 1

        // 把各个位上的数字提取到数组里
        var n = 1
        arr(0) = abs(x % 10)
        var y = abs(x / 10)
        while (y > 0) {
            arr(n) = y % 10
            y /= 10
            n += 1
        }

        // 数组反向依次累加
        var res = 0
        var multiplier = 1
        while (n > 0) {
            n -= 1

            val toAdd = arr(n) * multiplier

            // 如果当前累加位溢出则返回0
            if (toAdd / multiplier != arr(n)) {
                return 0
            }

            if (signalValue < 0) res -= toAdd else res += toAdd
            multiplier *= 10
        }

        // 如果累加结果与输入数值符号相同，则返回累加值，否则越界
        if (signalValue * res > 0) res else 0
    }

    def abs(i: Int): Int = {
        if (i > 0) i else -i
    }
}
