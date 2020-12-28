import java.util.Arrays;

/**
 * @Author: zy
 * @Date: 2020/12/28 20:01
 * @Description:
 */
public class SearchRange34 {

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        int target = 8;
        SearchRange34 demo = new SearchRange34();
        System.out.println(Arrays.toString(demo.searchRange(arr,target)));
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 ){
            return new int[]{-1,-1};
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if(nums[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if(nums[l] != target){
            return new int[]{-1,-1};
        }
        int start = l;
        l = 0;
        r = nums.length - 1;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if(nums[mid] <= target){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        int end = r;
        return new int[]{start,end};
    }
}
