package studytest.newjava18;

import org.junit.Test;
import org.springframework.cache.annotation.Cacheable;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Predicate;

/**
 * old java string sort method
 * List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
 * Collections.sort(names, new Comparator<String>() {
 *
 * @Override public int compare(String a, String b) {
 * return b.compareTo(a);
 * }
 * });
 * new java 1.8
 * Created by braveup on 2017/3/8.
 */
public class LambdaTest {
    private String c = "c";
//    public LambdaTest(Object a, Object b) {
//        this.c = a.toString() + b.toString();
//    }

    /**
     * java 之前的比较字符串的方法
     * 只需要给静态方法 Collections.sort 传入一个List对象以及一个比较器来按指定顺序排列。
     * 通常做法都是创建一个匿名的比较器对象然后将其传递给sort方法。
     * 在Java 8 中你就没必要使用这种传统的匿名对象的方式了，Java 8提供了更简洁的语法，
     */
    @Test
    public void testOldStringSort() {
        List<String> list = Arrays.asList("suer", "anna", "super", "leisong");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list.toString());
    }

    @Test
    public void testNewStringSort() {
        List<String> list = Arrays.asList("suer", "anna", "super", "leisong");
        List<String> list1 = Arrays.asList("suer", "anna", "super", "leisong");
        //Collections.sort(list, (String a, String b) -> {
        //return a.compareTo(b);
        //});
        //上面的简化,直接调用接口返回
        //Collections.sort(list, (String a, String b) -> a.compareTo(b));
        //java编译器可以自动推导出类型，所以可以将类型简化
        Collections.sort(list, (a, b) -> a.compareTo(b));
        Collections.sort(list1, (a, b) -> b.compareTo(a));
        System.out.println(list.toString());
        System.out.println(list1.toString());
    }

    /**
     * 函数式接口（接口中只能有且只有一个）:
     * 1.接口以@FunctionalInterface接口标注，意思为将lambda表达式当作任意只包含一个抽象方法的接口类型
     * 2.接口的实现不必有类来实现，而是由lambda来实现
     * 3.(a, b)抽象方法的参数
     */
    @Test
    public void testFunctionInteface() {
        FunctionInteface<String, String> functionalInterface = (a, b) -> LambdaTest.add(a, b);
        String str = functionalInterface.add("a", "b");
        System.out.println(str);
    }

    /**
     * 方法与构造函数引用
     * Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用
     * 获取构造函数的引用的话使用 ::new，后面接new关键字即可
     */
    @Test
    public void testFunctionInteface1() {
        FunctionInteface<String, String> functionInteface = LambdaTest::add;
        //获取构造函数的引用的话使用 ::new，后面接new关键字即可(运行会报错,原因是因为测试类只能有一个无参构造函数)
//        FunctionInteface functionInteface1 = LambdaTest::new;
        System.out.println("::add传递方法的引用" + functionInteface.add("c", "d"));
//        System.out.println("::new传递构造函数的引用"+ functionInteface1.add("a","b"));
    }

    /**
     * 在lambda表达式中访问外层作用域和老版本的匿名对象中的方式很相似。
     * 你可以直接访问标记了final的外层局部变量，或者实例的字段以及静态变量。
     */
    @Test
    public void testFunctionInteface3() {
        final String str = "lei.song";
        FunctionInteface<String, String> functionInteface = (a, b) -> add(a, (b + c + str));
        System.out.println(functionInteface.add("a", "b"));
    }

    /**
     * 访问静态变量和全局变量
     * 和本地变量不同的是，lambda内部对于实例的字段以及静态变量是即可读又可写。该行为和匿名对象是一致的
     */
    static String a;
    String b;

    @Test
    public void testScope() {
        FunctionInteface<String, String> functionInteface = (a, b) -> {
            b = "one test";
            return add(a, b);
        };
        FunctionInteface<String, String> functionInteface1 = (a, b) -> {
            a = "one";
            return add(a, b);
        };
        System.out.println("lambda表达式将b修改:" + functionInteface.add("", "second test"));
        System.out.println("lambda表达式将a修改:" + functionInteface1.add("two", ""));
    }

    /**
     * 内建函数式接口
     * Predicate 接口只有一个参数，返回boolean类型。该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）
     */
    @Test
    public void testPredicate() {
        String str="";
        //用于做一些判断
        Predicate<String>  predicate=(s)->s.length()>0;
        System.out.println(predicate.test("ssr"));
        System.out.println(predicate.negate().test(""));
        Predicate<Boolean>  nonNull= Objects::nonNull;
        System.out.println(nonNull.test(true));
        Predicate<Boolean> isNull=Objects::isNull;
        System.out.println(isNull.test(false));
        Predicate<String> isEmpty=String::isEmpty;
        System.out.println(isEmpty.test(str));
        Predicate<String> isNotEmpty=isEmpty.negate();
        System.out.println(isNotEmpty.test(str));
    }


    public void run() {
        System.out.println("执行run方法....");
    }

    public static String add(String a, String b) {
        return a + b;
    }

    //测试@FunctionInterface注解
    @Test
    public void testRunable() {
        Runnable runnable = () -> run();
        Runnable runnable1 = () -> run();
        Runnable runnable2 = () -> run();
        BlockingQueue blockingQueue = new LinkedBlockingDeque<>(2);
        blockingQueue.offer(runnable);
        blockingQueue.offer(runnable1);
        blockingQueue.offer(runnable2);
        System.out.println(blockingQueue.size());
        Runnable runnables = (Runnable) blockingQueue.poll();
        System.out.println(blockingQueue.size());
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(runnables);
    }

}