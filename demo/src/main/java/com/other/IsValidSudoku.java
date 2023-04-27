package com.other;

public class IsValidSudoku {
    public static void main(String[] args) {
        int[][] nums = {{1, 2},
                {3, 4}};
        for (int[] num : nums) {
            for (int i = 0; i < nums.length; i++) {
                System.out.println(num[i]);
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    //
                    rows[i][index]++;
                    columns[j][index]++;
                    // 这就是判断小宫格里面是否存在相同的数
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
