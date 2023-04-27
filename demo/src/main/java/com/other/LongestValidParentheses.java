package com.other;


import java.util.Deque;
import java.util.LinkedList;


/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "(()))))";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }

    /**
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
