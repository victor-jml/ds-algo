---
title: LeetCode 154. MinArray(Easy)
date: 2020-08-18 15:19:49
tags:
	- Array
category:
	- study
	- Java
---
### 题目

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

### 来源

[LeetCode练习](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

### 示例

**示例 1：**

```
输入：[3,4,5,1,2]
输出：1
```

**示例 2：**

```
输入：[2,2,2,0,1]
输出：0
```



### 解题思路

根据题意我们可以得知在进行数组的旋转之前这是一个**递增数组**并且**可能含有重复数字**.

最容易想到的方法:

#### 1. 暴力法

我们从数组的第一个元素开始进行遍历将前后进行对比,如果`numbers[left]` > `numbers[right]`则已经出现转折(前后分别是两个不同的**可能**递增的数组).此时right就是我们要找的最小的元素下标.返回`numbers[right]`即可.也有可能全部数组都是重复的一个数字,我们在进行遍历结束后都没有找到符合条件的`numbers[left]`>`numbers[right]`我们就直接返回数组的一个数(默认下标为0的数)

#### 2. 二分法

我们在进行传统的二分查找时候,数组必须是要**有序**的,因为此时我们才能对于一个数进行对比后判断要找的数在它的左区间或者右区间.以便减少查找的次数.

而在本题中其实是满足的二分法的(因为在分界处两边都是单调的数组),我们需要找的就是找到这个分界处.

例如示例1中:

​	我们取2个下标`left`,`right`(默认为第一个和最后一个),然后得到中间下标`mid`(`mid = left + (right - left)/2`)---这里有个小细节:我们得到中间的数不是用的(left + right)/2 因为这样当`left`和`right`很大的时候相加会出现溢出. 其实后面除以2 我更愿意改成 >> 1 因为位运算更快.)所以进行一个循环条件是(left < right)

1. 当`number[mid]` >` number[right]`的时候说明`mid`前面是一个递增的,临界处在`mid`的右边,将`left`指针移动到`mid+1`处
2. 当`number[mid]` < `number[right]`的时候说明`mid`右边是一个递增的,临界处在`mid`的左边,所以将`right`指针指向`mid`处即可
3. 当`number[mid]` = `number[right]` 的时候说明数组里面有重复的数字,我们不清楚临界处是在`mid`的左边还是右边,我们需要做的是将`right--`即可.

最后返回`number[right]`

### 代码

#### 1. 暴力法

```java
class Solution {
    public int minArray(int[] numbers) {
        if(numbers.length == 0) return 0;
        int res = 0;
        for(int i = 0; i < numbers.length; i++){
            int left = i;
            int right = left + 1;
            if(right == numbers.length) break;
            if(numbers[left] > numbers[right]){
                res = right;
                break;
            }
        }
        return numbers[res];
    }
}
```



#### 2. 二分法

```java
public static int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        if(numbers[i] < numbers[j] || numbers.length == 1) return numbers[i];
        while (i < j) {
            int mid = i + (j - i)/2;
            if(numbers[mid] <= numbers[j]){
                j = mid;
            }else if(numbers[mid] > numbers[j]){
                i = mid + 1;
            }else {
                j--;
            }
        }
        return numbers[j];
    }
```

