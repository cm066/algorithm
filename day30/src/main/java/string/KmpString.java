package string;

import java.util.Arrays;

/**
 * @author cm
 * @create 2022/3/25-10:18 下午
 */
public class KmpString {
    public static void main(String[] args) {
        String str1 = "BBCABCDABABCDABCDABDE";
        String dest = "ABCDABD";
        int[] next = kmpNext(dest);
        System.out.println(Arrays.toString(next));
        int i = kmpString(str1, dest, next);
        System.out.println(i);
    }

    public static int kmpString(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && (str1.charAt(i) != str2.charAt(j))) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && (dest.charAt(i) != dest.charAt(j))) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    /**
     * String str1 = "BBCABCDABABCDABCDABDE";
     *         String dest = "ABCDABD";
     *         暴力递归
     * @param str1
     * @param str2
     * @return
     */
    public static int matchString(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int len1 = s1.length;
        int len2 = s2.length;
        int index1 = 0,index2 = 0;
        while (index1 < len1 && index2 < len2){
            if (s1[index1] == s2[index2]){
                index1++;
                index2++;
            }else {
                index1 = index1 - index2+1;
                index2 = 0;
            }
        }
        if (index2 == len2){
            return index1 -index2;
        }else {
            return -1;
        }
    }
}
