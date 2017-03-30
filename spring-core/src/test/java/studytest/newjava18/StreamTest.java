package studytest.newjava18;

import com.google.common.collect.Lists;
import com.spring.main.po.Books;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by braveup on 2017/3/19.
 */
public class StreamTest {
    public static void main(String[] args) {
        testStream();

    }

    private static void testStream() {
        List<Books> listb = Lists.newArrayList();

        Books books = new Books("a", "b");
        Books book = new Books("b", "b");
        Books book1 = new Books("c", "b");
        listb.add(book);
        listb.add(books);
        listb.add(book1);

//        listb.forEach(a -> {
//            int i=0;
//            a.setSnaguo("a");
//            i++;
////            System.out.println(a.getSnaguo()+i);
//        });
//        System.out.println(listb.size());
        /**
         * stream的测试
         */
//        listb.stream().filter(a -> !a.getSnaguo().equals("b2")).forEach(t -> {
//            t.setSnaguo("c");
//            System.out.println(t.getSnaguo());
//        });
        listb.stream().filter(a -> !"a".equals(a.getHalibote())).filter(a -> !"b".equals(a.getHalibote())).forEach(t -> {
            System.out.println(t.getHalibote());
        });
    }
}
