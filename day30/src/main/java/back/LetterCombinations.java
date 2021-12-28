package back;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cm
 * @create 2021/12/27-9:56 下午
 * 电话号码数组组合
 */
public class LetterCombinations {
    public static void main(String[] args) {
        List<String> list = letterCombinations1("23");
        System.out.println(list);
    }

    public static List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        helper(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }
    public static void helper(List<String> combinations,Map<Character,String> phoneMap,String digits,
                              int index,StringBuffer combination){
        if (index == digits.length()){
            //说明已经是最后一个了
            combinations.add(combination.toString());
        }else {
            char c = digits.charAt(index);
            String s = phoneMap.get(c);
            int length = s.length();
            for (int i = 0; i < length; i++) {
                combination.append(s.charAt(i));
                //这里进行下一个判断，看是否是最后一个
                helper(combinations,phoneMap,digits,index+1,combination);
                //删除当前的字符，然后进行下一个
                combination.deleteCharAt(index);
            }
        }

    }
    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
    //第一种解法，暴力递归
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return result;
        }
        if (digits.length() == 1){
            for (int i = 0; i < digits.length(); i++) {
                result.add(String.valueOf(digits.charAt(i)));
            }
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        char[] chars = digits.toCharArray();
        String[] str = new String[digits.length()];
        for (int i = 0; i < chars.length; i++) {
            str[i] = phoneMap.get(chars[i]);
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0){
                String s = phoneMap.get(chars[i]);
                for (int j = 0; j < s.length(); j++) {
                    list.add(s.charAt(i)+"");
                }
            }
            for (String s : list) {
                String s1 = phoneMap.get(chars[i]);
                for (int j = 0; j < s1.length(); j++) {
                    s = s+s1.charAt(i);

                }
            }
        }

        return null;
    }
}
