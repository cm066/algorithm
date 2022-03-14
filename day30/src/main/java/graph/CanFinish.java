package graph;

import java.util.*;

/**
 * @author cm
 * @create 2022/3/14-9:13 下午
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 * 问题类型：要解决这种有依赖关系的可以把它转化为一个有向无环图，就比如这到题如果形成环了，就说明这个是无法解决的
 */
public class CanFinish {
    //用邻接表来表示图
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    //表示入度的次数
    int[] indeg;
    public static void main(String[] args) {

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        //构建图
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0){
                dfs(i);
            }
        }
        return valid;
    }
    public void dfs(int u){
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0){
                //这一步就体现出了深度优先遍历
                dfs(v);
                if (!valid){
                    return;
                }
            }else if (visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
    public boolean canFinishGuan(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0){
                //将入度为0的先加入到队列里面，入度为0表示，它不依赖其他的
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()){
            ++visited;
            int u = queue.poll();
            //以这个点出发，遍历它所能到达的点
            for (int v : edges.get(u)) {
                --indeg[v];
                //这一步就体现了要学习它之前，它所需要学习的课程已经完成了
                if (indeg[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
