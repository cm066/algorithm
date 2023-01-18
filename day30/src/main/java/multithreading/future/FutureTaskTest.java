package multithreading.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "测试FutureTask获取异步结果";
            }
        });
        new Thread(futureTask).start();
//        String s = futureTask.get();
        new Thread(()->{
            try {
                futureTask.get();
                System.out.println();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).start();
//        System.out.println(futureTask.get());
    }
}
