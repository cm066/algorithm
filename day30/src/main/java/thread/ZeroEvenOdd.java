package thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author cm
 * @create 2022/3/24-9:51 下午
 */
public class ZeroEvenOdd {

    private int n;
    private Semaphore zeroSema = new Semaphore(1);
    private Semaphore oddSema = new Semaphore(0);//奇数
    private Semaphore evenSema = new Semaphore(0);//偶数
    Semaphore semaphore1;
    Semaphore semaphore2;
    Semaphore semaphore3;
    public ZeroEvenOdd(int n) {
        this.n = n;
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(0);
        semaphore3 = new Semaphore(0);

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSema.acquire();
            printNumber.accept(0);
            if ((i & 1) == 1) {//奇数
                oddSema.release();
            } else {
                evenSema.release();
            }
        }


    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {//偶数 打印偶数 并释放zero的线程
                evenSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }

        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {//奇数，打印奇数，并释放zero的线程
                oddSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }

        }
    }
    public void zero1(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i++){
            semaphore1.acquire();
            printNumber.accept(0);
            if(i % 2 == 0){
                semaphore3.release();
            }else{
                semaphore2.release();
            }
        }
    }

    public void even1(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2){
            semaphore3.acquire();
            printNumber.accept(i);
            semaphore1.release();
        }
    }

    public void odd1(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2){
            semaphore2.acquire();
            printNumber.accept(i);
            semaphore1.release();
        }
    }


    public static void main(String[] args) {
//        IntConsumer intConsumer = i-> System.out.println(i);
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
