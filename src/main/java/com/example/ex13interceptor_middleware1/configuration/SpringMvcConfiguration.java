package com.example.ex13interceptor_middleware1.configuration;

import com.example.ex13interceptor_middleware1.interceptors.APILoggingInterceptor;
import com.example.ex13interceptor_middleware1.interceptors.LoggedUserInterceptor;
import com.example.ex13interceptor_middleware1.interceptors.TestInterceptor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;

    @Autowired
    private TestInterceptor testInterceptor;

    @Autowired
    private LoggedUserInterceptor loggedUserInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(testInterceptor);
        registry.addInterceptor(loggedUserInterceptor);
    }


}
