package arr;

/**
 * @author cm
 * @create 2022/1/5-9:48 下午
 * 接雨水
 */
public class Trap {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] h1 = {4,2,0,3,2,5};
        int trap = trap1(height);
        System.out.println(trap);
    }

    /**
     * 采用双指针点方法来解决
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length -1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if (height[left] < height[right]){
                ans += leftMax - height[left];
                left++;
            }else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    /**
     * 这个方法是先找到最高点，然后分为左半部分和右半部分
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height.length == 0){
            return 0;
        }
        int result = 0;
        int maxValue = -1;
        int maxAddr = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= maxValue){
                maxValue = height[i];
                maxAddr = i;
            }
        }
        //先处理左半部分
        for (int left = 0; left < maxAddr; left++) {
            for (int j = left+1; j <= maxAddr; j++) {
                if (height[j] < height[left]){
                    result = result+(height[left]-height[j]);
                }else {
                    left = j;
                }
            }
        }
        //处理右半部分
        for (int right = height.length-1; right > maxAddr; right--) {
            for (int j = right-1; j >= maxAddr; j--) {
                if (height[j] < height[right]){
                    result = result+(height[right]-height[j]);
                }else {
                    right = j;
                }
            }
        }
        return result;
    }
}
