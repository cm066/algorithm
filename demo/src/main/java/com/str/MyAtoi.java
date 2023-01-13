package com.str;

import java.util.HashMap;
import java.util.Map;

public class MyAtoi {
    public static void main(String[] args) {
        System.out.println("  -sss".trim().length());
        System.out.println();
    }

    public int myAtoi2(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
    // 思路一样
    public static int myAtoi1(String s){
        int sign = 1;
        int res = 0;
        int m = s.length();
        int i = 0;
        // 去除最前面的空格
        while(i < m && s.charAt(i)==' '){
            i++;
        }
        int start = i;
        for (; i < m ; i++) {
            char c = s.charAt(i);
            if (i == start && c == '+'){
                sign = 1;
            } else if (i == start && c == '-') {
                sign = -1;
            } else if (Character.isDigit(c)) {
                int num = c-'0';
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }

                if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10&&-num<Integer.MIN_VALUE%10)){
                    return Integer.MIN_VALUE;
                }
                res = res*10+sign*num;
            }else {
                break;
            }
        }
        return res;
    }

    public int myAtoi(String s) {
        String s1 = "100";
        char[] chars = s.trim().toCharArray();
        boolean flag = false, num = false;
        char[] result = new char[s.length()];
        int index = 0;
        if (chars[0] == '-'){
            flag = true;
        }
        for (int i = 1; i < chars.length; i++) {
            if ((chars[i] < '1' || chars[i] > '9') && num){
                break;
            }
            if (chars[i] >= '1' && chars[i] <= '9'){
                result[index++] = chars[i];
                if (!flag){
                    flag = true;
                }
            }
        }

        return 0;
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if (state.equals("in_number")){
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        }else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }

}