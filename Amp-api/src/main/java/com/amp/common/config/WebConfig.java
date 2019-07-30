package com.amp.common.config;

import com.amp.common.interceptor.ApiResultInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web配置
 *
 * @author caizy
 * @date 2019/7/26 16:01
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private ApiResultInterceptor apiResultInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(apiResultInterceptor).addPathPatterns("/**");
    }
}
