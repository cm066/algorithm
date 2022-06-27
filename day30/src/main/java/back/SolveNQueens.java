package back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveNQueens {

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> lists = solveNQueens.solveNQueens(4);
        System.out.println(lists);
    }
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }

    public void backTrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row,col,n,chessboard)){
                chessboard[row][col] = 'Q';
                backTrack(n,row+1,chessboard);
                chessboard[row][col] = '.';
            }
        }
    }
    public List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    /**
     *
     * @param row 行
     * @param col 列
     * @param n 几皇后
     * @param chessboard 填充的棋盘
     * @return
     *
     * 不能同行
     * 不能同列
     * 不能同斜线 （45度和135度角）
     */
    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        //45度方向对角线
        for (int i = row-1,j=col-1; i>=0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q'){
                return false;
            }
        }
        //135度方向对角线
        for (int i = row-1,j=col+1; i>=0 && j <= n-1; i--, j++) {
            if (chessboard[i][j] == 'Q'){
                return false;
            }
        }
        //这里为什么只检查135和45的上半部分，因为下半部分没有填充，即为空白的
        return true;
    }
}
