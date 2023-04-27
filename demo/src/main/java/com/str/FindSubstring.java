package com.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {
    public static void main(String[] args) {
        List<String> ret = new ArrayList<>();
        String[] words = {"foo", "bar"};
        boolean[] use = new boolean[words.length];
        helper(ret, new StringBuilder(), words, 0, use);
        System.out.println(ret);
    }

    // 输入：s = "barfoothefoobarman", words = ["foo","bar"]
    //输出：[0,9]
    //解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
    //子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
    //子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
    //输出顺序无关紧要。返回 [9,0] 也是可以的。
    // 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab"
    // 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
    public List<Integer> findSubstring(String s, String[] words) {
        // 先把words里面的全部给组合出来？;

        List<Integer> res = new ArrayList<>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return null;
    }


    public static void helper(List ret, StringBuilder builder, String[] words, int index, boolean[] use) {
        if (index == words.length) {
            ret.add(builder.toString());
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (use[i]) {
                continue;
            }
            builder.append(words[i]);
            use[i] = true;
            helper(ret, builder, words, i + 1, use);
            builder.replace((builder.length() - words[0].length() * (i + 1)), words[0].length(), "");
//            builder.deleteCharAt(builder.length() - words[0].length()*(i+1));
            use[i] = false;
        }
    }
}
