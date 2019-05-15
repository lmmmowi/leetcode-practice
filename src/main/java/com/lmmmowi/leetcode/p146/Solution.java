package com.lmmmowi.leetcode.p146;

/**
 * @Author: mowi
 * @Date: 2019-05-15
 * @Description: 146.LRU缓存机制[https://leetcode-cn.com/problems/lru-cache/]
 */
public class Solution {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));
        lruCache.put(3, 2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }
}
