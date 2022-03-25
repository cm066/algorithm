package other;

import java.util.HashMap;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.Executors;

/**
 * @author cm
 * @create 2022/3/21-10:21 下午
 */
public class TestHashMap {
    public static void main(String[] args) {
//        Executors.newFixedThreadPool(5);
//        Executors.newSingleThreadExecutor();
//        Executors.newCachedThreadPool();
//        Executors.newScheduledThreadPool();
        HashMap<Long,String> map = new HashMap<>();
        map.put(0L,"2");
        map.put(1L,"3");
        map.put(90000L,"1");
        System.out.println(1L&15);
//        Long key ;
//        int h ;
//        int b = 0;
//
////        System.out.println(b);
////        System.out.println("---------");
//        for (int i = 1; i < 5; i++) {
//            int num = new Random().nextInt(10000);
//            key = Long.parseLong(num+"");
////            System.out.println(key);
//            b = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//            System.out.println(b+"--------");
//            map.put(key,i+"");
//            System.out.println(key+":"+i);
//        }
//        System.out.println("---------");
//        for (Long aLong : map.keySet()) {
//            System.out.println(aLong+":"+map.get(aLong));
//        }
//        Stack<Integer> stack = new Stack<>();
//        stack.add(1);
    }
}
