package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class NextGreaterElements2 {
    public static void main(String[] args) {
        reduceTest();
    }
    public int[] nextGreaterElements(int[] nums) {

        //边界判断
        if(nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        int size = nums.length;
        int[] result = new int[size];//存放结果
        Arrays.fill(result,-1);//默认全部初始化为-1
        Stack<Integer> st= new Stack<>();//栈中存放的是nums中的元素下标
        for (int i = 0; i < size * 2; i++) {
            // size * 2 和 i % size把数组抽象成了一个循环数组，并没有开辟实际的工作空间
            while (!st.isEmpty() && nums[i % size] > nums[st.peek()]){
                result[st.peek()] = nums[i % size];//更新result
                st.pop();//弹出栈顶
            }
            st.push(i % size);
        }
        return result;
    }

    public static void reduceTest() {
        ArrayList<Integer> newList = new ArrayList<>();

        ArrayList<Integer> accResult_ = Stream.of(2, 3, 4)
                .reduce(newList,
                        (acc, item) -> {
                            acc.add(item);
                            System.out.println("item: " + item);
                            System.out.println("acc+ : " + acc);
                            System.out.println("BiFunction");
                            return acc;
                        }, (acc, item) -> new ArrayList<>());
        System.out.println("accResult_: " + accResult_);
    }

}
