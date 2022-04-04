package dp;

/**
 * @author cm
 * @create 2022/4/4-4:46 下午
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * 示例 1：
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestIncreasingPath {
    public static void main(String[] args) {

    }

    /**
     * 我想到的是配合上深度优先遍历
     *  dirs 这个代表的是四个方向
     * @param matrix
     * @return
     */
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //这个就是以每个点为出发
                ans = Math.max(ans,dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }


    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        //用这个代替了，if语句
        for (int[] dir : dirs) {
            //这里就是让这个点往四个方向走，找出最大的
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 &&
                    newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {

                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }
}
