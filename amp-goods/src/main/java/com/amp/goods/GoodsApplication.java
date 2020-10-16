package com.amp.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 商品服务启动类
 *
 * @author caizy
 * @date 2019/12/13 14:26
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "goods",configuration = {com.amp.goods.config.LoadBalanced.class})
public class GoodsApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
