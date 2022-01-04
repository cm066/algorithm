package arr;

import java.util.Arrays;

/**
 * @author cm
 * @create 2022/1/4-9:49 下午
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {1};
        int[] ints = searchRange(nums, 1);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置 思路有问题
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null ||nums.length == 0|| target < nums[0] || target > nums[nums.length-1]){
            return new int[]{-1,-1};
        }
        int left =0 ;
        int right = nums.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] == target){
                left = mid;
                right = mid;
                while (left >= 0 && nums[left] == target){
                    left--;
                }
                while (right < nums.length && nums[right] == target){
                    right++;
                }
                return new int[]{left+1,right-1};
            }else if (nums[mid] < target){
                left = mid +1;
            }else {
                right = mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}
