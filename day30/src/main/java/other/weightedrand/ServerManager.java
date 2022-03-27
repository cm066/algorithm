package other.weightedrand;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author cm
 * @create 2022/3/26-1:05 下午
 */
public class ServerManager {
    public volatile static Map<String, Integer> serverMap = new TreeMap<>();

    static {
        serverMap.put("192.168.1.1", 1);
        serverMap.put("192.168.1.2", 2);
        serverMap.put("192.168.1.3", 3);
        serverMap.put("192.168.1.4", 4);
    }
}
