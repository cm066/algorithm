package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cm
 * @create 2022/3/24-7:56 下午
 */
public class OrderFooPrint1 {
    private volatile int flag = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Object object = new Object();
    private final Condition condition1 = lock.newCondition();
    public OrderFooPrint1() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1){
                lock.wait();
            }
            printFirst.run();
            flag = 2;
            lock.notifyAll();
        }finally {
            lock.unlock();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public void second(Runnable printSecond) throws InterruptedException {
       lock.lock();
       try {
           while (flag != 2){
               condition1.await();
           }
       }finally {
           lock.unlock();
       }
        // printSecond.run() outputs "second". Do not change or remove this line.

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object){
            while (flag != 3){
                object.wait();
            }
            printThird.run();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
    }
}
