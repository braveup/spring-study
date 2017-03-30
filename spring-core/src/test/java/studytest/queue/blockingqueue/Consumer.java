package studytest.queue.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by braveup on 2017/3/8.
 */
public class Consumer implements Runnable {

    public static final int BOUND = 1000;
    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        System.out.println("启动消费者线程");
        Random random = new Random();
        Boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.println("正在从队列获取消息");
                String data = blockingQueue.poll(2, TimeUnit.SECONDS).toString();
                if (null!=data){
                    System.out.println("拿到的数据为"+data);
                    System.out.println("正在消费数据"+data);
                    Thread.sleep(random.nextInt(BOUND));
                }else {
                    isRunning=false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("退出消费者线程");
            System.out.println("队列目前已经空间:"+blockingQueue.size());
        }
    }
}

