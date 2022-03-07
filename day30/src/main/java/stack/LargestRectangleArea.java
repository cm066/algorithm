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

    /**
     * 采用单调栈的思想来解决
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
     * 暴力递归的方法
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
