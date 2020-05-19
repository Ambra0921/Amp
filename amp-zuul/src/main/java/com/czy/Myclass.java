package com.czy;

/**
 * @author caizy
 * @date 2020/1/8 10:55
 **/
public class Myclass {

    // 同步代码块
    public void doSth1(){
        synchronized (Myclass.class){
            System.out.println("HelloWorld");
        }
    }
    // 同步方法
    public synchronized void doSth2(){
        System.out.println("HelloWorld");
    }
}
