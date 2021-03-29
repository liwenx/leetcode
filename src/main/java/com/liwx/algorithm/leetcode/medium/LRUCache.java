package com.liwx.algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author liwenxing
 * @date 2021/3/24 下午9:58
 */
public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {
        }
        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    /**
     * map
     */
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    /**
     * 实际大小
     */
    int size;
    /**
     * 容量
     */
    int capacity;
    /**
     * 链表头尾
     */
    DLinkedNode head, tail;

    public LRUCache(int capacity) {
        // TODO: 2021/3/24
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 获取元素
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //如果key存在，先通过hash表定位，再修改value，并移到头部
        moveToHead(node);
        return node.value;
    }

    /**
     * 添加元素
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //如果key不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加进hash表
            cache.put(key, newNode);
            //添加进双向链表的头部
            addToHead(node);
            ++size;
            if (size > capacity) {
                //如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                //删除hash表对应的元素
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
