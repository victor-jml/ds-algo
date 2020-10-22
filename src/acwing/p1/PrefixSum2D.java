package acwing.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author xmly
 * @Date 2020/10/17 11:00 上午
 * @Version 1.0
 * @Description :
 * 1. arr[i][j] 如何计算
 * !!! arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i - 1][j - 1] + arr[i][j]
 * 因为这里在计算i行j列的时候，因为与上一行的该列以及上一列的该行有关，所以就重复计算了上一行i-1与上一列j-1那个数 就需要减去一次 然后加上本身的数arr[i][j]即可
 * 2. arr[x1][y1] arr[x2][y2] 如何计算这一子矩阵的所有数和
 * 这一部分的和sum = arr[x2][y2] - arr[x1][y1] = arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1] （这里多减去了arr[x1 - 1][y1 - 1] 这一部分区域）
 **/
public class PrefixSum2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[col + 1][row + 1];
        for(int i = 1 ; i < arr.length ; i++){
            for(int j = 1; j < arr[0].length ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        prefix2D(arr);
        while (m-- > 0){
            int colS = sc.nextInt();
            int rowS = sc.nextInt();
            int colE = sc.nextInt();
            int rolE = sc.nextInt();
            System.out.println(solution(arr,colS,rowS,colE,rolE));
        }
    }
    public static void prefix2D(int[][] arr){
        for(int i = 1; i < arr.length ; i++){
            for(int j = 1; j < arr[0].length ; j++){
                arr[i][j] = arr[i- 1][j] + arr[i][j - 1] - arr[i-1][j-1] + arr[i][j];
            }
        }
    }
    public static int solution(int[][] arr,int colStart,int rowStart
    ,int colEnd,int rowEnd){
        return arr[colEnd][rowEnd] - arr[colStart - 1][rowEnd] - arr[colEnd][rowStart - 1] + arr[colStart -1][rowStart - 1];
    }
}
