---
title: LeetCode 206. ReverseList (Medium)
date: 2020-07-14 21:40:48
tags:
	- LinkedList
category:
	- study
	- LeetCode
---
### 题目
反转一个单链表。
### 示例
示例:
```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

```

### 解题思路
**迭代法** `+` **双指针**

在循环中需要做的事是要将当前节点指向前一个节点,所以就需要定义两个指针`cur` `pre`分别表示当前节点和前继节点.
与此同时我们还需要在循环中用一个next来保存cur的后继节点避免出现节点丢失

**Time complexity** `O(n)`
**Space complexity** `O(1)`

**递归法**

递归反转链表相比迭代是有一定的难度的
我们需要明确这个函数的作用是什么:
`参数为头指针,反转链表后返回翻转后的链表`

最难理解的是比如:
4和5需要反转, 4->5 此时的cur是4,需要将`cur.next.next = cur` 将5的next指向4

图下是我在LeetCode讨论区找到一个gif方便理解:
![](https://pic.leetcode-cn.com/dacd1bf55dec5c8b38d0904f26e472e2024fc8bee4ea46e3aa676f340ba1eb9d-%E9%80%92%E5%BD%92.gif)

**Time complexity** `O(n)`
**Space complexity** `O(n)`

### 代码
**迭代法** `+` **双指针**

```java
class Solution {
    public static ListNode reverseListIterate(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
```
**递归法**

```java
class Solution {
   public static ListNode reverseListRecursion(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode temp = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
```


### 总结
反转链表这个题最主要的还是递归方法的难以理解, 这也是递归经典题.在以后还是需要多加练习多总结才能帮助理解.

后面还要`反转链表前n项` 以及 `反转链表部分项` 等类似的题就更新到下一篇文章