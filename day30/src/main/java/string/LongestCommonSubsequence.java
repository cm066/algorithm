package string;

/**
 * @author cm
 * @create 2022/4/4-3:05 下午
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（
 * 也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        int i = longestCommonSubsequence(text1, text2);
        System.out.println(i);
    }

    /**
     * 公共子串是连续的，子序列可以不是联系的但是顺序必须是一样的
     * 动态规划的思想，text1=bdcaba
     *               text2=abcddab
     *               dp[i][j] 就表示 text1[0-i] text2[0-j]之间的公共子序列
     *               当text1[i]=text2[j] dp[i][j]= dp[i-1][j-1]+1
     *               当text1[i] !=text2[j]
     *               可能是text1[0-i] text2[0-j]之间的公共子序列
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j-1);
                if (c1 == c2){
                    //表示i和j两个字符相等，只需要将前面的最大值+1即可表示当前的
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    //表示i和hj两字符不相等，这里就要判断是text1[0,i-1]，text2[0,j]和text1[0,i],text2[0,j-1]
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
