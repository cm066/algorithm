package slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cm
 * @create 2022/1/21-12:19 上午
 * 3. 无重复字符的最长子串 中等
 * 输入: s = "abcabcbb"
 * 输出: 3
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcbbcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        //用haset去重
        Set<Character> set = new HashSet<>();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0){
                //这一步就体现了让窗口移动的思想

                set.remove(s.charAt(i-1));
            }
            while (rk + 1 < s.length() && !set.contains(s.charAt(rk +1))){
                set.add(s.charAt(rk+1));
                rk++;
            }
            ans = Math.max(ans,(rk- i +1));
        }
        return ans;
    }
}
