package com.str;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "baabc";
        String s1 = longestPalindromeDP(s);
        System.out.println(s1);
    }

    // 动态规划来实现
    public static String longestPalindromeDP(String s) {
        if (s == null){
            return null;
        }
        int len = s.length();
        if (len < 2){
            return s;
        }
        int maxLen=1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        //对角线都是为true表示自己和自己肯定是相等的啊
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                // 由l和i来确定右边界为什么要通过这一步来确定右边界
                int j  = L + i -1;
                if (j >= len){
                    break;
                }
                if (charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else {
                    // 为什么是j-i < 3? 这个就相当于是当字符串长度小于等于3的时候只要当前两个是相等的就一定是回文串
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        // dp[i][j] 表示 s[i..j] 是否是回文串  表示i+1到j-1这个也是回文串
                        // 这个就先判断2个时候，然后判断3个是不是，然后在判断长度为5的时候是不是
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

    // 采用中心往外扩的办法
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = expandAroundCenter(s,i,i);
            //处理长度为偶数的情况
            int l2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(l1, l2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end+1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >=0 && right < s.length()&& s.charAt(left)== s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
