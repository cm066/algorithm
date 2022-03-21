package hos100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cm
 * @create 2022/3/15-10:25 下午
 * 两数之和
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] ints = twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 采用hash表，也可以采用双层暴力
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums,int target){
        //key 为nums[i] value 为i
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target-nums[i])){
                map.put(nums[i], i);
            }else {
                return new int[]{map.get(target-nums[i]),i};
            }
        }
        return null;
    }
}
