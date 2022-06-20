package arr;

public class GenerateMatrix {
    public static void main(String[] args) {

    }
    public static int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;
        while (loop < n /2){
            //从左到右
            for (j = start; j < n-loop ; j++) {
                res[start][j] = count++;
            }
            //从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] =     count++;
            }
            //从右到左
            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }
            //从下往上
            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }
        //这个是写中最中间的位置
        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}
