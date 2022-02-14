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

    /**
     * 拓扑排序，根局部依赖顺序解决全部依赖的顺序
     */
    public void topoSortByKahn(){
        // 统计每个顶点的入度
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                // i -> w
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            //这个表示没有其他依赖于它，可以先试着作为起点来解决
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer i = queue.remove();
            System.out.println("->"+i);
            for (int j = 0; j < adj[i].size(); j++) {
                Integer k = adj[i].get(j);
                //这个可以理解为该点被依赖度减少1
                inDegree[k]--;
                //这里表示这个点的其它要依赖于它的已经没有了，然后又以它为其它，看他依赖其它什么点
                if (inDegree[k] == 0){
                    queue.add(k);
                }
            }
        }

    }

    /**
     * 利用dfs深度优先搜素来实现拓扑排序
     */
    public void topoSortByDFS() {
        // 先构建逆邻接表，边 s->t 表示，s 依赖于 t，t 先于 s，这个相当于把依赖的关系给调转一下，这样需要额外的空间啊？
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            //初始化逆序需要用到的空间
            inverseAdj[i] = new LinkedList<>();
        }
        //生成逆邻接表
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                //i -> w
                int w = adj[i].get(j);
                // w -> i
                inverseAdj[w].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == false){
                visited[i] = true;
                dfs(i,inverseAdj,visited);
            }
        }

    }

    private void dfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) {
                continue;
            }
            visited[w] = true;
            dfs(w,inverseAdj,visited);
        }
        // 先把 vertex 这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.println("->"+vertex);
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
