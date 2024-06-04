package com.tims.bootframe.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    // 这个类注册拦截器

    @Autowired
    LoginInterceptor loginInterceptor;
    // 注册拦截方法
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/abc");
        //WebMvcConfigurer.super.addInterceptors(registry);
    }
}
