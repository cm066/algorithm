package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author Administrator
 */
public class Graph {
    private int v;
    private LinkedList<Integer> adj[];//邻接表
    private boolean found;
    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

    }

    /**
     * 无向图
     * @param s 起点
     * @param t 终点
     */
    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }
    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    /**
     * 广度优先遍历,这样只能找出一条路径
     * @param s 起点
     * @param t 终点
     */
    public void bfs(int s,int t){
        if (s == t){
            return;
        }
        //这个是用于确定这个点是否走过了，避免重复
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] pre = new int[v];
        //用于表示这个是从那个点到这里的，简单的来说就是路径
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        while (queue.size() !=0){
            Integer w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]){
                    pre[q] = w;
                    if (q == t){
                        print(pre,s,t);
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }
    public void dfs(int s,int t){
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s,t,visited,prev);
        print(prev,s,t);
    }
    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true){
            return;
        }
        visited[w] = true;
        if (w == t){
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]){
                prev[q] = w;
                //这一步就体现了深度的思想，一路往下走，和广度优先遍历的最大区别就在这里
                recurDfs(q,t,visited,prev);
            }
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.bfs(0,7);
    }
}
