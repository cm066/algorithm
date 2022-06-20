package stack;


import java.util.Stack;

/**
 * @author cm
 * @create 2022/1/3-9:28 下午
 * 判断括号是否有效
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "(()[]{})";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() == 1){
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.size()*2 > chars.length){
                return false;
            }
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '['){
                stack.push(chars[i]);
            }else {
                if (stack.isEmpty()){
                    return false;
                }else {
                    if (chars[i] == ')' && stack.pop() != '(') {
                        return false;
                    }
                    if (chars[i] == '}' && stack.pop() != '{'){
                        return false;
                    }
                    if (chars[i] == ']' && stack.pop() != '['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
