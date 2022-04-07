package dp;

import javax.lang.model.element.VariableElement;

/**
 * @author cm
 * @create 2022/4/6-11:26 下午
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 */
public class NumIslands {
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length ==0 || grid[0].length == 0){
            return 0;
        }
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0){
                    result++;
                    dfs(i,j,row,col,grid);
                }
            }
        }
        return result;
    }
    public static void dfs(int i, int j,int row,int col,char[][] grid){
        if (i  < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0){
            return;
        }
        grid[i][j] =  0;
        dfs(i+1,j,row,col,grid);
        dfs(i, j+1, row, col, grid);
        dfs(i-1, j, row, col, grid);
        dfs(i, j-1, row, col, grid);
    }
}
