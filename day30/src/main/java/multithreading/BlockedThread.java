package multithreading;

/*** @author binghe * @version 1.0.0 * @description 加锁后不再释放锁 */
public class BlockedThread implements Runnable {
    @Override
    public void run() {
        synchronized (BlockedThread.class) {
            while (true) {
                WaitingTime.waitSecond(100);
            }
        }
    }
}