package heap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Administrator
 * PriorityQueue priorityQueue = new PriorityQueue();
 * 就是利用堆来实现的
 */
public class Test {
    public static void main(String[] args) {
//        PriorityQueue priorityQueue = new PriorityQueue();
//        Integer a = 1;
//        priorityQueue.offer(a);
//        priorityQueue.remove();
        int[] num = {10,4,8,3,5,1};
        System.out.println("原始数组：");
        System.out.println(Arrays.toString(num));
//        MyHeap<Integer> myHeap = new MyHeap<Integer>(10, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o, Integer t1) {
//                return (o-t1>0)?1:-1;
//            }
//        });
        MyHeap<Integer> myHeap = new MyHeap<>(6);
        for (int i : num) {
            myHeap.add(i);
        }

//        System.out.println(myHeap.getSize());
//        Integer remove = myHeap.remove();
//        System.out.println(remove);
//        System.out.println(myHeap.getSize());
        System.out.println("堆中的元素");
        System.out.println(Arrays.toString(myHeap.toArray(new Object[myHeap.getSize()])));
        System.out.println("排序之后");
        for (int i = 0,length = myHeap.getSize(); i < length; i++) {
            Integer remove = myHeap.remove();
            System.out.print(remove+"\t");
        }
    }
}
