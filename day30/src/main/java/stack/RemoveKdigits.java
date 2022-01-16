package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author cm
 * @create 2022/1/16-10:24 下午
 * 402. 移掉 K 位数字 中等
 */
public class RemoveKdigits {
    public static void main(String[] args) {
        String num = "1432219";
        String num1 = "10200";
        String num2 = "112";
        String s = removeKdigits(num2, 1);
        System.out.println(s);
    }
    public static String removeKdigits1(String num, int k){
        if (k == 0){
            return num;
        }
        if (num.length() <= k){
            return "0";
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k >0 && stack.peekLast() > c){
                stack.pollLast();
                k--;
            }
            stack.offerLast(c);
        }
        for (int i = 0; i < k; ++i) {
            stack.pollLast();
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
    /**
     * 有点问题，加入要删除的是最后一个字符的时候有问题，需要解决,已解决
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        if (k == 0){
            return num;
        }
        if (num.length() <= k){
            return "0";
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(num.charAt(0)-48);
        for (int i = 1; i < num.length(); i++) {
            if (stack.peekLast() > (num.charAt(i)-48) && k > 0){
                stack.removeLast();
                k--;
            }
           stack.addLast(num.charAt(i)-48);
        }
        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }
        StringBuilder builder = new StringBuilder();
        if ((stack.size() >= 2)&&stack.getFirst() == 0){
            stack.removeFirst();
        }
        while (!stack.isEmpty()){
            builder.append(stack.removeFirst());
        }
        return builder.toString();
    }
}
