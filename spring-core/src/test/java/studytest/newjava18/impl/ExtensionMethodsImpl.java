package studytest.newjava18.impl;

import org.junit.Test;
import studytest.newjava18.ExtensionMethods;

/**
 * Created by braveup on 2017/3/8.
 */
public class ExtensionMethodsImpl implements ExtensionMethods {

    @Override
    public void add(int a, int b) {
        int sum = a + b;
        System.out.println(sum);
    }

    @Test
    public void test() {
//        ExtensionMethodsImpl extensionMethods = new ExtensionMethodsImpl();
//        int sum = extensionMethods.sum(25, 10);
//        System.out.println(sum);
        System.out.println(ExtensionMethodsImpl.this.sum(20, 10));
    }

}
