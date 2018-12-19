package com.zw.common.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午10:56
 * @describe 继承WebMvcConfigureAdapter继承并重写addInterceptor方法用于添加配置拦截器
 */
@Configuration
public class MyAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加拦截器
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/cfmy/**");
                // .excludePathPatterns("/cfmy/public/start/login");
    }
}
