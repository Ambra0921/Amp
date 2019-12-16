package com.amp.config;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign配置
 *
 * @author caizy
 * @date 2019/12/16 14:09
 **/
@Configuration
public class FeignConfiguration {

    @Bean
    public Contract getContract(){
        return new Contract.Default();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }
}
