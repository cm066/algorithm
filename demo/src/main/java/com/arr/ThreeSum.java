package com.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,-1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return  res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }

            int l = i+1, r = nums.length-1;
            while (l < r){
                int a = nums[i]+nums[l]+nums[r];
                if (a == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while (l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    while (l < r &&nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                } else if (a > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
