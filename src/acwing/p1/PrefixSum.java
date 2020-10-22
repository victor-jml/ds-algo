package acwing.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author xmly
 * @Date 2020/10/17 10:26 上午
 * @Version 1.0
 * @Description
 **/
public class PrefixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[m + 1];
        for(int i = 1; i < m + 1; i++){
            arr[i] = sc.nextInt();
        }
        prefix(arr);
        while (n-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(solution(arr,l,r));
        }
    }

    public static void prefix(int[] arr){
        for(int i = 1; i < arr.length ; i++){
            arr[i] = arr[i - 1] + arr[i];
        }
    }

    public static int solution(int[] arr,int l,int r){
        return arr[r] - arr[l-1];
    }
}
