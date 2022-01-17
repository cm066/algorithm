package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author cm
 * @create 2022/1/17-9:35 下午
 * 316. 去除重复字母 中等
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        String s1 = removeDuplicateLetters(s);
        System.out.println(s1);
    }
    public static String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a']   = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] isV= new boolean[26];
        for (int i = 0; i < chars.length; i++) {
            if (isV[chars[i] - 'a']){
                //说明栈中已经存在了，后面的也不可以替代栈中已经存在的字母
                continue;
            }

            //lastIndex[stack.peekLast() - 'a'] > i 这一步的判断是虽然当前这个字符小于栈顶的元素，
            // 但是这后面已经没有栈顶的元素来，所以栈顶的元素不能弹出
            while (!stack.isEmpty()&&stack.peekLast() > chars[i] && lastIndex[stack.peekLast() - 'a'] > i){
                //说明这个字母之前的都大于当前字母的，然后当前字母之后还存在前面的字母
                Character top = stack.removeLast();
                isV[top - 'a'] = false;
            }
            stack.addLast(chars[i]);
            isV[chars[i] - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            builder.append(stack.removeFirst());
        }
        return builder.toString();
    }
}
