package studytest.queue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by braveup on 2017/3/1.
 */
public class StudyQueue {
    /**
     * 测试队列
     * <pre>
     * 队列特点，先进先出，后进后出，火车过山洞例子
     * </pre>
     */
    @Test
    public void testQueue(){
        Queue<String>  queue=new LinkedList<String>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        for (String queues:queue){
            System.out.println(queues);
        }
        System.out.println("========");
        System.out.println("返回第一个元素，并在队列中删除poll:"+queue.poll());//弹出第一个元素
        for (String queues:queue){
            System.out.println(queues);
        }
        System.out.println("========");
        System.out.println("返回第一个元素element: "+queue.element());
        for (String queues:queue){
            System.out.println(queues);
        }
        System.out.println("========");
        System.out.println("返回第一个元素peek:"+queue.peek());
        for (String queues:queue){
            System.out.println(queues);
        }
    }
    /**
     * 测试栈
     * <pre>
     * 先进后出，后进先出，水桶倒水
     * </pre>
     */
    @Test
    public void   testStack(){
        Stack<String> stringStack=new Stack<String>();
        //增加元素
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        stringStack.push("d");
        stringStack.add("1");
        stringStack.add("2");
        stringStack.add("3");
        System.out.println("栈中的元素:"+stringStack);
        //弹出元素
        System.out.println("弹出元素pop:"+ stringStack.pop());
        System.out.println("栈中的元素:"+stringStack);
        //查看元素并不弹出
        System.out.println("栈中第一个元素peek:"+ stringStack.peek());
        System.out.println("栈中的元素:"+stringStack);


    }
}
