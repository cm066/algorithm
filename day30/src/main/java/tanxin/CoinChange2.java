package tanxin;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author cm
 * @create 2022/3/3-12:51 上午
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。 
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int i = coinChange(coins, 5);
        System.out.println(i);
    }
    public static int coinChangeDP(int[] coins,int amount){

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
    public static int coinChange(int[] coins,int amount){
        List<List<Integer>> combine = new ArrayList<>();
        helper(combine,new ArrayList<>(),coins,amount,0);
        return combine.size();
    }

    public static void helper(List<List<Integer>> combine,List<Integer> path,int[] coins,int amount,int index){
        if (amount == 0){
            combine.add(new ArrayList<>(path));
            return;
        }
        if (amount < 0){
            return;
        }
        //每次选择的硬币只能从当前往后，不然就会出现重复的
        for (int i = index; i < coins.length; i++) {
            path.add(coins[i]);
            helper(combine,path,coins,amount-coins[i],i);
            path.remove(path.size()-1);
        }
    }
}
