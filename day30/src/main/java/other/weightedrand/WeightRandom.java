package other.weightedrand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @author cm
 * @create 2022/3/26-1:06 下午
 */
public class WeightRandom {

    /**
     * 加权随机算法 这个是不考虑空间复杂度的情况下，时间是最优的
     * @return
     */
    public static String getServer() {
        ArrayList<String> serverList = new ArrayList<>();
        Set<String> serverSet = ServerManager.serverMap.keySet();
        Iterator<String> iterator = serverSet.iterator();

        Integer weightSum = 0;
        while(iterator.hasNext()){
            String server = iterator.next();
            Integer weight = ServerManager.serverMap.get(server);
            weightSum += weight;
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }
        Random random = new Random();
        String server = serverList.get(random.nextInt(weightSum));
        return server;
    }


}
