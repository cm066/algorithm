package dp;

import java.util.jar.JarEntry;

/**
 * @author cm
 * @create 2022/3/4-10:46 下午
 * 莱文斯距离 就是求两个字符的相似度
 */
public class LwstBT {
    public static void main(String[] args) {

    }
    //用动态规划来实现求两个字符串最长公共子串长度
    // todo
    public int lcs(char[] a, int n, char[] b, int m) {
        int[][] maxlcs = new int[n][m];
        // 初始化第 0 行：a[0..0] 与 b[0..j] 的 maxlcs
        for (int j = 0; j < m; ++j) {
            if (a[0] == b[j]) {
                maxlcs[0][j] = 1;
            } else if (j != 0) {
                maxlcs[0][j] = maxlcs[0][j-1];
            } else {
                maxlcs[0][j] = 0;
            }
        }
        // 初始化第 0 列：a[0..i] 与 b[0..0] 的 maxlcs
        for (int i = 0; i < n; ++i) {
            if (a[i] == b[0]) {
                maxlcs[i][0] = 1;
            } else if (i != 0) {
                maxlcs[i][0] = maxlcs[i-1][0];
            } else {
                maxlcs[i][0] = 0;
            }
        }
        return 0;
    }
    public int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        //初始化第一行
        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) {
                minDist[0][j] = j;
            }else if (j != 0){
                minDist[0][j] = minDist[0][j-1] + 1;
            }else {
                minDist[0][j] = 1;
            }
        }
        //初始化第一列
        for (int i = 0; i < n; i++) {
            if (a[i] == b[0]){
                minDist[i][0] = i;
            }else if (i != 0){
                minDist[i][0] = minDist[i-1][0] + 1;
            }else {
                minDist[i][0] = 1;
            }
        }
        //按行进行填表
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] == b[i]){
                    minDist[i][j] = min(minDist[i][j-1]+1,minDist[i-1][j]+1,minDist[i][j]);
                }else {
                    minDist[i][j] = min(minDist[i][j-1]+1,minDist[i-1][j]+1,minDist[i-1][j-1]+1);
                }
            }
        }
        return minDist[n-1][m-1];
    }
    private int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    //// 存储结果 就是表示编辑的次数
    private int minDist = Integer.MAX_VALUE;
    // 调用方式 lwstBT(0, 0, 0); ，这里只是把一些参数作为了成员变量 这里是回溯法
    public void lwstBT(int i, int j, int edist) {
        if (i == n || j == m){
            if (i < n){
                edist += (n-1);
            }
            if (j < m){
                edist += (m -j);
            }
            if (edist < minDist){
                minDist = edist;
            }
            return;
        }
        if (a[i] == b[j]){
            //两个字符匹配
            lwstBT(i+1,j+1,edist);
        }else {
            //两个字符不匹配，要不是i+1，j+1，要不就是在任意一个字符添加或者是删除
            // 删除 a[i] 或者 b[j] 前添加一个字符
            lwstBT(i+1,j,edist+1);
            //删除b[i]或者是a[i]前面添加一个字符
            lwstBT(i,j+1,edist+1);
            //将a[i] 和b[j]替换成相同的字符串，然后编辑的次数
            lwstBT(i+1,j+1,edist+1);
        }
    }
}
