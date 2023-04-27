package com.str;

public class StrStr {
    public static void main(String[] args) {
//        String haystack = "mississippi", needle = "issip";
        String haystack = "sadbutsad", needle = "sad";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }

    // 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
    // 如果 needle 不是 haystack 的一部分，则返回  -1 。
    //示例 1：
    //
    //输入：haystack = "sbdbutsad", needle = "sad"
    //输出：0
    //解释："sad" 在下标 0 和 6 处匹配。
    //第一个匹配项的下标是 0 ，所以返回 0 。
    public static int strStr(String haystack, String needle) {

        int ret = -1;
        int Hi = 0, Ni = 0;
        while (Hi < haystack.length()) {
            int tmp = Hi;
            if (haystack.charAt(Hi) != needle.charAt(Ni)) {
                Hi = tmp + 1;
                continue;
            }
            while (Hi < haystack.length() && Ni < needle.length() && haystack.charAt(Hi) == needle.charAt(Ni)) {
                Hi++;
                Ni++;
            }
            if (Ni == needle.length()) {
                return Hi - Ni;
            }
            Hi = tmp + 1;
            Ni = 0;
        }
        return ret;
    }

    public static int strStr1(String haystack, String needle) {

        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
