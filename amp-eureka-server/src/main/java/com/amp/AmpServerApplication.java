package com.amp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * springboot启动类
 *
 * @author caizy
 * @date 2019/12/13 11:39
 **/
@SpringBootApplication
@EnableEurekaServer
public class AmpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmpServerApplication.class,args);
    }
}
