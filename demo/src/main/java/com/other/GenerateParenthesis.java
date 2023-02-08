package com.other;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }

    // 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    //示例 1：
    //
    //输入：n = 3
    //输出：["((()))","(()())","(())()","()(())","()()()"]
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            result.add("()");
            return result;
        }
        helper(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    // //输入：n = 3
    //    //输出：["((()))","(()())","(())()","()(())","()()()"]
    private static void helper(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max*2){
            ans.add(cur.toString());
            return;
        }
        if (open < max){
            cur.append('(');
            helper(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length()-1);
        }
        if (close < open){
            cur.append(')');
            helper(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
