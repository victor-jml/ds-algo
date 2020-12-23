/**
 * @Author: zy
 * @Date: 2020/12/23 08:19
 * @Description:
 */
public class isUnique01 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(isUnique(s));
    }

    public static boolean isUnique(String astr) {
        if(astr.length() == 0){
            return true;
        }
        for(int i = 0 ; i < astr.length(); i++){
            char c = astr.charAt(i);
            for(int j = i + 1; j < astr.length() ; j++){
                if(c == astr.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
