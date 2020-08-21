---
title: LeetCode 240. FindNumberIn2DArray(Easy)(剑指Offer 04)
date: 2020-08-03 19:17:07
tags:
	- Array
category:
	- study
	- LeetCode
---
### 题目:
在一个 `n` * `m`的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


### 示例
现有矩阵 matrix 如下：
```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```
给定 target = `5`，返回 `true`。

给定 target = `20`，返回 `false`。

### 限制
0 <= n <= 1000

0 <= m <= 1000

### 解题思路
我们要从一个二维数组的里面找是否存在某一特定值`target`, 因为该二维数组存在一个规律:

- 每一行从左到右递增的顺序排序
- 每一列从上到下递增的顺序排列

从这个规律中我们可以得出几个结论:
1. 左上角的值是每一行**最小**同时也是每一列**最小**的
2. 右上角的值是每一行**最大**的同时是每一列**最小**的
3. 左下角的值是每一行**最小**同时也是每一列**最大**的
4. 右下角的值是每一行**最大**的同时是每一列**最大**的

我们比较值可以从这四个角度去当作入口进入数组进行比较.但是其中**左上**和**右下**的值都是同为最小或者最大,导致我们进行判定`matrix[i][j]`与`target`大小关系
时. 例如:

`matrix[i][j] > target`
我们就可以判断该target 不在该二维数组中

而当`matrix[i][j] < target`时
就剩下右边和下方以及重叠区域需要进行判断会很复杂

所以我们选择**右上或者左下的值当作入口**进行判断.
当`matrix[i][j] > target` 时,我们就可以排除当前列(因为该值为当前列的最小值).

当`matrix[i][j] < target`时,我们就可以排除当前行(因为该值为当前值的最大值)

这样一来我们每一次进行比较就可以排除一行或者一列直到找到是否存在.

### 代码

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            int[] col = matrix[i];
            for(int j = n-1; j >= 0; j--){
                if(matrix[i][j] == target) return true;
                else if(matrix[i][j] > target) n--;
                else break;
            }
        }
        return false;
    }
}
```