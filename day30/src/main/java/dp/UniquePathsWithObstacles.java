package dp;

/**
 * @author cm
 * @create 2022/3/16-10:29 下午
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid1 = {
                {0,1,0,0},
                {0,0,0,0},
                {0,0,0,0},
        };
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0},
        };
        uniquePathsWithObstacles(obstacleGrid);
    }

    /**
     * 优化空间
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1){
                    f[0] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }

            }
        }
        return f[m-1];
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if (obstacleGrid == null || obstacleGrid[0][0] ==1){
            return 0;
        }
        int[][] dp = new int[n][m];
        dp[0][0] =1;
        //初始化一行
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
            }else {
                dp[0][i]  = dp[0][i-1] == 0 ? 0:1;
            }
        }
        //初始化第一列
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
            }else {
                dp[i][0]  = dp[i-1][0] == 0 ? 0:1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1){
                    //转移方程为f(i,j) = f(i-1,j)+f(i,j-1)
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }else {
                    dp[i][j] = 0;
                }

            }
        }
        return dp[n-1][m-1];
    }
}
