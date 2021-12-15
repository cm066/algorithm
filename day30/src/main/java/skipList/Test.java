package skipList;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) {
        //这个是Java中的跳表实现，是有序的可以自己传教compaor比较器进去，也可以不用传进去
        ConcurrentSkipListMap skipList = new ConcurrentSkipListMap();
        skipList.putIfAbsent(1,1);
    }
}
