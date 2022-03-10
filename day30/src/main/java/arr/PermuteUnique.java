package arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cm
 * @create 2022/3/10-9:21 下午
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class PermuteUnique {
    //这个是用于判断是否已经访问过了
    boolean[] vis;
    public static void main(String[] args) {

    }

    /**
     * 采用回溯的方法来解决这个问题
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(ret,new ArrayList<>(),nums,0);
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        return ret;
    }

    public void helper(List<List<Integer>> ret,List<Integer> path,int[] nums,int index){
        if (index == nums.length){
            //这里为什么要new ArrayList<>(path) 是因为path是一个引用
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //因为不能有重复的所以这里要进行判断是否已经范围过了
//            i > 0 && nums[i] == nums[i - 1] && !vis[i - 1] 这里就相当于是这样的 比如i= 0的时候递归回来1，1，2
            //当等
            if (vis[i] || i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]){
                continue;
            }
            path.add(nums[i]);
            vis[i] = true;
            helper(ret, path, nums, index+1);
            vis[i] = false;
            path.remove(index);
        }
    }
}
