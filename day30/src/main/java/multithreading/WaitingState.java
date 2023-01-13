package multithreading;

/*** @author binghe * @version 1.0.0 * @description 线程在Warting上等待 */
public class WaitingState implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (WaitingState.class) {
                try {
                    WaitingState.class.wait();
                    System.out.println(2222);
                } catch (InterruptedException e) {
                    System.out.println(1111);
                    e.printStackTrace();
                }
            }
        }
    }
}