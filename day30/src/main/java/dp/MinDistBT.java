package dp;

/**
 * @author cm
 * @create 2022/3/2-11:31 下午
 * 最短路径
 */
public class MinDistBT {
    // 全局变量或者成员变量
    private int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,9},
                {2,1,3,4},
                {5,2,6,7},
                {6,8,4,3}
        };
        int i = minDistBTDP(matrix, 4);
        System.out.println(i);
    }


    private int n = 4;
    private int[][] mem = new int[4][4];
    int[][] matrix = {
            {1,3,5,9},
            {2,1,3,4},
            {5,2,6,7},
            {6,8,4,3}
    };
    public int minDist(int i, int j) { // 调用 minDist(n-1, n-1);
        if (i ==0 && j == 0){
            return matrix[0][0];
        }
        if (mem[i][j] > 0){
            return mem[i][j];
        }
        int minLeft = Integer.MAX_VALUE;
        if (j-1 >= 0){
            minDist(i,j-1);
        }
        int  minUp = Integer.MAX_VALUE;
        if (i-1 >= 0){
            minUp = minDist(i-1,j);
        }
        int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }
    /**
     * 动态规划
     * @param matrix
     * @param n
     * @return
     */
    public static int minDistBTDP(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        //初始化第一行
        for (int j = 0; j < n; j++) {
            sum += matrix[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        //初始化第一列数据
        for (int j = 0; j < n; j++) {
            sum += matrix[j][0];
            states[j][0] = sum;
        }
        //第(i，j)位置的值可以来自(i-1，j),(i,j-1),所以这两个中谁的值最小就取谁，状态转移方程为 f(i,j) = matrix[i][j] + Math.min(f(i-1，j),f(i-1，j))
        //代表行
        for (int i = 1; i < n; i++) {
            //代表列
            for (int j = 1; j < n; j++) {
                states[i][j] = matrix[i][j] + Math.min(states[i][j-1],states[j][i-1]);
            }
        }
        return states[n-1][n-1];
    }

    // 调用方式：minDistBacktracing(0, 0, 0, w, n);  这个是回溯算法，存在很多重复的
    //并且时间复杂度为指数级别的
    public void minDistBTBack(int i, int j, int dist, int[][] w, int n) {
    // 到达了 n-1, n-1 这个位置了，这里看着有点奇怪哈，你自己举个例子看下
        if (i == n && j == n){
            if (dist < minDist){
                minDist = dist;
                return;
            }
        }
        //往下走，更新 i= i+1，j=j
        if (i < n){
            minDistBTBack(i+1,j,dist+w[i][j],w,n);
        }
        //往右走，更新 i= i，j=j+1
        if (j< n){
            minDistBTBack(i,j+1,dist+w[i][j],w,n);
        }
    }
}
