import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zy
 * @Date: 2020/11/7 21:31
 * @Description:
 */
public class SolveNQueens {
    private List<List<String>> res;
    private int[][] used;
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return res;
        used = new int[n][n];
        res = new ArrayList<>();
        DFS(0);
        return res;
    }

    public void DFS(int index){
        if(index == used.length){
            List<String> temp = new ArrayList<>();
            for(int i = 0 ; i < used.length ; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0 ; j < used.length ; j++){
                    if(used[i][j] == 0){
                        sb.append(".");
                    }else{
                        sb.append("Q");
                    }
                }
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }
        for(int i = 0 ; i < used.length ; i++){
            if(validUsed(i,index)){
                used[i][index] = 1;
                DFS(index + 1);
                used[i][index] = 0;
            }
        }
    }

    public boolean validUsed(int x,int y){
        // 当前行是否可以放置(只考虑y左边的部分,因为我们是每一列来进行放置的,右边的肯定为0)
        for(int i = 0 ; i < y ; i++){
            if(used[x][i] == 1){
                return false;
            }
        }
        int x1 = x;
        int y1 = y;
        // 对角线是否可以放置,也只是考虑y左边的部分,道理同上
        while(x1 > 0 && y1 > 0){
            if(used[--x1][--y1] == 1){
                return false;
            }
        }
        x1 = x;
        y1 = y;
        while(x1 < used.length && y1 >= 0){
            if(used[x1++][y1--] == 1){
                return false;
            }
        }
        return true;
    }
}
