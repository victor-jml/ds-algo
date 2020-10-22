package acwing.p1;

import java.util.Scanner;

/**
 * @Author xmly
 * @Date 2020/10/14 1:25 下午
 * @Version 1.0
 * @Description
 **/
public class NumberRange789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        while(n-- > 0){
            System.out.println("case n------------");
            int x = sc.nextInt();
            bSearch(arr, 0, arr.length - 1, x);
        }

    }
    public static void bSearch(int[] arr,int l ,int r ,int x){
        while(l < r){
            int mid = l + r >> 1;
            if(arr[mid] >= x){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if(arr[l] != x){
            System.out.print("-1 -1");
        }else{
            System.out.print(l + " ");
            l = 0;
            r = arr.length - 1;
            while(l < r){
                int mid = l + r + 1 >> 1;
                if(arr[mid] <= x){
                    l = mid;
                }else{
                    r = mid - 1;
                }
            }
            System.out.println(r);
        }

    }
}
