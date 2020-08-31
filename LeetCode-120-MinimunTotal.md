---
title: LeetCode 120. MinimunTotal(Medium)
date: 2020-07-26 23:57:59
tags:
	- Array
	- DP
category:
	- study
	- LeetCode
---
### 题目
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

**相邻的结点** 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

### 示例
例如，给定三角形：
```
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
```
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）
### 解题思路
**DP(自底向上)**

DP数组,我们需要开辟`n+1`x`m+1`的大小.此时的`m`和`n`分别为给定List的大小即:
```
int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[n+1][m+1];
```
然后并初始化最下层为0 也就是`dp[n][i]` (`i` : `0-m`) 即:
```
//初始化第n层均为0
        for(int i = 0;i <= n;i++){
            dp[m][i] = 0;
        }
```
因为我们是从顶向上进行求解的.我们在得出dp状态转换方程为:
```
dp[i][j] = min(dp[i+1][j],dp[i+1][j+1]) + nums[i][j]
```
`dp[i][j]` 表示从点 (i, j)(i,j) 到底边的最小路径和

这种解法相比自顶向下的递归有一个好处就是不需要在最后的时候查找最小值而是直接返回dp[0][0]就可以了
### 代码



**DP(自底向上)**
```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[n+1][m+1];
        //初始化第m层均为0
        for(int i = 0;i <= n;i++){
            dp[m][i] = 0;
        }
        for(int i = m-1;i >= 0;i--){
            for(int j = 0;j <= i;j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
```

### 总结
目前只把自己懂的一种解法写出来了,还在研究其他大佬的解法.在后面会更新.