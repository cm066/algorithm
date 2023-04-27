package dp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author cm
 * @create 2022/1/14-11:16 下午
 * 32. 最长有效括号 困难
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = ")()())";
        String s1 = "(()";
        String s3 = "()()()";
        int i1 = longestValidParentheses1(s3);
        System.out.println(i1);
        int i = longestValidParentheses(s1);
        System.out.println(i);

        String s4 = "(())";
        int i2 = longestValidParenthesesDouble(s4);
        System.out.println(i2);
        int i3 = longestValidParentheses1(s4);
        System.out.println(i3);
    }

    /**
     * 双指针思想
     * @param s
     * @return
     */
    public static int longestValidParenthesesDouble(String s) {
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, right * 2);
            } else if (right > left) {
                //这个说明右括号比做括号的数量多了，是不可能拼出正确的一对括号的
                left = right = 0;
            }
        }
        //为什么还需要从右往左一遍啊，原因就是怕左括号一直比右括号多 这里其实可以把字符反转一下复用上面的代码
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }

    /**
     * 动态规划
     * 有问题
     * @param s
     * @return
     */
    public static int longestValidParenthesesDP(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    //后一个结果有可能受前一个结果的影响
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                    i - dp[i-1] 这个是防止下标越界了, i - dp[i-1]-1 这个的值表示的是把当前前面合格的都给剔除
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1]] - 2 : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    /**
     * 利用栈的方式来解决
     * 有问题
     * @param s
     * @return
     */
    public static int longestValidParentheses1(String s) {
        int maxans = 0;
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
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    // 有问题
    public static int longestValidParentheses(String s) {
        int ret = 0;
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < s.length()) {
            if (i == 0 && s.charAt(i) == ')') {
                i++;
            } else {
                if (s.charAt(i) == '(') {
                    stack.push(s.charAt(i++));
                } else {
                    int max = 0;
                    while (!stack.isEmpty() && i < s.length()) {
                        if (s.charAt(i) == ')') {
                            if (stack.pop() == '(') {
                                max += 2;
                                i++;
                            }
                            if (i < s.length() && s.charAt(i) == '(') {
                                stack.clear();
                                stack.add(s.charAt(i++));
                            } else {
                                i++;
                            }
                        }
                    }
                    ret = Math.max(ret, max);
                }
            }

        }
        return ret;
    }
}
