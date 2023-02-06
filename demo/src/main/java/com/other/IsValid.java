package com.other;


import java.util.Stack;

/// 有效括号
public class IsValid {
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    // 利用栈的信息来做
    public static boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
                if (stack.size() > s.length() / 2) {
                    //优化的地方，都超过一半的是左括号里，肯定就不是一个有效的括号了
                    return false;
                }
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (s.charAt(i) == ')' && stack.pop() != '(') {
                        return false;
                    }
                    if (s.charAt(i) == ']' && stack.pop() != '[') {
                        return false;
                    }
                    if (s.charAt(i) == '}' && stack.pop() != '{') {
                        return false;
                    }
                }

            }
        }
        return stack.isEmpty();
    }
}
