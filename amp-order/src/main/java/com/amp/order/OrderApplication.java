package com.amp.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单启动类
 *
 * @author caizy
 * @date 2019/12/13 15:42
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RibbonClient(name = "provider-demo" ,configuration = com.amp.config.LoadBalanced.class)
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class OrderApplication {


    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
