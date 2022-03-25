package thread;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author cm
 * @create 2022/3/24-10:24 下午
 */
public class ZeroEvenOdd1 {
    private int n;
    private volatile int flag = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();
    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while (flag != 0){
                    zero.await();
                }
                printNumber.accept(0);
                if ((i&1) != 0){
                    flag = 1;
                    odd.signal();
                }else {
                    flag = 2;
                    even.signal();
                }

            }finally {
                lock.unlock();
            }
        }


    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            lock.lock();
            try {
                while (flag != 2){
                    even.await();
                }
                printNumber.accept(i);
                flag = 0;
                zero.signal();
            }finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            lock.lock();
            try {
                while (flag != 1){
                    odd.await();
                }
                printNumber.accept(0);
                flag = 0;
                zero.signal();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        IntConsumer intConsumer1 = i -> System.out.println(i);
        ZeroEvenOdd evenOdd = new ZeroEvenOdd(5);
        Thread thread = new Thread(() -> {
            try {
                evenOdd.zero(intConsumer1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                evenOdd.even(intConsumer1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                evenOdd.odd(intConsumer1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread3.start();
        thread2.start();
    }
}
