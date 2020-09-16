---
title: LeetCode 26. RemoveDuplicates (Easy)
date: 2020-06-30 10:55:24
tags:
	- Array
category:
	- study
	- LeetCode
---
### 题目
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

**不要使用额外的数组空间**，你必须在 **原地** 修改输入数组 并在使用 `O(1)` 额外空间的条件下完成。

### 在线练习
you can practice online:[LeetCode](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

### 示例
示例一:
```
给定数组 nums = [1,1,2], 

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 

你不需要考虑数组中超出新长度后面的元素。

```

示例二:
```
给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。

```

### 解题思路
`双指针法`
定义慢指针`i`初始化为0 , 快指针`j`初始化为1.
每一次遍历的时候,判断`nums[i]`与`nums[j]`是否相等,如果相等则j++.若不等则先`i++`然后将`nums[j]`赋值给`nums[i]`


**Time complexity** `O(n)`
**Space complexity** `O(1)`
### 代码

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1;j < nums.length;j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
```