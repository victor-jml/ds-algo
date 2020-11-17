import java.util.Arrays;

/**
 * @Author: zy
 * @Date: 2020/11/17 23:53
 * @Description:
 */
public class RemoveCoveredIntervals1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for(int i = 1; i < intervals.length ; i++){
            if(intervals[i][0] >= left && intervals[i][1] <= right){
                res++;
            }
            if(right >= intervals[i][0] && intervals[i][1] >= right){
                right = intervals[i][1];
            }
            if(intervals[i][0] > right){
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}
