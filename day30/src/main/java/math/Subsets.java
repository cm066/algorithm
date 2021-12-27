package math;


import java.util.ArrayList;
import java.util.List;

/**
 * @author cm
 * @create 2021/12/26-10:09 下午
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets(nums);

    }

    /**
     * 递归
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for (int num : nums) {
            List<List<Integer>> newSubsets  = new ArrayList<>();
            for (List<Integer> subset : result) {
                List<Integer> newSubset =  new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            result.addAll(newSubsets);
        }
        return result;
    }
}
