package studytest.queue.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by braveup on 2017/3/8.
 */
public class Producer implements Runnable {
    public static final int BOUND = 1000;
    private volatile boolean isRuning = true;
    private BlockingQueue blockingQueue;
    private static AtomicInteger atomicInteger = new AtomicInteger();


    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        System.out.println("生产者线程启动");
        String data = null;
        Random random = new Random();
        try {
            while (isRuning) {
                System.out.println("正在生产数据");
                Thread.sleep(random.nextInt(BOUND));
                data = "data:" + atomicInteger.incrementAndGet();
                System.out.println("将数据" + data + "放入队列");
                if (!blockingQueue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("数据放入失败" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("退出生产者线程");
            System.out.println("队列目前已经空间:"+blockingQueue.size());
        }
    }

    public void stop() {
        isRuning = false;
    }
}
