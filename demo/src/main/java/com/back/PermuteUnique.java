package com.back;

import java.util.*;

public class PermuteUnique {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        helper(nums, ans, combine, 0, vis);
        return ans;
    }

    public static void helper(int[] nums, List<List<Integer>> ans, List<Integer> combine, int idx, boolean[] vis) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            combine.add(nums[i]);
            vis[i] = true;
            helper(nums, ans, combine, idx + 1,vis);
            vis[i] = false;
            combine.remove(idx);
        }
    }
}
