package dp;

import java.util.jar.JarEntry;

/**
 * @author cm
 * @create 2022/3/1-10:33 下午
 */
public class ZeroOneBackMaxValue {
    // 结果放到 maxV 中
    private int maxV = Integer.MIN_VALUE;
    // 物品的重量
    private int[] weight = {2,2,4,6,3};
    // 物品的价值
    private int[] value = {3,4,8,9,6};
    // 物品个数
    private int n = 5;
    //背包承受的最大重量
    private int w = 9;

    public static void main(String[] args) {

    }
    public void f(int i, int cw, int cv) { // 调用 f(0, 0, 0)
        if (i == n || cw == w){
            if (cv > maxV){
                maxV = cv;
            }
        }
        //选择不装第i个
        f(i+1,cw,cv);
        if (cw + weight[i] <= w){
            //选择装第i个
            f(i+1,cw+weight[i], cv+value[i]);
        }
    }

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        //初始化states
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w+1; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        states[0][weight[0]] = value[0];
        //动态规划，状态转移
        for (int i = 1; i < n; i++) {
            //不选择第i个物品
            for (int j = 0; j <= w ; j++) {
                if (states[i-1][j] > 0){
                    states[i][j] = states[i-1][j];
                }
            }
            //选择第i个物品
            for (int j = 0; j <= w-weight[i] ; j++) {
                if (states[i-1][j] >= 0){
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]){
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        //找出最大值
        int maxValue = -1;
        for (int i = 0; i <= w; i++) {
            if (states[n-1][i] > maxValue){
                maxValue = states[n-1][i];
            }
        }
        return maxValue;
    }
}
