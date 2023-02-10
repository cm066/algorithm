package com.arr;

public class RemoveDuplicates {
    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums1 = {0, 0};
        int i = removeDuplicates2(nums);
        System.out.println(i);
    }

    //输入：nums = [0,0,1,1,1,2,2,3,3,4]
    //输出：5, nums = [0,1,2,3,4]
    //解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
    public static int removeDuplicates2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = 0, index = 1;
        while (index < nums.length) {
            while (index < nums.length) {
                if (nums[ret] == nums[index]) {
                    index++;
                } else {
                    nums[ret + 1] = nums[index];
                    ret++;
                    index++;
                    break;
                }
            }
        }
        return ret + 1;
    }


    public static int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            //q-p-1 > 0 这样写会有问题，会把第一个去除掉了
            if (nums[p] != nums[q] && q - p > 0) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
