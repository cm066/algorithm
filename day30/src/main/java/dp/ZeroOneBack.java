package dp;

import javax.swing.*;

/**
 * @author cm
 * @create 2022/3/1-9:21 下午
 * 0 1背包的多种解法
 * 一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限
 * 制的前提下，背包中物品总重量的最大值是多少
 */
public class ZeroOneBack {
    // 结果放到 maxW 中
    private static int maxVal = Integer.MIN_VALUE;
    // 备忘录，默认值 false
    private static boolean[][] mem = new boolean[5][10];
    public static void main(String[] args) {
        // 物品重量
        int[] weight = {2,2,4,6,3};
        // 物品个数
        int n = 5;
        // 背包承受的最大重量
        int w = 9;
        int back = dp(weight, n, w);
        System.out.println(back);
    }

    /**
     * 动态规划进行空间的优化
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public static int dp1(int[] weight,int n,int w){
        boolean[] states = new boolean[w+1];
        states[0] = true;
        states[weight[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = w - weight[i]; j >= 0; --j) {
                if (states[j] == true){
                    states[j+weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0 ; i--) {
            if (states[i] == true){
                return i;
            }
        }
        return 0;
    }
    public static int dp(int[] weight,int n,int w){
        boolean[][] states = new boolean[n][w+1];
        states[0][0] = true;
        states[0][weight[0]] = true;
        //动态规划的状态转移，这个也是最重要的
        for (int i = 1; i < n; i++) {
            //不把第i个物品放进背包里面
            for (int j = 0; j <= w; j++) {
                if (states[i-1][j] == true){
                    states[i][j] = states[i-1][j];
                }
            }
            //把第i个物品放进背包里面
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i-1][j] == true){
                    states[i][j+weight[i]] = true;
                }
            }
        }
        // 输出结果
        for (int i = w; i >= 0; --i) {
            if (states[n-1][i] == true) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 采用回溯发加上备忘录模式，效率和动态规划差不多
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public static int back(int[] weight,int n,int w){
        backHelp(weight,n,w,0,0);
        return maxVal;
    }

    public static void backHelp(int[] weight,int n,int w,int cw,int i){
        if (cw == w || i ==n){
            if (cw > maxVal){
                maxVal = cw;
            }
            return;
        }
        if (mem[i][cw]){
            //表示这个之前就已经计算过了，就之间返回就行
            return;
        }
        //记录这个计算的结果，在那个斐波拉数用递归的时候也可以采用这种方式
        mem[i][cw] = true;
        // 选择不装第 i 个物品
        backHelp(weight,n,w,cw,i+1);
        if (cw + weight[i] <= w) {
            // 选择装第 i 个物品
            backHelp(weight,n,w,cw+weight[i],i+1);
        }
    };
}
