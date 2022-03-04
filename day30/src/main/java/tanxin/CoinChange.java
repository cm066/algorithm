package tanxin;

import java.util.Arrays;

/**
 * @author cm
 * @create 2022/3/3-12:50 上午
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int i = coinChange(coins, 11);
        System.out.println(i);
    }

    /**
     * 就是选择最少的数量来达到那个值，这个题目的假设值是每种币的数量都是无限的，所以每次都选择最大的来支付，比最大的小就选择小一个的值来支付
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins,int amount){
        Arrays.sort(coins);
        int res = 0;
        int index = coins.length-1;
        int curMax;
        while (amount > 0){
            //这两步其实就体验出了贪心的算法
            curMax = coins[index];
            if (amount >= curMax){
                //每次都选择最大来
                int num = amount / curMax;
                res += num;
                amount = amount - num*curMax;
            }
           index--;
        }
        return res;
    }
}
