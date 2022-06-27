package back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合问题
 */
public class Combine {

    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     *
     * 说明：
     *
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
     *
     * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
     * @param targetSum
     * @param k
     * @param startIndex
     * @param sum
     */
    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        if (sum > targetSum){
            return;
        }
        if (k == path.size()){
            if (targetSum == sum){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum,k,i+1,sum);
            path.removeLast();
            sum -= i;
        }

    }

    public List<List<Integer>> combine(int n, int k) {

        combineHelper(n, k, 1);
        return result;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private void combineHelper(int n, int k, int startIndex){
        if (k == path.size()){
            result.add(new ArrayList<>(path));
            return;
        }
        /**
         * n - (k - path.size() 这一步是进行了优化的 比如 n=4 ,k=4的时候，已经有一个元素进去的时候，就已经不能把第二元素当做起点，因为元素的个数不够了
         *
         * 接下来看一下优化过程如下：
         *
             * 已经选择的元素个数：path.size();
             *
             * 还需要的元素个数为: k - path.size();
             *
             * 在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
             *
             * 为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
             *
             * 举个例子，n = 4，k = 3， 目前已经选取的元素为0（path.size为0），n - (k - 0) + 1 即 4 - ( 3 - 0) + 1 = 2。
             *
             * 从2开始搜索都是合理的，可以是组合[2, 3, 4]。
         *
         * 这里大家想不懂的话，建议也举一个例子，就知道是不是要+1了
         *
         * for (int i = startIndex; i <= n; i++) {
         *
         * for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) // i为本次搜索的起始位置
         */
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            combineHelper(n,k,i+1);
            path.removeLast();
        }
    }
}
