package com.spring.main.po;

/**
 * Created by braveup on 2017/2/23.
 * 判断两个对象在逻辑上是否相等，如根据类的成员变量来判断两个类的实例是否相等，
 * 而继承Object中的equals方法只能判断两个引用变量是否是同一个对象。
 * 这样我们往往需要重写equals()方法。
 * 我们向一个没有重复对象的集合中添加元素时，集合中存放的往往是对象，
 * 我们需要先判断集合中是否存在已知对象，这样就必须重写equals方法。
 */
public class Books {
    private String halibote;
    private String snaguo;
    private Helloword helloword;

    public Books() {
    }

    public Books(String halibote, String snaguo) {
        this.halibote = halibote;
        this.snaguo = snaguo;
    }

    public Books(String halibote, String snaguo, Helloword helloword) {
        this.halibote = halibote;
        this.snaguo = snaguo;
        this.helloword = helloword;
    }

    public Helloword getHelloword() {
        return helloword;
    }

    public void setHelloword(Helloword helloword) {
        this.helloword = helloword;
    }

    public String getHalibote() {
        return halibote;
    }

    public void setHalibote(String halibote) {
        this.halibote = halibote;
    }

    public String getSnaguo() {
        return snaguo;
    }

    public void setSnaguo(String snaguo) {
        this.snaguo = snaguo;
    }

    /**
     * 怎样重写equals()方法？
     * 重写equals方法的要求：
     * 1、自反性：对于任何非空引用x，x.equals(x)应该返回true。
     * 2、对称性：对于任何引用x和y，如果x.equals(y)返回true，那么y.equals(x)也应该返回true。
     * 3、传递性：对于任何引用x、y和z，如果x.equals(y)返回true，y.equals(z)返回true，那么x.equals(z)也应该返回true。
     * 4、一致性：如果x和y引用的对象没有发生变化，那么反复调用x.equals(y)应该返回同样的结果。
     * 5、非空性：对于任意非空引用x，x.equals(null)应该返回false。
     * equals 和==的区别
     * equals方法（比较的是内容，判断是否逻辑相等）
     * "＝＝" （比较的是地址，只有两个都是指向同一个对象的时候才能返回True）
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (halibote != null ? !halibote.equals(books.halibote) : books.halibote != null) return false;
        if (snaguo != null ? !snaguo.equals(books.snaguo) : books.snaguo != null) return false;
        return helloword != null ? helloword.equals(books.helloword) : books.helloword == null;
    }

    /**
     * hashcode解释：
     * 它独一无二的代表一个对象，并且通过hashcode可以找到对象的位置。在内存中有好多好多对象，
     * 在程序运行时有很多对象可能在内存中分配。
     * 但对虚拟机来说，它运行时它要找到对象的地址，于是用表
     * 通常是哈希表来存储内存中对象的编码，每个对象对应独一无二的编码。
     * 由编码就能找到相应的对象，由此快速对应对象。
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = halibote != null ? halibote.hashCode() : 0;
        result = 31 * result + (snaguo != null ? snaguo.hashCode() : 0);
        result = 31 * result + (helloword != null ? helloword.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Books{" +
                "halibote='" + halibote + '\'' +
                ", snaguo='" + snaguo + '\'' +
                ", helloword=" + helloword +
                '}';
    }

    public static void main(String[] args) {

        Books bookOne = new Books("books", "test");
        Books bookTwo = new Books("books", "test");
        //equals方法（比较的是内容，判断是否逻辑相等）
        //"＝＝" （比较的是地址，只有两个都是指向同一个对象的时候才能返回True）
        System.out.println("/*******前提是不重写equals方法和hashCode方法******/");
        //前提是不重写equals方法和hashCode方法
        System.out.println(bookOne == bookTwo);//两个对象的hashCode不一致，所以false
        System.out.println(bookOne.equals(bookTwo));//继承Object默认的equals方法比较的是对象的应用地址,所以返回的是false
        //重写equals方法和hashCode方法
        System.out.println("/********重写equals方法和hashCode方法**********/");
        System.out.println(bookOne == bookTwo);//两个对象的hashCode不一致，所以false
        System.out.println(bookOne.equals(bookTwo));//重写Object的默认的equals方法，比较是内容，所以返回true
        System.out.println("String类的比较,String已经重写了equals方法");
        String stringOne = new String("123");
        String stringTwo = new String("123");
        System.out.println(stringOne == stringTwo);
        System.out.println(stringOne.equals(stringTwo));
    }
}
