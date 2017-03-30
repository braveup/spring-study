package studytest.queue.blockingqueue;


import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by braveup on 2017/3/8.
 */
public class BlockingQueueTest {

    @Test
    public void blockingQueue() {
        // 声明一个容量为10的缓存队列
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<String>(100);
        Producer producer=new Producer(blockingQueue);
        Producer  producer2=new Producer(blockingQueue);
        Producer  producer3=new Producer(blockingQueue);
        Producer  producer4=new Producer(blockingQueue);
        Producer  producer5=new Producer(blockingQueue);
        Producer  producer6=new Producer(blockingQueue);
        Consumer consumer =new Consumer(blockingQueue);
        ExecutorService executor = Executors.newCachedThreadPool();
        //启动线程
        executor.execute(producer);
        executor.execute(producer2);
        executor.execute(producer3);
        executor.execute(producer4);
        executor.execute(producer5);
        executor.execute(producer6);
        executor.execute(consumer);
        try {
            //执行10s
            Thread.sleep(1000*2);
            producer.stop();
            producer2.stop();
            producer3.stop();
            Thread.sleep(1000);
            //结束线程
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
