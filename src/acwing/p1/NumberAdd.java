package acwing.p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author xmly
 * @Date 2020/10/16 9:24 上午
 * @Version 1.0
 * @Description
 **/
public class NumberAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(add(a,b));
    }

    public static String add(String a,String b){
        int La = a.length() - 1;
        int Lb = b.length() - 1;
        int target = 0;
        StringBuilder res = new StringBuilder();
        while (La >= 0 || Lb >= 0){
            target += La >= 0 ? a.charAt(La--) - '0' : 0;
            target += Lb >= 0 ? b.charAt(Lb--) - '0' : 0;
            res.append(target % 10);
            target = target / 10;
        }
        if(target == 1){
            res.append(1);
        }
        return res.reverse().toString();
    }
}
