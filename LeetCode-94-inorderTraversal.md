---
title: LeetCode 94. inorderTraversal(Medium)
date: 2020-07-14 21:53:29
tags:
	- BinaryTree
category:
	- study
	- LeetCode
---
### 题目
给定一个二叉树，返回它的 **中序** 遍历
### 示例
```
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
```
**进阶**:递归算法很简单，你可以通过迭代算法完成吗？

### 解题思路
常规思路
1. 递归
2. 迭代

### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    // 1.Recursion
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Recursion(root,res);
        return res;
    }

    public void Recursion(TreeNode cur,List<Integer> res){
        if(cur.left != null) Recursion(cur.left,res);
        res.add(cur.val);
        if(cur.right != null) Recursion(cur.right,res);
    }

    // 2. Iteration
    // public List<Integer> inorderTraversal(TreeNode root){
    //     List<Integer> res = new ArrayList<>();
    //     if(root == null) return res;
    //     Stack<TreeNode> stack = new Stack<>();
    //     while(root != null || !stack.isEmpty()){
    //         if(root != null){
    //             stack.push(root);
    //             root = root.left;
    //         }
    //         else{
    //             root = stack.pop();
    //             res.add(root.val);
    //             root = root.right;
    //         }
    //     }
    //     return res;
    // }

}
```