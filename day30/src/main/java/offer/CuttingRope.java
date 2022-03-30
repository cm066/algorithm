package offer;

/**
 * @author cm
 * @create 2022/3/29-7:35 下午
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 */
public class CuttingRope {
    public static void main(String[] args) {
        int i = cuttingRopeDp(5);
        System.out.println(i);
        System.out.println(5/2);
    }

    /**
     * 动态规划
     * 设数组dp记录0 ~ n 剪绳子的最大乘积
     * 两层遍历：第一层表示绳子的长度 第二层用来表示第一段减去的长度。要想求最大值，有两种情况：
     * 剪绳子：剪绳子的话乘积就是 j * dp[i - j] 减去第一段的长度 * 剩下长度的最大值
     * 剪第一段，第二段不剪，直接 j * (i - j ) 当前的长度 * 剩下的长度
     * 不剪 dp[i]
     *
     * 作者：LeetCode_xsong
     * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/jian-zhi-offer-by-leetcode_xsong-yrqo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static int cuttingRopeDp(int n) {
        int[] dp = new int[n+1];
        if (n <= 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        dp[1] =1;
        dp[2] =  2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= (i/2); j++) {
                //这里就体验了子过程最优解
                dp[i] = Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }


}
