/**
 * @Author: zy
 * @Date: 2020/12/17 08:18
 * @Description: 剑指 Offer 29. 顺时针打印矩阵
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        SpiralOrder demo = new SpiralOrder();
        demo.spiralOrder(arr);
    }

    public void spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int start = 0;
        int col = matrix.length - 1;
        int row = matrix[0].length - 1;
        while (col > start * 2 && row > start * 2){
            print(matrix,col,row,start);
            start++;
        }
    }

    private void print(int[][] arr,int col,int row,int start){
        int ncol = col - start;
        int nrow = row - start;
        for(int i = start; i <= nrow ; i++){
            System.out.print(arr[start][i] + " ");
        }
        for(int i = start + 1 ; i <= ncol; i++){
            System.out.print(arr[nrow][i] + " ");
        }
        for(int i = nrow - 1 ; i >= start ; i--){
            System.out.print(arr[i][nrow] + " ");
        }
        for(int i = ncol - 1 ; i >= start ; i--){
            System.out.print(arr[i][start] + " ");
        }
    }
}
