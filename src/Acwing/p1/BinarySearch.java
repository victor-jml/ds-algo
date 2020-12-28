package p1;

import java.util.Arrays;

/**
 * @Author: zy
 * @Date: 2020/12/24 19:55
 * @Description:
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,2,3,};
        int target = 2;
        System.out.println(Arrays.toString(findLeft(arr,target)));
    }

    public static int[] findLeft(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if(arr[mid] >= target){
                right = mid ;
            }else {
                left = mid + 1;
            }
        }
        int start = left;
        left = 0;
        right = arr.length - 1;
        while (left < right){
            int mid = (left + right + 1) / 2;
            if(arr[mid] <= target){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        int end = left;
        return new int[]{start,end};
    }

}
