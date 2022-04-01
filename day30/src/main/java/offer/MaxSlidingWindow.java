package offer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cm
 * @create 2022/3/30-10:02 下午
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
//        [1,3,-1,-3,5,3,6,7]
//        3
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums1 = {1,-1};
        int[] ints = maxSlidingWindow(nums1, 1);
        System.out.println(Arrays.toString(ints ));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            //这一步就是保证这个窗口内的最大值,如果这个数，比之前的数小，就要把这个数留在这个窗口内，因为它影响这个窗口的值
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ret = new int[nums.length-k+1];
        //因为队列里面保存的是下标，主要是为了保证窗口的大小是否给定的大小，用于后续的判断
        ret[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            //这里的作用就是找到这个滑动窗口范围内的最大值
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            //因为这里保存的数字的下标
//            ret[i-k+1] = nums[deque.getFirst()];

            ret[i-k+1] = nums[deque.peekFirst()];
        }
        return ret;
    }
}
