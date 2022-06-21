package arr;


import java.util.HashMap;
import java.util.Map;

/**
 * 第454题.四数相加II
 * 力扣题目链接(opens new window)
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 *
 * 例如:
 *
 * 输入: A = [ 1, 2] B = [-2,-1] C = [-1, 2] D = [ 0, 2] 输出: 2 解释: 两个元组如下:
 *
 * (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 思路:就是把四数之和转化为两数和 + 两数和  先把前两个数组的和计算好放在map里面
 */
public class FourSumCount {
    public static void main(String[] args) {

    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int i1 : nums2) {
                temp = i + i1;
                if (map.containsKey(temp)) {
                    //这里不用考虑重复的所以把所有情况都保存下来，如果存在了那就加1
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i+j;
                if (map.containsKey(0 - temp)){
                    // 这里就是取出结果
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }
}
