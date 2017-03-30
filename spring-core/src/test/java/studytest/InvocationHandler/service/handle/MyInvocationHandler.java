package studytest.InvocationHandler.service.handle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by braveup on 2017/2/24.
 * 自己实现的InvocationHandler
 */
public class MyInvocationHandler implements InvocationHandler {

    //目标对象
    private Object objects;

    /**
     * 构造方法
     * @param object
     */
    public MyInvocationHandler(Object object) {
        super();
        this.objects = object;
    }

    /**
     *执行目标对象的方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在目标对象的方法执行之前简单的打印一下
        System.out.println("------------------开始------------------");

        Object object=method.invoke(objects,args);

        // 在目标对象的方法执行之后简单的打印一下
        System.out.println("------------------结束------------------");


        return object;
    }

    public Object  getProxy(){

        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),objects.getClass().getInterfaces(),this);
    }
}

