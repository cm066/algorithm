package com.str;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    // 双指针的写法
    public static int lengthOfLongestSubstring1(String s) {
        HashSet<Character> occ = new HashSet<>();
        int rk = -1, ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0){
                // 这一步的操作是做什么用的？
                occ.remove(s.charAt(i-1));
            }
            while (rk + 1 < n  && !occ.contains(s.charAt(rk +1))){
                occ.add(s.charAt(++rk));
            }
            ans = Math.max(ans, rk - i +1);
        }
        return ans;
    }
    public static int lengthOfLongestSubstring(String s) {
        int max =0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (str.indexOf(s.charAt(j)) != -1){
                    break;
                }
                str += s.charAt(j);
            }
            max = Math.max(max,str.length());
            str = "";
        }
        return max;
    }
}
