package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author cm
 * @create 2022/3/26-2:04 下午
 */
public class ParallelTaskExecutor {
    private volatile int maxThreadNum;
    private volatile int  workCount;
    private BlockingQueue<Runnable> workQueue;
    private Worker[] workers;

    public static void main(String[] args) throws Exception {
        testParallelTaskExecutor();
    }
    private class  Worker extends Thread{

        @Override
        public void run() {
            try {
                System.out.println(1111);
                Runnable take = workQueue.take();
                take.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * @param capacity 最多可同时执行的任务个数
     */
    public ParallelTaskExecutor(int capacity) {
        // show me your code here
        //最大线程数
        this.maxThreadNum = capacity;
        this.workCount = 0;
        this.workQueue = new LinkedBlockingQueue<>(1024);
        initWorkers();
    }
    void initWorkers() {
        workers = new Worker[maxThreadNum];
        for (int i = 0; i < maxThreadNum; i++) {
            workers[i] = new Worker();
            workers[i].start();
        }
    }
    /**
     * 异步执行任务, 返回 Future 对象
     *
     * @param callable 要执行的任务
     * @param <T>      任务的返回值类型
     * @return 返回一个 Future, 任务执行完成时其状态变更为 Done.
     */
    public <T> Future<T> submit(Callable<T> callable) throws InterruptedException {
        // show me your code here, please delete the following line.
        if (callable == null){
            throw new NullPointerException();
        }
        FutureTask futureTask=new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    public void execute(Runnable command) throws InterruptedException {
        if (command == null) {
            throw new NullPointerException();
        }
        if (workCount < maxThreadNum){
            workQueue.put(command);
        }else {
            workQueue.put(command);
        }
    }
    /**
     * 系统开始执行时间
     */
    private static long startTime;

    /**
     * 创建一个虚拟的任务
     *
     * @param wait        指定任务耗时, 毫秒
     * @param shouldThrow 指定任务是否抛出异常, 如果为 true, 任务将抛出一个 Exception
     * @return 返回一个虚拟任务, 在开始执行后大约 wait 毫秒后执行完毕
     */
    private static Callable<Integer> createCallable(long wait, boolean shouldThrow) {
        return () -> {
            Thread.sleep(wait);
            long costTime = (System.currentTimeMillis() - startTime);
            // 以 100 为单位向下取整, 屏蔽精度对结果的影响.

            long expectedCostTime = costTime - (costTime % 100);
            System.out.println(expectedCostTime);
            if (shouldThrow) {
                throw new Exception(Long.toString(expectedCostTime));
            }
            return (int) expectedCostTime;
        };
    }

    private static void testParallelTaskExecutor() throws Exception {
        ParallelTaskExecutor pool = new ParallelTaskExecutor(2);
        List<String> expectedResults = Arrays.asList(
                "RETURN: 100",
                "RETURN: 200",
                "THROW: java.lang.Exception: 300",
                "RETURN: 400",
                "RETURN: 600",
                "RETURN: 700"
        );

        List<String> actualResults = new ArrayList<>();

        startTime = System.currentTimeMillis();
        List<Future<Integer>> futureList = new ArrayList<>();
        futureList.add(pool.submit(createCallable(101, false)));
        futureList.add(pool.submit(createCallable(202, false)));
        futureList.add(pool.submit(createCallable(203, true)));
        futureList.add(pool.submit(createCallable(204, false)));
        futureList.add(pool.submit(createCallable(305, false)));

        for (Future<Integer> future : futureList) {
            try {
                Integer v = future.get();
                actualResults.add("RETURN: " + v.toString());
            } catch (Exception e) {
                actualResults.add("THROW: " + e.getMessage());
            }
        }

        Future<Integer> anotherTask = pool.submit(createCallable(106, false));
        try {
            actualResults.add("RETURN: " + anotherTask.get().toString());
        } catch (Exception e) {
            actualResults.add("THROW: " + e.getMessage());
        }

        for (int i = 0; i < expectedResults.size(); i++) {
            if (!expectedResults.get(i).equals(actualResults.get(i))) {
                throw new Exception(
                        String.format("Unexpected \"%s\" for task %d, expected is \"%s\"",
                                actualResults.get(i), i, expectedResults.get(i))
                );
            }
        }
    }
}
