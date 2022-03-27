package other;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cm
 * @create 2022/3/26-11:01 上午
 * 随机权重算法
 */
public class WeightedRand {
    private static int sumWeight = 0;
    private int[] pre;
    public static void main(String[] args) throws Exception {
        test();
//        int[] input = {4,1,2,3};
//        WeightedRand rand = new WeightedRand(input);
//        int[] result = new int[input.length];
//        int runCount = 1000 * input.length;
//        for (int i = 0; i < runCount; i++) {
//            int next = rand.next();
//            if (next < 0 || next > input.length) {
//                throw new Exception("unexpected rand value: " + next);
//            }
////            System.out.println(next);
//            result[next]++;
//        }
//
//        int sum = 0;
//        for (int j : input) {
//            sum += j;
//        }
//        for (int i : result) {
//            System.out.println(i);
//        }
//        for (int i = 0; i < input.length; i++) {
//            double realP = result[i] / (double) runCount;
//            double expectedP = input[i] / (double) sum;
//            System.out.println(realP);
//            if (realP - expectedP > 0.1 || realP - expectedP < -0.1) {
//                throw new Exception("unexpected probability " + realP + " for value " + i + ", expected is " + expectedP);
//            }
//        }
    }
    public static void test() throws Exception {
        int[] input = {4,1,2,3};
        WeightedRand.WeightedRandInit(input);
        int[] result = new int[input.length];
        int runCount = 1000 * input.length;
        for (int i = 0; i < runCount; i++) {
            int next = WeightedRand.next1();
            if (next < 0 || next > input.length) {
                throw new Exception("unexpected rand value: " + next);
            }
            result[next]++;
        }
        int sum = 0;
        for (int j : input) {
            sum += j;
        }
        for (int i = 0; i < input.length; i++) {
            double realP = result[i] / (double) runCount;
            double expectedP = input[i] / (double) sum;
            System.out.println(realP);
            if (realP - expectedP > 0.1 || realP - expectedP < -0.1) {
                throw new Exception("unexpected probability " + realP + " for value " + i + ", expected is " + expectedP);
            }
        }
    }
    public WeightedRand(int[] input) {
        // show me your code
        pre = new int[input.length];
        pre[0] = input[0];
        sumWeight = input[0];
        for (int i = 1; i < input.length; i++) {
            sumWeight += input[i];
            pre[i] = pre[i-1]+input[i];
        }
        int i =0;
    }

    public int next() {
        // show me your code, please delete the next line
        int x = (int) (Math.random() * sumWeight) + 1;
        return binarySearch(x);
//        return -1;
    }


    private int binarySearch(int x) {
        int low = 0, high = pre.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    static List<Integer> range;
    public static void WeightedRandInit(int[] input) {
       range = new ArrayList<>();
        for (int i =0; i <input.length;i++) {
            sumWeight += input[i];
            for (int j = 0; j < input[i]; j++) {
                range.add(i);
            }
        }
    }

    public static int next1() {
        // show me your code, please delete the next line
        int x = (int) (Math.random() * sumWeight);

        return range.get(x);
//        return -1;
    }
}
