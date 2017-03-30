package studytest.InvocationHandler.service;

import java.lang.reflect.Proxy;
import org.junit.Test;
import studytest.InvocationHandler.service.handle.MyInvocationHandler;
import studytest.InvocationHandler.service.inteface.IUserService;
import studytest.InvocationHandler.service.serviceimpl.UserServviceImpl;

/**
 * Created by braveup on 2017/2/24.
 */
public class MyInvocationtTest {
    /**
     * jDK动态代理测试
   */
    @Test
    public  void  testInvocation(){
        // 实例化目标对象
        IUserService  userService=new UserServviceImpl();
        // 实例化InvocationHandler
        MyInvocationHandler myInvocationHandler=new MyInvocationHandler(userService);
        // 根据目标对象生成代理对象
        IUserService userServices=(IUserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),userService.getClass().getInterfaces(),myInvocationHandler);
        // 调用代理对象的方法
        userServices.study();
    }
}
