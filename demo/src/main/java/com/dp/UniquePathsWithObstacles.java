package com.dp;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}};
        int i = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
        int i1 = uniquePathsWithObstacles1(obstacleGrid);
        System.out.println(i1);
    }

    // 只能向右或者向下走
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }

    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
         dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        // 第一列 // 第一行
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0];

        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i-1];
        }
        // 要初始化第一行和第一列
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][i - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

}
