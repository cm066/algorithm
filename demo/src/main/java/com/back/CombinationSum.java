package com.back;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

    }

    /**
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * <p>
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        helper(ret, combine, candidates, 0, target);
        return ret;
    }

    public void helper(List<List<Integer>> ret, List<Integer> combine, int[] candidates, int idx, int target) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ret.add(new ArrayList<>(combine));
            return;
        }
        helper(ret, combine, candidates, idx + 1, target);
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            helper(ret, combine, candidates, idx, target - candidates[idx]);
            combine.remove(combine.size() - 1);
        }
    }
}
