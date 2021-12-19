package arr;

import java.util.Arrays;

/**
 * @author cm
 * @create 2021/12/19-9:15 下午
 * 数组的下一个排列
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        int[] nums1 = {1,5,1};
        nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 解题思路从后往前若找到一个比自己小的然后交换，若没有找到比自己小的
     * 就说明交换了位置，也没有比现在大的数，所以就直接将它倒过来即可 这种思路只适合找到任意一个比这个排列大的，但是题目中
     * 是下一个，
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1){
            return;
        }
        int i = nums.length - 2;
        while (i >=0 && nums[i] >= nums[i+1]){
            i--;
        }
        //退出上面循环的适合还要判断一下，i的值，如果i的值不大于0，说明没有找到合适的值，然后直接进行倒叙即可
        //若是大于0的，说明找到这个小的了，然后在从后往前找到第一个大于的数，然后进行交换，交换后从交换的位置到最后进行排序操作
        if (i >= 0){
            int j = nums.length -1;
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
