package acwing.p1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author xmly
 * @Date 2020/10/18 9:50 上午
 * @Version 1.0
 * @Description
 **/
public class DifferenceArray {
    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
    //数据规模
    static int N = 100010;
    static int[] arr = new int[N];
    static int[] diff = new int[N];
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        for(int i = 1; i <= m ; i++){
            arr[i] = sc.nextInt();
            add(i,i,arr[i]);
        }
        while (n-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x= sc.nextInt();
            add(l,r,x);
        }
        prefix(m);
        print(m);
        log.flush();
        log.close();
    }

    public static void print(int m) throws IOException {
        for(int i = 1 ; i <= m ; i++){
            log.write(arr[i] + " ");
        }
    }

    public static void prefix(int m){
        for(int i = 1; i <= m ; i++){
            arr[i] = arr[i - 1] + diff[i];
        }
    }

    public static void add(int l,int r,int c){
        diff[l] += c;
        diff[r + 1] -= c;
    }
}
