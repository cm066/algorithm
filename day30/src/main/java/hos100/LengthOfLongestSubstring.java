package hos100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cm
 * @create 2022/3/15-10:40 下午
 * 3. 无重复字符的最长子串
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s){
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        if (n == 0 || n == 1){
            return n;
        }
        int rk = -1,ans = 0;
        for (int i = 0; i < n; i++) {
            if ( i != 0){
                //把遇到的第一个于上一步相同的字符去除
                occ.remove(i-1);
            }
            while (rk + 1< n && !occ.contains(s.charAt(rk+1))){
                rk++;
                occ.add(s.charAt(rk+1));
            }
            ans = Math.max(ans,rk-i+1);
        }
        return ans;
    }
}
