package tanxin;

/**
 * @author cm
 * @create 2022/1/10-10:39 下午
 * 134.  加油站 中等
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int[] gas1 = {1,2,3,4,5};
        int[] cost1 = {3,4,5,1,2};
        int[] gas2 = {2,3,4};
        int[] cost2 = {3,4,3};
//[3,4,3] [1,2,3,4,5]
//[3,4,5,1,2]
        int i = canCompleteCircuit(gas1, cost1);
        System.out.println(i);
    }
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n){
            int sumOfGas = 0;
            int sumOfCost = 0;
            int cnt = 0;
            while (cnt < n){
                int j = (i+cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas){
                    break;
                }
                cnt++;
            }
            if (cnt == n){
                return i;
            }else {
                //这一步非常的重要，说明之前的位置到当前的位置都是不行的，那说明这之间的任何一个作为起点都是不行的
                i = i+cnt+1;
            }
        }
        return -1;
    }
    /**
     *有问题 超出时间限制 有优化的空间，就是i的位置，不应该是只有加1
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if(gas[i] < cost[i]){
                continue;
            }else {
                int index = 1;
                int j = i;
                int gass = 0;
                int costs = 0;
                while (index <= gas.length){
                    if (j == gas.length){
                        j = 0;
                    }
                    gass = gass+gas[j];
                    costs = costs+cost[j];
                    if (gass >= costs){
                        index++;
                        j++;
                        if (index == cost.length+1){
                            return i;
                        }
                    }else {
                        break;
                    }
                }

            }
        }
        return -1;
    }
}
