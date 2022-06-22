package arr;

import java.util.Stack;

/**
 * @author cm
 * @create 2022/1/5-9:48 下午
 * 接雨水
 */
public class Trap {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] h1 = {4,2,0,3,2,5};
        int trap = trap1(h1);
        System.out.println(trap);
    }
    public int trapStack(int[] height) {
        int size = height.length;

        if (size <= 2) return 0;

        // in the stack, we push the index of array
        // using height[] to access the real height
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        int sum = 0;
        for (int i = 1; i < size; i++) {
            Integer stackTop = stack.peek();
            if (height[i] < height[stackTop]){
                stack.push(i);
            }else {
                //pop up all lower value
                int heightAtIdx = height[i];
                while (!stack.isEmpty() && (heightAtIdx > height[stackTop])){
                    int mid = stack.pop();
                    if (!stack.isEmpty()){
                        int left = stack.peek();
                        int h = Math.max(height[left],height[i]-height[mid]);
                        int w = i - left - 1;
                        int hold = h * w;
                        if (hold > 0) sum += hold;
                        stackTop = stack.peek();
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
    public int trapDP(int[] height) {
        if (height == null || height.length <= 2){
            return 0;
        }
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i],height[i-1] );
        }
        maxRight[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >= 0; i++) {
            maxRight[i] = Math.max(height[i],height[i+1] );
        }
        // 求和
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) sum += count;
        }
        return sum;
    }
    public int trap2(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // 第一个柱子和最后一个柱子不接雨水
            if (i==0 || i== height.length - 1) continue;

            int rHeight = height[i]; // 记录右边柱子的最高高度
            int lHeight = height[i]; // 记录左边柱子的最高高度
            //每次都要去寻找左边和右边的最大值，所以提前先计算好
            for (int r = i+1; r < height.length; r++) {
                //找右边最大的位置 这里有优化的空间
                if (height[r] > rHeight) rHeight = height[r];
            }
            for (int l = i-1; l >= 0; l--) {
                //这一步是在看当前位置的左边是否存在比当前位置大
                if(height[l] > lHeight) lHeight = height[l];
            }
            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0) sum += h;
        }
        return sum;

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
                //这一步就是减出两者之间的差量左边当前的值和左边最大值的差量
                ans += leftMax - height[left];
                left++;
            }else {
                //这一步是是求出当前右边和右边最大值的差量
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
