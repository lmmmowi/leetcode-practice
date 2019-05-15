package com.lmmmowi.leetcode.p146;

import java.util.*;

/**
 * @Author: mowi
 * @Date: 2019-05-15
 * @Description:
 */
public class LRUCache {

    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity * 2);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;
            insertNewNode(node);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void insertNewNode(Node node) {
        if (map.size() >= capacity) {
            map.remove(tail.key);
            tail = tail.prev;
        }

        if (head != null) {
            head.prev = node;
        }
        node.next = head;
        head = node;

        if (tail == null) {
            tail = node;
        }

        map.put(node.key, node);
    }

    private void moveToHead(Node node) {
        if (node == head) {
            return;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == tail && node.prev != null) {
            tail = node.prev;
        }

        head.prev = node;
        node.next = head;
        head = node;
    }

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
}
