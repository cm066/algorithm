package arr;

/**
 * @author cm
 * @create 2021/12/19-10:49 下午
 * 一个有序数组在下标3的位置进行旋转了，然后设计一个log(n）的算法，找出这个数组中有没有这个数
 * log(n)的时间复杂度要不是树，要不就是二分查找，这个题的主要难度在于是在一定位置旋转过的
 */
public class Search {
    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        int[] nums1 = {3,1};
        int search = search(nums1, 1);
        System.out.println(search);
    }

    /**
     * 这道题采用局部有序的思想来解决这个问题，就是先判断中间的数和第一个数来决定是左边还是右边
     * 上面那个思路还是有问题，这个主要还是边界不太好确定
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return nums[0] == target?0:1;
        }
        int n = nums.length;
        int l = 0;
        int r = n-1;
        //4,5,6,7,0,1,2 0
        while (l <= r){
            int mid = l + (r -l)/2;
            if (nums[mid] == target) {
                return mid;
            }
            //这里说明左半部分是有序的，然后现在就只需要判读目标数是否在这个区间了 左半部分确定好了，现在需要考虑又半部分
            //还是败在了考虑细节的问题上，对于局部有序的二分查找，边界值一定要考虑清楚
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    r = mid -1;
                }else {
                    l = mid+1;
                }
            }else{
                if (target > nums[mid] && target <= nums[n-1]){
                    l = mid+1;
                }else {
                    r = mid -1;
                }
            }
        }
        return -1;

    }
    /**
     * 这样写有问题
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int k = 3;
        int start = nums[0];
        int left = 0;
        int right = k;
        if (target < start){
            left = k+1;
            right = nums.length-1;
        }
        while (left < right){
            //这样写是防止溢出
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }
}
