package back;

public class SolveSudoku {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(board);
    }

    /**
     *
     * 编写一个程序，通过填充空格来解决数独问题。
     * 数独部分空格内已填入了数字，空白格用'.'表示。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sudoku-solver
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param board
     */
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board){
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！」
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){ // 跳过原始数字
                    continue;
                }
                for (char k = '1'; k <= '9'; k++){ // (i, j) 这个位置放k是否合适
                    if (isValidSudoku(i,j,k,board)){
                        board[i][j] = k;
                        //
                        if (solveSudokuHelper(board)){ // 如果找到合适一组立刻返回
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
                // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
            }
        }
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     *     同行是否重复
     *     同列是否重复
     *     9宫格里是否重复
     *     * 数独的解法需 遵循如下规则：
     *      *      *
     *      *      * 数字1-9在每一行只能出现一次。
     *      *      * 数字1-9在每一列只能出现一次。
     *      *      * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
     */
    private boolean isValidSudoku(int row, int col, char val, char[][] board){
        //同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        //痛一列是否相等
        for (int i = 0; i < 9; i++){
            if (board[i][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复 下面这是寻找九宫格里面的起始位置
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}
