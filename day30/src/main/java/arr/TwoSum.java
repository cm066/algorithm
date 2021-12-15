package arr;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author cm
 * @create 2021/12/15-10:09 下午
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] ints = twoSum(arr, 9);
        System.out.println(Arrays.toString(ints));
    }

    /**
     *
     * @param nums 数据的数组
     * @param target 目标数
     * @return 没有就返回null，有就返回两个数的下标
     * 这道题的解题思路非常的多，可以采用hashmap存取来，或者是暴力递归的方法来解决 采用hash表就是典型的用空间来换取时间效率
     * 错误思路：这道题是不能用额外的空间，所以采用双指针的方法来解决
     * 因为这道题中的数组并不是有序的所以不能采用双指针移动的办法来解决
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int newAim = target-nums[i];
            if (map.containsKey(newAim)){
                return new int[]{map.get(newAim),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
