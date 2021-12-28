package back;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cm
 * @create 2021/12/27-11:13 下午
 * 括号生成
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(2);
        System.out.println(list);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0){
            return result;
        }
        if (n == 1){
            result.add("()");
            return result;
        }
        helper(result,new StringBuilder(),0,0,n);
        return result;
    }

    /**
     * 回溯主要就是找判断条件加递归的思想，并且能回到前一个状态
     * @param ans
     * @param cur
     * @param open
     * @param close
     * @param max
     */
    public static void helper(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max*2){
            ans.add(cur.toString());
            return;
        }
        if (open < max){
            cur.append('(');
            helper(ans,cur,open+1,close,max);
            //这一步的作用主要还是删除当前位置的字符，回退到前一个状态，回溯就是不断前进和不断后退
            cur.deleteCharAt(cur.length()-1);
        }
        //比如说右括号都比左括号多了，那肯定是一个无效都括号
        if (close < open){
            cur.append(')');
            helper(ans,cur,open,close+1,max);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
