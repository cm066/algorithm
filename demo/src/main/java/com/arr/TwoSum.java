package com.arr;

import java.util.Arrays;
import java.util.HashMap;

// 两数之和
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] ints = twoSum(nums, 90);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        // 因为nums不是有序的所以不能通过两头还查找，不然能实现O(1)的空间复杂度
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])){
                // 说明已经存在了
                return new int[]{map.get(target-nums[i]),i};
            }else {
                map.put(nums[i], i);
            }
        }
        // 到这里说明没有找到
        return new int[]{};
    }
}
