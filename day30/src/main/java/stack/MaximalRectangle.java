package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cm
 * @create 2022/1/17-10:42 下午
 * 85. 最大矩形 困难
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
//        int i = maximalRectangle(matrix);

        int i = maximalRectangleStack(matrix);
        System.out.println(i);
    }

    /**
     * 采用单调栈来优化时间
     * @param matrix
     * @return
     */
    public static int maximalRectangleStack(char[][] matrix) {
        int maxArea = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return maxArea;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    left[i][j] = (j == 0 ?  0 : left[i][j-1])+1;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            //对于每一列，，使用基于柱状图的方法
            int[] up = new int[m];
            int[] down = new int[m];
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 :stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m-1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    public static int maximalRectangle(char[][] matrix) {
        int maxAre = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return maxAre;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    left[i][j] = (j == 0 ?  0 : left[i][j-1])+1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0'){
                    continue;
                }
                int width = left[i][j];
                int area  = width;
                for (int k = i-1; k >= 0 ; k--) {
                    //这个只需要和当前一列的上面几个数相比较，不用管其他的
                    width = Math.min(width,left[k][i]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                maxAre = Math.max(maxAre,area);
            }
        }
        return maxAre;
    }
}
