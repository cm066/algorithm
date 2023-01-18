package com.str;

public class IsMatch {
    public static void main(String[] args) {
//        String s = "mississippi" ,p = "mis*is*p*.";
//        String s = "aa" ,p = "a*";
        String s="aab", p="c*a*b";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }

    /**
     * 这个题还有问题，todo
     * 示例 1：
     *
     * 输入：s = "aa", p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     *
     * 输入：s = "aa", p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3：
     *
     * 输入：s = "ab", p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * @param s
     * @param p
     * @return
     */
    // todo 可以用队列来解决这个问题
    // aab "c*a*b"
    public static boolean isMatch(String s, String p) {
        // 处理特殊的问题
        if (p == null || p.length() == 0){
            return false;
        }
        int sLen = s.length(), pLen = p.length();
        int sIndex = 0, pIndex = 0;

        while (sIndex < sLen && pIndex < pLen){
            // 考虑特殊问题
            if ((p.charAt(pIndex) != '.' && p.charAt(pIndex) != '*') && s.charAt(sIndex) != p.charAt(pIndex)){
                pIndex++;
            }else if (s.charAt(sIndex) == p.charAt(pIndex)){
                sIndex++;
                pIndex++;
            }else if (s.charAt(sIndex) != p.charAt(pIndex)){
                if (p.charAt(pIndex) == '.'){
                    sIndex++;
                    pIndex++;
                } else if (p.charAt(pIndex) == '*') {
                    if (sIndex == pIndex){
                        sIndex++;
                    } else if (sIndex != pIndex && sIndex != 0 && s.charAt(sIndex - 1) == s.charAt(sIndex)) {
                        sIndex++;
                    }else if (sIndex != pIndex && sIndex == 0){
                        sIndex++;
                    } else if (pIndex > sIndex) {
                        sIndex++;
                    } else if (sIndex != pIndex && sIndex != 0 && s.charAt(sIndex - 1) != s.charAt(sIndex)) {
                        return false;
                    }

                    if ( (pIndex+1)< pLen && s.charAt(sIndex) == p.charAt(pIndex+1)){
                        pIndex++;
                    }
                }
            }
        }
        return  sIndex == sLen;
    }
}
