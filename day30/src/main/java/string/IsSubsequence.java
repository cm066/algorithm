package string;

/**
 * @author cm
 * @create 2022/3/25-10:13 下午
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "ahbgdc";
        String t = "abc";
        System.out.println(isSubsequence1(s, t));
    }
    //先采用暴力递归的方式来解决
    public static boolean isSubsequence1(String s, String t) {
        char[]  s1= s.toCharArray();
        char[] t1 = t.toCharArray();
        int i=0,j=0;
        while (i < s1.length && j < t1.length){
            if (s1[i] == t1[j]){
                i++;
                j++;
            }else {
                i++;
            }
            if (j == t1.length){
                return true;
            }
        }
        return false;
    }
}
