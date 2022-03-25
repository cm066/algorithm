package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author cm
 * @create 2022/3/24-7:56 下午
 */
public class OrderFooPrintSemaphore {
    private volatile int flag = 1;
    private final Object object = new Object();
    private final Semaphore first = new Semaphore(0);
    private final Semaphore second = new Semaphore(0);
    private final CountDownLatch first1 = new CountDownLatch(1);
    private final CountDownLatch second1 = new CountDownLatch(1);
    public OrderFooPrintSemaphore() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        first.release();
        // printFirst.run() outputs "first". Do not change or remove this line.
        first1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first1.await();
        first.release();
        printSecond.run();
        second.release();
        // printSecond.run() outputs "second". Do not change or remove this line.
        second1.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second1.await();
        second.acquire();
        printThird.run();
        // printThird.run() outputs "third". Do not change or remove this line.
    }
}
