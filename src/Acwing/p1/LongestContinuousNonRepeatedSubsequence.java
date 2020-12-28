package p1;

/**
 * @Author: zy
 * @Date: 2020/12/25 08:31
 * @Description:
 */
public class LongestContinuousNonRepeatedSubsequence {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,5};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int res = 0;
        for(int i = 0,j = 0 ; j < arr.length ; j++){
            while (i < j && arr[i] != arr[j]){
                i++;
            }
            res = Math.max(res,j - i + 1);
        }
        return res;
    }
}
