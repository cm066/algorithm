package back;

import org.jetbrains.annotations.Nls;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cm
 * @create 2021/12/28-10:39 下午
 * 全排列
 */
public class Permute {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        if (nums == null){
            return ans;
        }
        helper(nums,0,ans,combine);
        return ans;
    }

    private void helper(int[] nums, int i, List<List<Integer>> ans, List<Integer> combine) {
        if (i == nums.length){
            ans.add(new ArrayList<>(combine));
            return;
        }
        combine.add(nums[i-1]);
        for (int j = 0; j < nums.length; j++) {
            combine.add(nums[i]);
            helper(nums,i+1,ans,combine);
            combine.remove(combine.size()-1);
        }
    }
}
