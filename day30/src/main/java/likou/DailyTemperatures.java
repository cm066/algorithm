package likou;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cm
 * @create 2022/3/21-9:32 下午
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 *
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 单调栈
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {34,80,80,34,34,80,80,80,80,34};
        int[] ints = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 单调递增栈的来解决的
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperaturesSingleStack(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            int temperature = temperatures[i];
            //这一步就是遇到比大的数，然后就弹出前面小的数出来
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
//            stack.add()
            stack.push(i);
        }
        return ans;
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ret = new int[len];
        int index = len-1;
        ret[index] = 0;
        while (index > 0){
            if (temperatures[index-1] < temperatures[index]){
                ret[--index] = 1;
            }else {

                int i = index+1;
                while (i < len){
                    if (temperatures[i] <= temperatures[index-1]){
                        i++;
                    }else {
                        ret[index-1] = i-index+1;
                        break;
                    }
                }
                index--;
//                while (i < len && temperatures[i] < temperatures[index-1]){
////                    if ()
//                    i++;
//                }
//                ret[--index] = i-index;
            }
        }
        return ret;
    }
}
