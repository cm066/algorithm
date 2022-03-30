package offer;

/**
 * @author cm
 * @create 2022/3/30-8:14 下午
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * [[1,2,5],[3,2,1]]
 */
public class MaxValue {
    public static void main(String[] args) {
//        int[][] grid = {
//                {1,3,1},
//                {1,5,1},
//                {4,2,1}
//        };
        int[][] grid = {
                {1,2,5},
                {3,2,1}
        };
        int i = maxValue(grid);
        System.out.println(i);
    }

    /**
     * 动态规划，子过程最优解
     * 状态转移方程 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+dp[i][j] 这里就表示第i，j位置是从上面来的还是下面来的
     * 选择最大的那个
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        //初始化操作
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = grid[0][i]+dp[0][i-1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        int i = 0;
        return dp[row-1][col-1];
    }

}
