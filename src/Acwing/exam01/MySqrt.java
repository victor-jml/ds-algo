package exam01;

/**
 * @Author: zy
 * @Date: 2020/12/27 22:43
 * @Description:
 */
public class  MySqrt {

    public static void main(String[] args) {
        int x = 4;
        MySqrt demo = new MySqrt();
        System.out.println(demo.mySqrt(x));
    }

    public int mySqrt(int x){
        int l = 0;
        int r = x;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if(mid <= x / mid){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
}
