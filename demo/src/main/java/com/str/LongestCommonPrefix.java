package com.str;

import java.io.BufferedReader;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        String s = longestCommonPrefix1(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix1(String[] strs) {

        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        String res = "";
        StringBuilder builder = new StringBuilder();
        int index = 0;
        int minLen = getMinLen(strs);
        while (index < minLen){
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) != c){
                    if (builder.length() > res.length()){
                        res = builder.toString();
                    }
                    return res;
                }
            }
            builder.append(c);
            index++;
            if (index == minLen && res.length() == 0){
                return builder.toString();
            }
        }
        return res;
    }

    public static int getMinLen(String[] strs){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min,strs[i].length());
        }
        return min;
    }
}
