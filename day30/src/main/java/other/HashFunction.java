package other;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author cm
 * @create 2022/4/3-8:48 下午
 * 一致性hash算法，先是不添加虚拟节点
 */
public class HashFunction {
    public static void main(String[] args) {

        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333"};
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("[" + nodes[i] + "]的hash值为" +
                    getHash(nodes[i]) + ", 被路由到结点[" + getServer(nodes[i]) + "]");
        }
    }
    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    /**
     * key表示服务器的hash值，value表示服务器的名称
     */
    private static SortedMap<Long, String> sortedMap = new TreeMap<>();

    /**
     * 程序初始化，将所有的服务器放入sortedMap中
     */
    static
    {
        for (int i = 0; i < servers.length; i++)
        {
            long hash = getHash(servers[i]);
            System.out.println("[" + servers[i] + "]加入集合中, 其Hash值为" + hash);
            sortedMap.put(hash, servers[i]);
        }
        System.out.println();
    }
    public static String getServer(String node){
        Long hash = getHash(node);
        //得到大于这个hash值的所有节点，然后取出里面的第一个节点
        SortedMap<Long, String> subMap = sortedMap.tailMap(hash);
        Long aLong = subMap.firstKey();
        //返回对应的服务器名称
        return subMap.get(aLong);
    }
    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     * 这样的hash算法计算法步骤有点慢？
     */
    private static Long getHash(String str)
    {
        final int p = 16777619;
        long hash = 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }
}
