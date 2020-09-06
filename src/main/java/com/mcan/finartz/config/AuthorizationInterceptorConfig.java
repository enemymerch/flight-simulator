package com.mcan.finartz.config;

import com.mcan.finartz.config.interceptor.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class AuthorizationInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    AuthorizationInterceptor authorizationInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/ticket");
//    }
}
