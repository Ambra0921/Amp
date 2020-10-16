package com.amp.goods.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡策略
 *
 * @author caizy
 * @date 2019/12/14 15:08
 **/
@Configuration
public class LoadBalanced {

    @Bean
    public IRule ribbonRule(){
        return  new RandomRule();
    }
}
