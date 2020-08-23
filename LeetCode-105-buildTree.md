---
title: LeetCode 105. buildTree(Medium)
date: 2020-08-13 18:15:02
tags:
	- BinaryTree
category:
	- study
	- LeetCode
---
### 题目

该是出自剑指Offer

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

### 在线练习

LeetCode : https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/

牛客网: https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&&tqId=11157&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

### 示例:

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
```

返回的二叉树

```
    3
   / \
  9  20
    /  \
   15   7
```



### 解题思路

根据前序遍历的性质，第一个元素必然就是root，那么下面的工作就是如何确定root的左右子树的范围

根据中序遍历的性质，root元素前面都是root的左子树，后面都是root的右子树.那么我们只要找到中序遍历中root的位置，就可以确定好左右子树的范围

而我们每次就可以通过前序中序之间的关系确定:

- 前序: 根节点--左子树--右子树

- 中序: 左子树--根节点--右子树

  每一次递归的结束条件就是前序序列是否为空或者长度为1.

### 代码

```java
/**
 * @Auther: zy
 * @Date: 2020/8/13 17:05
 * @Description: 重建二叉树(前序和中序数组)
 *
 *
 * 前序遍历序列{1,2,4,7,3,5,6,8} 和 中序遍历序列{4,7,2,1,5,3,8,6}
 *
 */
public class ReConstructBinaryTreeDemo {
    public TreeNode reConstructBinaryTree(int[] pre,int[] in){
        // 判断当前序遍历的数列为空时
        if(pre.length == 0) return null;

        //获取前序遍历的第一个数(因为前序遍历的第一个数一定是根节点的值)
        int rootVal = pre[0];

        //如果数组长度为1,则只存在根节点直接返回
        if(pre.length == 1) return new TreeNode(rootVal);

        TreeNode root = new TreeNode(rootVal);

        //获取根节点在中序遍历中的下标
        int rootIndex = 0;
        for(int i = 0; i < in.length; i++){
            if(rootVal == in[i]){
                rootIndex = i;
                break;
            }
        }

        //只需要将确定的左右子树安到root上即可.递归要注意出口
        //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex+1, pre.length),Arrays.copyOfRange(in,rootIndex+1,in.length));

        return root;
    }
}
```