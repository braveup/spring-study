package studytest.newjava18;

/**
 * java1.8的新特性一
 * java 8允许我们给接口添加一个非抽象的方法实现，
 * 只需要使用 default关键字即可，这个特征又叫做扩展方法。
 * JAVA可以实现多个接口，从而来对原本的类进行方法扩展。
 * JAVA只能继承1个类，所以以前的接口没法提供这种灵活的扩展方法。
 * 现在要简单的扩展方法，也不需要使用Spring的代码织入了，直接用扩展方法即可。
 * 不过横切逻辑织入还是用Spring好。
 * Created by braveup on 2017/3/8.
 */
public interface ExtensionMethods {
    void add(int a, int b);

    //使用 default关键字来扩展一个非抽象方法的一个实现
    default int sum(int a,int b) {
        int sum=0;
        if (a>b){
            sum=a+b;
        }
        return  sum;
    }
}
