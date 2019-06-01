package com.lmmmowi.leetcode.scala.p28

/**
  * @Author: mowi
  * @Date: 2019-06-01
  * @Description: 28.实现strStr()[https://leetcode-cn.com/problems/implement-strstr/]
  */
object Solution {

    def strStr(haystack: String, needle: String): Int = {
        if (haystack.length >= needle.length) {
            if (haystack.length == 0) {
                return 0
            }

            for (i <- haystack.indices.dropRight(needle.length - 1)) {
                var m = true
                for (j <- needle.indices) {
                    if (m && haystack.charAt(i + j) != needle.charAt(j)) {
                        m = false
                    }
                }
                if (m) {
                    return i
                }
            }
        }

        -1
    }
}
