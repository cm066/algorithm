package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author cm
 * @create 2022/1/16-7:22 下午
 * 84. 柱状图中最大的矩形 困难
 *
输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int[] heights1 = {2,4};
        int i = largestRectangleArea(heights);

        System.out.println(i);
    }
    public static int largestRectangleAreaTWO(int[] heights) {
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            // 双指针遍历的时候，每次都要去找当前位置左边和右边的最小值，这个可以提前弄好
            for (; left>=0; left--) {
                if (heights[left] < heights[i]){
                    break;
                }
            }
            for (; right < heights.length; right++){
                if (heights[right] < heights[i]){
                    break;
                }
            }
            int w = right - left +1;
            int h = heights[i];
            sum = Math.max(sum,w*h);
        }
        return sum;
    }
    public static int largestRectangleAreaDP(int[] heights) {
        int length = heights.length;
        int[] minLeftIndex = new int [length];
        int[] maxRightIndex = new int [length];
        // 记录左边第一个小于该柱子的下标
        minLeftIndex[0] = -1 ;
        for (int i = 1; i < length; i++) {
            int t = i - 1;
            // 这里不是用if，而是不断向左寻找的过程
            while (t >= 0 && heights[t] >= heights[i]){
                t = minLeftIndex[t];
            }
            minLeftIndex[i] = t;
        }
        // 记录每个柱子 右边第一个小于该柱子的下标
        maxRightIndex[length - 1] = length;
        for (int i = length - 2; i >= 0; i--) {
            int t = i + 1;
            //不断向右找到最小的，这两步就是解决双指针每步去查找，用空间换取时间
            while(t < length && heights[t] >= heights[i]) t = maxRightIndex[t];
            maxRightIndex[i] = t;
        }
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int sum = heights[i]*(maxRightIndex[i]-minLeftIndex[i] -1);
            result = Math.max(sum,result);
        }
        return result;
    }
    /**
     * 采用单调栈的思想来解决 这里用到了单调递减栈
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return heights[0];
        }
        int area = 0;
        int[] newHeights = new int[len+2];
        for (int i = 0; i < len; i++) {
            newHeights[i+1] = heights[i];
        }
        len += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1; i < len; i++) {
            //peekLast() 返回栈顶元素但是不移除
            while (heights[stack.peekLast()] > heights[i]){
                int height = heights[stack.removeLast()];
                //这一步其实就是从后往前，然后
                int width = i - stack.peekLast()-1;
                area =Math.max(area,width*height);
            }
            stack.addLast(i);
        }
        return area;
    }

    /**
     * 暴力递归的方法 这个还有问题
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        int ret = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            while (left-1 >= 0 && heights[left-1] >= heights[i]){
              left--;
            }
            while ( right +1 < heights.length && heights[right] >= heights[i]){
               right++;
            }
            ret = Math.max(ret,(right+1-left)*heights[i]);
        }
        return ret;
    }
}
