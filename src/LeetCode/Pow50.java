/**
 * @Author: zy
 * @Date: 2020/11/3 18:34
 * @Description:
 */
public class Pow50 {
    public static void main(String[] args) {
        Pow50 demo = new Pow50();
        System.out.println(demo.myPow(2.00000, 10));
    }

    public double myPow(double x, int n) {
        long l = n;
        return n > 0 ? solution(x,Math.abs(l)) : 1.0/solution(x,Math.abs(-l));
    }

    public double solution(double x,long n){
        if(n == 0){
            return 1.0;
        }
        if(n == 1){
            return x;
        }
        double y = solution(x,n >> 1);
        return n % 2 == 0 ? y * y : y * y * x;
    }

}
