package offer;

/**
 * @author cm
 * @create 2022/3/28-8:17 下午
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 */
public class NumWays {
    public static void main(String[] args) {
        int i = numWaysDp(7);
        System.out.println(i);
    }
    // 1 = 1; 2 = 2; 3 = 1+2;递归很容易解决，也可以采用动态规划
    public static int numWays(int n) {
        if (n <= 2){
            return n;
        }
        return numWays(n-1)+numWays(n-2);
    }
    public static int numWaysDp(int n) {
        final int MOD = 1000000007;
        if (n <= 2){
            return n == 0 ? 1:n;
        }
        int q =0, p = 1,r = 2;
        for (int i = 3; i <= n; i++) {
            q = p;
            p = r;
            r =(q+p) % MOD;
        }
        return r;
    }
}
