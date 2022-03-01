package dp;

/**
 * @author cm
 * @create 2022/3/1-11:17 下午
 * 淘宝的“双十一”购物节有各种促销活动，比如“满 200 元减 50 元”。假设你女朋友的
 * 购物车中有 n 个（n>100）想买的商品，她希望从里面选几个，在凑够满减条件的前提
 * 下，让选出来的商品价格总和最大程度地接近满减条件（200 元），这样就可以极大限度
 * 地“薅羊毛”
 */
public class BuyDP {
    public static void main(String[] args) {

    }
    // items 商品价格，n 商品个数, w 表示满减条件，比如 200
    public static void double11advance(int[] items, int n, int w) {
        // 超过 3 倍就没有薅羊毛的价值了 这里为什么是3倍
        boolean[][] states = new boolean[n][3*w+1];
        // 第一行的数据要特殊处理
        states[0][0] = true;
        states[0][items[0]] = true;

        for (int i = 1; i < n; i++) {
            //不购买第i个商品
            for (int j = 0; j < 3*w; j++) {
                if (states[i-1][j] == true){
                    states[i-1][j] = states[i-1][j];
                }
            }
            //购买第i个商品
            for (int j = 0; j < 3*w-items[i]; j++) {
                if (states[i-1][j]==true) {
                    states[i][j+items[i]] = true;
                }
            }
        }

        int j;
        for (j = w; j < 3*w+1; j++) {
            if (states[n-1][j] == true){
                break;
            }
        }
        //没有解
        if (j == 3*w+1){
            return;
        }
        for (int i = n-1; i >= 1; i--) {
            // i 表示二维数组中的行，j 表示列
            if (j-items[i] >= 0 && states[i-1][j-items[i]] == true){
                // 购买这个商品
                System.out.print(items[i] + " ");
                j = j - items[i];
            }// else 没有购买这个商品，j 不变。
        }
        if (j != 0) {
            System.out.print(items[0]);
        }
    }
}
