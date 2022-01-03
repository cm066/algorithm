package back;

import org.jetbrains.annotations.Nls;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author cm
 * @create 2021/12/28-10:39 下午
 * 全排列
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {0,1};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    /**
     * 还有问题
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> combine = new ArrayList<>();
        if (nums == null){
            return ans;
        }
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] use = new boolean[len];
        dfs(nums,len,0,ans,path,use);
//        helper(nums,0,ans,combine);
        return ans;
    }

    /**
     * 回溯就是根据不同的状态和回退上一步的操作来执行的
     * @param nums
     * @param len
     * @param depth
     * @param ans
     * @param path
     * @param use
     */
    private static void dfs(int[] nums, int len, int depth, List<List<Integer>> ans, Deque<Integer> path, boolean[] use) {
        if (depth == len){
            //说明到最后一层了，
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (use[i]){
                continue;
            }
            path.add(nums[i]);
            use[i] = true;
            dfs(nums, len, depth+1, ans, path, use);
            //回退到上一步，和之前坐相反到操作
            path.removeLast();
            use[i] = false;
        }
    }

    private static void helper(int[] nums, int i, List<List<Integer>> ans, List<Integer> combine) {
        if (i == nums.length){
            ans.add(new ArrayList<>(combine));
            return;
        }
        //combine.add(nums[i-1]);
        for (int j = 0; j < nums.length; j++) {
            combine.add(nums[i]);
            helper(nums,i+1,ans,combine);
            combine.remove(combine.size()-1);
        }
    }
}
