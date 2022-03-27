package thread;

import java.util.concurrent.*;

/**
 * @author cm
 * @create 2022/3/26-3:48 下午
 */
public class MyThreadPool {
    private int maxNumThread;
    private BlockingQueue<FutureTask> workQueue;
    private workerThread[] workerThreads;
    private class  workerThread extends Thread{
        @Override
        public void run() {
            //一直从工作队列中取任务出来执行
            for (; ;) {
                try {
                    FutureTask task = workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public <E> FutureTask<E> submit(Callable<E> callable) {
        if (callable == null){
            throw  new NullPointerException();
        }
        FutureTask<E> futureTask = new FutureTask(callable);
        try {
            workQueue.put(futureTask);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return futureTask;
    }
    public MyThreadPool(int max){
        this.maxNumThread = max;
        this.workQueue = new LinkedBlockingQueue<>();
        initWorkThread();
    }

    private void initWorkThread() {
        this.workerThreads = new workerThread[this.maxNumThread];
        for (int i = 0; i < maxNumThread; i++) {
            workerThreads[i] = new workerThread();
            workerThreads[i].start();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(2);
        Callable<Integer> callable = new Callable() {
            int n = 10;

            @Override
            public Integer call() throws Exception {
                return n--;
            }
        };
        FutureTask<Integer> futureTask1 = myThreadPool.submit(callable);
        FutureTask<Integer> futureTask2 = myThreadPool.submit(callable);
        FutureTask<Integer> futureTask3 = myThreadPool.submit(callable);
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        System.out.println(futureTask3.get());

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(callable);
    }
}
