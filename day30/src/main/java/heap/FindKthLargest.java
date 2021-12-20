package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cm
 * @create 2021/12/20-10:24 下午
 * 第k大的数，可以采用大顶推的方式来实现
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int i = findKthLargest(nums, 2);
        System.out.println(i);
    }
    public static int findKthLargest(int[] nums, int k) {
       Comparator<Integer> comparator = new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o2-o1;
           }
       };
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k-1; i++) {
            queue.poll();
        }
        return queue.poll();
    }
}
