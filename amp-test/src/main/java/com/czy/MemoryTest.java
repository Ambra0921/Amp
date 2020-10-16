package com.czy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caizy
 * @date 2020/8/12 11:00
 **/
public class MemoryTest {

    private Integer testA;

    public Integer getTestA() {
        return testA;
    }

    public void setTestA(Integer testA) {
        this.testA = testA;
    }

    public static void main(String[] args) throws InterruptedException {
        List<MemoryTest> memoryTests = new ArrayList<MemoryTest>();
        int i = 0;
        while (true){
            MemoryTest memoryTest = new MemoryTest();
            memoryTest.setTestA(i++);
            memoryTests.add(memoryTest);
            Thread.sleep(100);
        }
    }
}
