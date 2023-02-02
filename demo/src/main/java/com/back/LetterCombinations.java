package com.back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
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

    // 回溯
    private void helper(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer stringBuffer) {

        if (index == digits.length()){
           combinations.add(stringBuffer.toString());
        }else {
            char c = digits.charAt(index);
            String s = phoneMap.get(c);
            int length = s.length();
            for (int i = 0; i < length; i++) {
                stringBuffer.append(s.charAt(i));
                helper(combinations, phoneMap, digits, index+1, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }
}
