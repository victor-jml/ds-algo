最近面试在刷题,由于很多中小型企业笔试中不会出现算法题,最近的重点先放在`Java`复习以及`MySQL`. `LC`随缘刷

### 题目

给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

[practice online](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)

### 示例

```
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

```

```
输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
```

### 解题思路

我们需要判断每个节点的大小是否等于`val`因此要遍历整个链表,之后我们需要删除指定节点我们需要知道该节点的前继节点`pre`,我们直接从第二个节点循环开始判断(第一个我们先进行判断如果`head.val == val`直接返回`head.next`)

`TimeComplexity`:`O(N)` 因为要进行遍历链表

`SpaceComplexity`:`O(1)`

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head;
        ListNode cur = pre.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                break;
            }
            else{
                pre = pre.next;
                cur = pre.next;
            }
        }
        return head;
    }
}
```

