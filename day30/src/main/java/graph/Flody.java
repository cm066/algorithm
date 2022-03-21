package graph;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author cm
 * @create 2022/3/17-11:12 下午
 */
public class Flody {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;//表示不可以连接
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
    }
}
class Graph2 {
    private char[] vertex;
    private int[][] dis;
    private int[][] pre;

    public Graph2(int length,char[] vertex, int[][] matrix){
        this.vertex = vertex;
        this.dis =matrix;
        pre = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i],i);
        }
    }

    public void show(){
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]]);
            }
            System.out.println();
            for (int i = 0; i < dis.length; i++) {
                System.out.print("("+vertex[k]+"到"+vertex[i]+"的最短路径为："+dis[k][i]);
            }
            System.out.println();
            System.out.println();
        }
    }

    public void floyd(){
        int len = 0;
        //中间遍历
        for (int k = 0; k < dis.length; k++) {
            //启始位置
            for (int i = 0; i < dis.length; i++) {
                //终点位置
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]){
                        dis[i][j] = len;
                        //这个前驱节点不是很明白
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}