---
title: LeetCode 283. Move Zeroes (Easy)
date: 2020-06-26 20:53:51
tags:
	- Array
category:
	- study
	- LeetCode
---
### 题目:
给定一个数组 `nums`，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

###  示例:
```
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
```

### 说明:
1. 必须在原数组上操作，不能拷贝额外的数组。
2. 尽量减少操作次数。

### 解题思路
遍历`nums`的同时判断`nums.at(i)`是否为`0`,如果是那么就删除这个值然后在数组的末尾`push_back`0进去
(tips:每进行删除然后`push_back`后不要将遍历变量`i++`,例如数组中`0-0-1`,第一项删除`0`后,变化后的`nums为'0-1-0'`,也就是第二次遍历后会判断为`1`而不是`0`,所以遍历变量不需要进行自增.而如果不为`0`,则进行`i++`)


### 代码

```cpp
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int n = nums.size();
        for(int i=0;i<n;){
            if(nums.at(i)==0){
                nums.erase(nums.begin()+i);
                nums.push_back(0);
                n--;
            }else i++;
        }
        for(int i=0;i<nums.size();i++){
            cout << nums.at(i) ;
        }
    }
};
```

```java
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int n = nums.size();
        for(int i=0;i<n;){
            if(nums.at(i)==0){
                nums.erase(nums.begin()+i);
                nums.push_back(0);
                n--;
            }else i++;
        }
        for(int i=0;i<nums.size();i++){
            cout << nums.at(i) ;
        }
    }
};
```
