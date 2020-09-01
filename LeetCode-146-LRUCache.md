---
title: LeetCode 146. LRUCache(Medium)
date: 2020-09-01 17:30:27
tags:
	- LinkedList
category:
	- study
	- LeetCode
---
### 题目



运用你所掌握的数据结构，设计和实现一个 [LRU (最近最少使用) 缓存机制](https://baike.baidu.com/item/LRU)。它应该支持以下操作： 获取数据 `get` 和 写入数据 `put` 。

获取数据 `get(key)` - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
写入数据 `put(key, value)` - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

### 练习地址

[LeetCode](https://leetcode-cn.com/problems/lru-cache/)

### 示例

```
LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得关键字 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得关键字 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
```

### 解题思路

所谓`LRU` 即 `最近最少使用`.我们需要的就是完成两个操作(`get()`以及`put()`).  这里我们采用**HashMap**和**双向链表**进行实现

在`get()`操作中:

​	我们每一次进行`get()`操作,需要进行判断该元素是否存在,若不存在即返回`-1`. 若存在我们需要返回该值 **并且我们需要将该值放置首位**代表最近使用.

在`put()`操作中:

​	根据不同的情况我们有三种不同的操作:

- 当前元素不存在,即正常插入
- 当前元素存在,我们需要对元素进行删除并且将该元素插入首位
- 容量满,我们需要删除最末尾的元素然后添加元素

### 代码

`Node.java`

```java
package LeetCode.LRU;

/**
 * @Auther: zy
 * @Date: 2020/9/1 14:48
 * @Description:
 */
public class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v){
        this.key = k;
        this.val = v;
    }
}

```



`LRUCache.java`

```java
package LeetCode.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zy
 * @Date: 2020/9/1 14:48
 * @Description:
 */
public class LRUCache {

    //容量
    private int capacity;

    Map<Integer,Node> map;

    Node head = new Node(0,0);

    Node tail = new Node(0,0);

    public LRUCache(int cap) {
        this.capacity = cap;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 思路(先该存储后改映射关系)
     * <p>
     * 1. 未存在
     * 2. 已存在
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //获取值
        int res = map.get(key).val;
        put(key, res);
        return res;
    }


    /**
     * 1. 判断是否存在,若存在先找到该元素(通过hash映射找到对应位置然后在链表中进行删除),然后再头插法添加节点, 最后再添加映射关系
     * 2. 若是容量已满,先对链表的最后一个元素进行删除(返回该删除的节点),通过返回的节点进行删除map中的映射关系
     *
     * @param key
     * @param val
     */
    public void put(int key, int val) {
        Node node = new Node(key, val);

        // 已存在key
        if (map.containsKey(key)) {
            // 找到该元素并删除
            remove(map.get(key));
            // 头插法添加节点
            addFirst(node);
            // 添加映射关系
            map.put(key, node);
        } else {
            // 未存在但容量满
            if (capacity == map.size()) {
                // 删除最后一个节点,并且返回该节点
                Node last = removeLast();
                // 删除map映射关系
                map.remove(last.key);
            }
            // 正常添加
            addFirst(node);
            map.put(key, node);
        }
    }

    public void addFirst(Node node){
        Node next = head.next;
        node.next = next;
        node.prev = head;
        head.next = node;
        next.prev = node;
    }

    public Node removeLast(){
        Node last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        return last;
    }

    public void remove(Node node){
        Node next = node.next;
        node.prev.next = next;
        next.prev = node.prev;
    }
}

```

