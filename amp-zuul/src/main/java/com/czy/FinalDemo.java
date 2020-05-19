package com.czy;

/**
 * @author caizy
 * @date 2020/1/7 16:10
 **/
public class FinalDemo {

    private int a;  // 普通域
    private final int b; // final域
    private static FinalDemo finalDemo;

    public FinalDemo() {
        a = 1; // ①写普通域
        b = 2; // ②写final域
    }

    public static void writer() {
        // 两个操作：
        // 1）构造一个FinalExample类型的对象，①写普通域a=1，②写final域b=2
        // 2）③把这个对象的引用赋值给引用变量finalDemo
        finalDemo = new FinalDemo();
    }

    public static void reader() {
        FinalDemo demo = finalDemo; // ④读对象引用
        int a = demo.a;    // ⑤读普通域
        int b = demo.b;    // ⑥读final域
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                FinalDemo.writer();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                FinalDemo.reader();
            }
        }).start();
    }
}
