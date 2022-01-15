package dp;

/**
 * @author cm
 * @create 2022/1/15-10:13 下午
 * 42. 接雨水 困难
 */
public class Trap {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
        System.out.println(trap);
    }

    /**
     * 之前是先找到最高点，然后从左往最高点，然后在从右往左，还有采用的是双指针，现在采用动态规划的思想
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int len = height.length;
        if (len <= 2){
            return 0;
        }
        int[] maxArr = new int[len];
        int max = 0,maxIndex = 0;
        //先找到最大值的坐标
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        //初始化maxArr数组
        maxArr[maxIndex] = height[maxIndex];
        maxArr[0] = height[0];
        maxArr[len-1] = height[len-1];
        for (int i = 1; i < maxIndex; i++) {
            maxArr[i] = Math.max(maxArr[i-1],height[i]);
        }
        for (int i = len-2; i > maxIndex; i--) {
            maxArr[i] = Math.max(height[i],maxArr[i+1]);
        }
        int count = 0;
        for (int i = 0; i < maxArr.length; i++) {
            count += (maxArr[i] - height[i]);
        }
        return count;
    }
}
