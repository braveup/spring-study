package studytest.AspectAnnotionTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by braveup on 2017/2/23.
 */
@Aspect
public class AspectAnnotationTest {
    @Pointcut("execution(* *.fooB(..))")
    private void pointCutMethod(){
    }
    //声明前置通知
    @Before("pointCutMethod")
    public void doBefore(){
        System.out.println("前置通知");
    }
    //声明后置通知
    @AfterReturning(pointcut = "pointCutMethod()",returning = "result")
    public  void doAfterRuning(String result){
        System.out.println("后置通知");
        System.out.println("-----"+result+"-------");
    }

    //声明例外通知
    @AfterThrowing(pointcut = "pointCutMethod()",throwing = "e")
    public void  doAfterThrowing(Exception e){
        System.out.println("声明列外通知");
        System.out.println(e.getMessage());
    }

    //声明最终通知
    @After("pointCutMethod()")
    public  void  doAfter(){
        System.out.println("最终通知");
    }

    //声明环绕通知
    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("进入方法，---环绕通知");
        Object o   =proceedingJoinPoint.proceed();
        System.out.println("退出方法，---环绕通知");
        return  o;
    }

}
