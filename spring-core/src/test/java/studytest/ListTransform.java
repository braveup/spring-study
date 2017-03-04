package studytest;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.spring.main.po.Books;
import com.spring.main.po.Helloword;
import org.junit.Test;

import java.util.List;

/**
 * Created by braveup on 2017/2/23.
 */
public class ListTransform {
    @Test
    public void transFormTest() {
        List<Helloword> listh = Lists.newArrayList();
        getData(listh);
        List<Books> booksList = Lists.transform(listh, new Function<Helloword, Books>() {
            public Books apply(Helloword helloword) {
                Books books = new Books();
                books.setHelloword(helloword);
                return books;
            }
        });

        for (Books books : booksList) {
            System.out.println(books.getHelloword().getName());
        }
    }

    private void getData(List<Helloword> listh) {
        for (int i = 0; i < 100; i++) {
            Helloword helloword = new Helloword();
            helloword.setName("mytest" + i);
            listh.add(helloword);
        }
        System.out.println(listh.size());
    }

}
