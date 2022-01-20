package slidingWindow;

import java.util.*;

/**
 * @author cm
 * @create 2022/1/20-10:08 下午
 * 76. 最小覆盖子串 困难
 */
public class MinWindow {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        MinWindow minWindow = new MinWindow();
        String t = "ABC";
        String s1 = minWindow.minWindow(s,t);
        System.out.println(s1);
    }

    /**
     * todo 优化的三个点
     * 1、扔掉那些 tt 中没有出现的字符，然后再做滑动窗口呢？  //这个可以map基础各个字符次数和然后在想要的位置表示
     * 2、出现  XXABXXCXXABXXC 的情况，在统计长度的时候可以扔掉前两个 XX，但是不扔掉中间的 XX，怎样解决这个问题呢？
     * 3、优化后的时空复杂度又是多少？
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0)+1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE,  ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen){
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r){
                //这里就是在不断的将窗口缩短并验证窗口中的字符个数是否正确·
                if (r - l +1 < len){
                    len = r -l +1;
                    ansL = l;
                    ansR = l+len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check(){
        Iterator<Map.Entry<Character, Integer>> iter = ori.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            //因为这里要判断字符的个数对不对,因为是子字符串所以顺序没有那中，只需要考虑字符的个数对不对
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
