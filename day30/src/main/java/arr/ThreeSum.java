package arr;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
public class ThreeSum {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0|| nums[0] > 0 || len < 3){
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i >0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    //这两步主要是为了去重操作的
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right &&nums[right] == nums[right-1]){
                        right--;
                    }
                    result.add(list);
                    left++;
                    right--;
                }else if (sum < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }
}
