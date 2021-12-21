package heap;

import java.util.*;

/**
 * @author cm
 * @create 2021/12/21-11:12 下午
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] num = {4,1,-1,2,-1,2,3};
        int[] ints = topKFrequent(num, 2);
        System.out.println(Arrays.toString(ints));

    }
    /**
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length == 0){
            return null;
        }
        Map<Integer,Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        Set<Map.Entry<Integer, Integer>> entries = occurrences.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int num = entry.getKey();
            int sum = entry.getValue();
            if (queue.size() == k){
                if (queue.peek()[1] < sum){
                    queue.poll();
                    queue.offer(new int[]{num, sum});
                }
            }else {
                queue.offer(new int[]{num,sum});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
