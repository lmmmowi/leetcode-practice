package com.lmmmowi.leetcode.scala.p2

/**
  * @Author: mowi
  * @Date: 2019-05-13
  * @Description: 2.两数相加[https://leetcode-cn.com/problems/add-two-numbers/]
  */
object Solution {

    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        var a: ListNode = l1
        var b: ListNode = l2

        var result: ListNode = null
        var c: ListNode = null
        var carry = 0

        while (a != null || b != null || carry > 0) {
            var ax = 0
            var bx = 0

            if (a != null) {
                ax = a.x
                a = a.next
            }

            if (b != null) {
                bx = b.x
                b = b.next
            }

            val sum = ax + bx + carry
            val newNode = new ListNode(sum % 10)
            carry = sum / 10

            if (c == null) {
                c = newNode
                result = c
            }
            else {
                c.next = newNode
                c = newNode
            }
        }

        result
    }

}


class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
}