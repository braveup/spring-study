package com.spring.main.po;

/**
 * Created by braveup on 2017/2/23.
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
}
