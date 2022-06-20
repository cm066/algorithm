package arr;



/**
 * @author Administrator
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
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
                //这里没有进行left++，是处理后面移动过来的元素和val的值也是相等
            }else {
                left++;
            }
        }
        return left;
    }
    public int removeElement1(int[] nums, int val) {

        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;

    }
}
