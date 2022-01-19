package slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author cm
 * @create 2022/1/19-9:32 下午
 * 209. 长度最小的子数组 中等 滑动窗口解决
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2,3,7,2,4,3};
//        11[1,2,3,4,5]
        int[] nums1 = {1,2,3,4,5};
        int i = minSubArrayLenSlidingWindow(11,nums1);
        int i1 = minSubArrayLen(11, nums1);
        System.out.println(i1);
        System.out.println(i);
    }


    /**
     * 找出这个数组中子数组和大于等于目标数的长度，暴力解决办法，以每个数为开始
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null ||nums.length == 0){
            return 0;
        }
        int ret = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target){
                    ret = Math.min(ret,(j-i+1));
                }
            }
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
    public static int minSubArrayLenSlidingWindow(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n){
            sum += nums[end];
            while (sum >= target){
                ans = Math.min(ans,(end-start+1));
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    /**
     * 这个解法只适合是子序列的时候 而且只是等于的时候
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLenSlidingWindow1(int target, int[] nums) {
        if (nums == null ||nums.length == 0){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        //表示当前窗口里面的值是多少
        int sum = 0;
        if (nums[0] < target){
            sum += nums[0];
            //表示的位置
            stack.add(0);
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            stack.add(i);
            if ( sum == target){
                Integer start = stack.removeFirst();
                ret = Math.min(ret,(i-start+1));
                sum -= nums[start];
            }else if (sum > target){
                //主要还是在这里，当当前窗口的值大于目标值的时候，就一直弹出当前窗口的第一个值
                //当窗口里面的值小于等于的时候就跳出去
                while (!stack.isEmpty() && sum > target){
                    Integer start= stack.removeFirst();
                    sum -= nums[start];
                    if (sum == target){
                        start= stack.removeFirst();
                        ret = Math.min(ret,(i-start+1));
                        sum -= nums[start];
                        break;
                    }
                }
            }

        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}
