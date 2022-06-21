package arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 */
public class Intersection {

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] intersections = intersections(num1, num2);
        System.out.println(Arrays.toString(intersections));
    }
    public static int[] intersections(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 1 || nums2 == null || nums2.length == 1){
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(1)){
                resSet.add(i);
            }
        }
//        Integer[] res = (Integer[]) resSet.toArray();
//        System.out.println(Arrays.toString(res));
        int[] resArr = new int[resSet.size()];
        int index = 0;
        //将结果几何转为数组
        for (int i : resSet) {
            resArr[index++] = i;
        }
        return resArr;
    }
}
