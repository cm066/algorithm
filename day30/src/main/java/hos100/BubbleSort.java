package hos100;

/**
 * @author cm
 * @create 2022/3/15-10:50 下午
 *冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {

    }

    /**
     * 1、从未排序的数组中进行比较相邻两个数的交互 把最大的往后移动
     * @param nums
     */
    public static void bubbleSort(int[] nums){
        if (nums == null || nums.length ==0){
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]){
                    Swap.swap(nums,j,j+1);
                }
            }
        }
    }
}
