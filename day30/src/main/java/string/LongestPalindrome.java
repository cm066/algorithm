package string;

/**
 * @author cm
 * @create 2021/12/22-10:40 下午
 * 最长的回文字符串
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babab";
        String dp = dp(s);
        System.out.println(dp);
//        String s1 = longestPalindrome(s);
//        System.out.println(s1);
    }

    public static String dp1(String s){
        if (s == null){
            return s;
        }
        int n = s.length();
        if(n < 2){
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        //自己跟自己肯定是相等的，填充对角线
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int max = 1,start = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n-1 && i < j; i++) {
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j -i +1 > max){
                    start = i;
                    max = j-i+1;
                }
            }
        }
        return s.substring(start,start+max);
    }
    public static String dp(String s){
      int len = s.length();
      if (len < 2){
          return s;
      }
      int maxLen=1;
      int begin = 0;
      boolean[][] dp = new boolean[len][len];
      //对角线都是为true表示自己和自己肯定是相等的啊
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                //由l和i来确定右边界
                int j  = L + i -1;
                if (j >= len){
                    break;
                }
                if (charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if (j-i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
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
