package stack;

/**
 * @author cm
 * @create 2022/1/17-11:09 下午
 * 221. 最大正方形 中等
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','0','1','1','1'},
                {'1','0','0','1','0'},
        };
    }

    /**
     * 动态规划，从暴力递归中可以发现，其实有很多都不需要重复计算，从规律中也可以发现，右下脚的值依赖于左边，上边和左上的值
     * 所以动态转移方程可以写出
     * dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])
     * @param matrix
     * @return
     */
    public static int maximalSquareDP(char[][] matrix) {
        int maxAre = 0;
        if (matrix == null ||  matrix.length == 0 || matrix[0].length == 0){
            return maxAre;
        }
        int rows= matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;

                    }
                    maxAre = Math.max(maxAre,dp[i][j]);
                }

            }
        }
        return maxAre*maxAre;
    }
    /**
     * 暴力的方法来解决
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null ||  matrix.length == 0 || matrix[0].length == 0){
            return maxSide;
        }
        int rows= matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1'){
                    //遇到一个1可以作为正方形的左上角
                    maxSide = Math.max(maxSide,1);
                    // 计算可能的最大正方形边长
                    int currentMaxSide = Math.min(rows - i, columns - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        //判断新增的一行一列是否均为1
                        boolean flag = true;
                        if (matrix[i+k][j+k] == '0'){
                            //判断对角线是否为1，不为1，肯定是不能构成的
                            break;
                        }
                        for (int l = 0; l < k; l++) {
                            //matrix[i+k][j+l] == '0'
                            if (matrix[i+k][j+l] == '0' || matrix[i+l][k+j] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if (flag){
                            maxSide =Math.max(maxSide,k+1);
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        return  maxSide*maxSide;
    }
}
