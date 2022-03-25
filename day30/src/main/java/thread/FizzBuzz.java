package thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author cm
 * @create 2022/3/24-10:39 下午
 */
public class FizzBuzz {
    private int n;
    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzAnd = new Semaphore(0);
    private Semaphore number = new Semaphore(1);
    private volatile boolean flag = true;
    public FizzBuzz(int n) {
        this.n = n;
    }
    // n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= 15; i++) {
            if (i % 3 == 0 && i % 5 != 0){
                fizz.acquire();
                printFizz.run();
                number.release();
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= 15; i++) {
            if (i % 3 != 0 && i % 5 == 0){
                buzz.acquire();
                printBuzz.run();
                number.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= 15; i++) {
            if (i % 3 == 0 && i % 5 == 0){
                fizzAnd.acquire();
                printFizzBuzz.run();
                number.release();
            }
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n ; i++) {
            number.acquire();
            if (i % 3 == 0 && i % 5 == 0){
                fizzAnd.release();
            }else if (i % 3 == 0 && i % 5 != 0){
                fizz.release();
            }else if (i % 3 != 0 && i % 5 == 0){
                buzz.release();
            }else {
                printNumber.accept(i);
                number.release();
            }

        }
    }

    public static void main(String[] args) {
        IntConsumer intConsumer = i -> System.out.println(i);
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        new Thread(()->{
            try {
                fizzBuzz.number(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                fizzBuzz.fizz(()->{
                    System.out.println("fizz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                fizzBuzz.buzz(()->{
                    System.out.println("buzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                fizzBuzz.fizzbuzz(()->{
                    System.out.println("fizzbuzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
