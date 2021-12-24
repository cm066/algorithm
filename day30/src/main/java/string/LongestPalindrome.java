package string;

/**
 * @author cm
 * @create 2021/12/22-10:40 下午
 * 最长的回文字符串
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "bb";
        String s1 = longestPalindrome(s);
//        System.out.println(s1);
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    /**
     * 解题思路一，以每个字符为中心向两边扩展
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        char[] chars = s.toCharArray();
        String result = "";
        for (int i = 1; i < chars.length; i++) {
            String back = isBack(chars, i);
            if (back != null && back.length() > result.length()){
                result = back;
            }
        }
        return result;
    }

    /**
     *
     * @param chars 原始的字符数组
     * @param i 表示当前位置
     * @return
     */
    public static String isBack(char[] chars ,int i){
        String result = null;
        int left = i-1;
        int right = i+1;
        while (left >=0 && right <chars.length){
            if (chars[left] == chars[right]){
                result = String.valueOf(chars[left]+chars[i]+chars[right]);
                left--;
                right++;
            }
            break;
        }
        return result;
    }
}
