package multithreading;

/*** @author binghe * @version 1.0.0 * @description 线程的各种状态，测试线程的生命周期 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        // todo wait原理解析 https://www.jianshu.com/p/6b9f260470a2  博客主 ：https://www.jianshu.com/u/657c611b2e07
        ThreadLocal threadLocal = new ThreadLocal();
//        threadLocal.set();
        new Thread(new WaitingTime(), "WaitingTimeThread").start();
//        new Thread(new WaitingState(), "WaitingStateThread").start();
        Thread waitingStateThread = new Thread(new WaitingState(), "WaitingStateThread");
        waitingStateThread.start();
        Thread.sleep(2000);
        waitingStateThread.interrupt();
//        waitingStateThread.start();
//        waitingStateThread.start();
        //BlockedThread-01线程会抢到锁，BlockedThread-02线程会阻塞
        new Thread(new BlockedThread(), "BlockedThread-01").start();
        new Thread(new BlockedThread(), "BlockedThread-02").start();
    }
}