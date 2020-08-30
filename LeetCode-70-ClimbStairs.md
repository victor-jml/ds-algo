---
title: LeetCode 70. ClimbStairs(Easy)
date: 2020-07-25 23:59:36
tags:
	- Array
	- DP
category:
	- study
	- LeetCode
---
### 题目
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

### 在线练习
LeetCode: https://leetcode-cn.com/problems/climbing-stairs/
### 示例
示例1:
```
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
```
示例2:
```
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
```

### 解题思路
**递归法**

很明显当`n<=2`的时候即爬到第一层第二层有几种方法均为n种,所以我们在最开始进行判断
```
if(n <= 2) return n;
```
如果`n>2`的话,在爬到n层楼梯需要的方法数是爬到n-1层的方法数`+`爬到n-2层需要的方法数.即:
```
int res = climbStairs(n-1)+climbStairs(n-2);
```

但是这道题用递归是TLE了.所以我们需要进行优化.

**递归法** `+` **备忘录算法**

因为我们在递归的时候总是会重复计算值,试想当这个`n`很大的时候重复计算的次数会不断增加.所以我们在进行递归的时候需要进行保存计算过的值(可以用HashMap,HashSet或者数组等等).

这里我们开一个数组,数组的长度为`n+1`,在每次递归的时候对`num[n]`的值进行判断
```
if(nums[n] > 0)
```
如果`nums[n]`的值大于0则返回`nums[n]`否则进行递归求值赋给`nums[n]`然后再返回`nums[n]`


**动态规划**

动态规划就是将一个问题划分成多个子问题.爬第n阶楼梯的方法数量等于 2 部分之和:
1. 爬上 `n-1` 阶楼梯的方法数量.因为再爬1阶就能到第n阶
2. 爬上 `n-2` 阶楼梯的方法数量,因为再爬2阶就能到第n阶
公式`nums[n] = nums[n-1] + nums[n-2]` (n > 2)


### 代码
**递归法**

```java
class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }
}
```
**递归法** `+` **备忘录算法**

```java
class Solution {
    public int climbStairs(int n) {
        int[] nums = new int[n+1];
        return calculate(n,nums);
    }
    
    public int calculate(int n,int[] nums){
        if(n <= 2) return n;
        if(nums[n] > 0){
            return nums[n];
        }
            nums[n] = calculate(n-1,nums) + calculate(n-2,nums);
            return nums[n];
        
    }
}
```

**动态规划**
```java
class Solution {
    public int climbStairs(int n) {
        int[] nums = new int[n+1];
        if(n <= 2) return n;
        return calculate(n,nums);
    }
    
    public int calculate(int n,int[] nums){
        nums[1] = 1;
        nums[2] = 2;
        for(int i = 3;i < nums.length;i++){
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
    }
}
```

### 总结
这道题在LeetCode上是属于Easy难度的,也是练习DP的第一道题