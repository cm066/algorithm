package back;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cm
 * @create 2021/12/28-10:04 下午
 */
public class CombinationSum {
    public static void main(String[] args) {

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans  = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return ans;
        }
        List<Integer> combine = new ArrayList<Integer>();
        helper(candidates, target, ans, combine, 0);
        return ans;
    }

    public void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        //直接跳过
        helper(candidates,target,ans,combine,idx+1);
        if (target - candidates[idx] >= 0){
            combine.add(candidates[idx]);
            helper(candidates, target-candidates[idx], ans, combine, idx);
            combine.remove(combine.size()-1);
        }
    }
}
