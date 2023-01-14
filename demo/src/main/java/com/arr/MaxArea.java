package com.arr;

public class MaxArea {
    public static void main(String[] args) {
        int[] ints = {1,8,6,2,5,4,8,3,7};
        int i = maxArea(ints);
        System.out.println(i);
    }

    /**
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int l =0, r = height.length-1;
        int max = 0;
        // 双指针的方式来从两侧往中间滑动
        while (l <= r){
            int h = (height[l] > height[r]?height[r--] : height[l++])*(r-l+1);
            max = Math.max(max,h);
        }
        return max;
    }

}
