package com.czy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;

/**
 * boot
 *
 * @author caizy
 * @date 2019/12/23 15:31
 **/
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
