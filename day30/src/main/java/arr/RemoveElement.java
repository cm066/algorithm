package arr;



/**
 * @author Administrator
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4};
        int i = removeElement(nums, 2);
        System.out.println(i);
    }
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0 ){
            return 0;
        }
        int left = 0;
        int right = nums.length;
        while (left < right){
            if (nums[left] == val){
                nums[left] = nums[right-1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }
}
