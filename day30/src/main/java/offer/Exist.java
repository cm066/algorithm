package offer;

/**
 * @author cm
 * @create 2022/3/28-8:35 下午
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class Exist {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        String word = "ABCCED";
        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    /**
     * 解题的思路
     * dfs + 回溯；
     * 使用二维布尔数组记录之前的位置是否已经被访问过，如果已经被访问过的话，则在 dfs 的过程中，直接 return false 即可。也就是说，此路已经不通了；
     * 如果当前遍历到的字符不等于 board[i][j] 位置上的字符，那么说明此路也是不通的，因此返回 false；
     * 至于递归结束的条件：如果指针 start 能够来到 word 的最后一个字符，那么说明能够在矩阵 board 中找到一条路径，此时返回 true；
     * 在遍历到当前 board[i][j] 的时候，首先应将该位置的 visited[i][j] 设置为 true，表明访问过；
     * 然后，递归地去 board[i][j] 的上下左右四个方向去找，剩下的路径；
     * 在 dfs 的过程当中，如果某条路已经不通了，那么那么需要回溯，也就是将 visited[i][j] 位置的布尔值重新赋值为 fasle；
     * 最后，返回 ans 即可。
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        //这里是以每一个点为出发点，然后采用深度优先遍历点方法
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }
    static boolean  dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if(k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        //向下，向右，向左，向上
        boolean  res =  dfs(board, word, i+1, j, k+1) || dfs(board, word, i-1, j, k+1)
                || dfs(board, word, i, j+1, k+1) || dfs(board, word, i, j-1, k+1);
        board[i][j] = word[k];
        return res;
    }
}
