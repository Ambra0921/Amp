package com.czy;

import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author caizy
 * @date 2020/7/17 15:02
 **/
public class VoliateTest {

    public volatile Integer counter = 0;

    public Integer count2 = 1;

    public void add() {
        counter++;
        count2++;
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        VoliateTest voliateTest = new VoliateTest();

    }
}
