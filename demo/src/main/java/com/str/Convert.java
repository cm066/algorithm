package com.str;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        String convert = convert(str, 4);
        System.out.println(convert.equals("PINALSIGYAHRPI"));
    }

    public static String convert1(String s, int numRows) {
        if (s == null || numRows < 2){
            return s;
        }
        List<StringBuilder> set = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            set.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            set.get(i).append(c);
            // 这个是处理第一行和最后一行的，flag是关键点
            if(i == 0 || i == numRows -1){
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : set) {
            stringBuilder.append(builder);
        }
        return stringBuilder.toString();
    }
    /**
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * "PINALSIGYAHRPI"
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1){
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int a = 0;
            if (i % 2 == 0){
                a = numRows+1;
            }else {
                a = numRows-1;
            }
            // "PAYPALISHIRING"
            for (int j = i; j < s.length(); j = j +a +1) {
                System.out.println(j);
                stringBuilder.append(s.charAt(j));
            }
        }
        return stringBuilder.toString();
    }
}
