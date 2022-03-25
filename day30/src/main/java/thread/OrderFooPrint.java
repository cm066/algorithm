package thread;

/**
 * @author cm
 * @create 2022/3/24-7:56 下午
 */
public class OrderFooPrint {
    private volatile int flag = 1;
    private final Object object = new Object();
    public OrderFooPrint() {
        OrderFooPrint orderFooPrint = new OrderFooPrint();
        new Thread(()->{
            try {
                orderFooPrint.first(()->{});
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object){
            while (flag != 1){
                object.wait();
            }
            printFirst.run();
            flag = 2;
            object.notifyAll();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object){
            while (flag != 2){
                object.wait();
            }
            printSecond.run();
            flag = 3;
            object.notifyAll();
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
