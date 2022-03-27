package other;

import heap.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author cm
 * @create 2022/3/13-8:22 下午
 * 今天遇到这样一个线程池的问题：就是一个核心线程数为5，队列为10，
 */
public class ThreadPool {
    private static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
//        Future<Object> submit = pool.submit(new Callable<Object>() {
//        });
        pool.execute(()->{
            System.out.println(1);
            while (true){}
        });
        pool.execute(()->{
            System.out.println(2);
            while (true){}
        });
        pool.execute(()->{
            System.out.println(3);
            while (true){}
        });
        pool.execute(()->{
            System.out.println(4);
            while (true){}
        });
        pool.execute(()->{
            System.out.println(5);
            try {
//                Thread.sleep(20000);
//                System.out.println("第5个执行完毕");
                test();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(5000);
        pool.execute(()->{
            System.out.println(6);
            try {
                test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(333);
    }
    public static void  test() throws InterruptedException {
        synchronized (obj){
            Thread.sleep(5000);
            System.out.println("第5个执行完毕");
//            obj.wait();
        }

    }
}
