package com.zw.common.interceptor;


import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：上午10:56 WebMvcConfigurerAdapter
 * @describe 继承WebMvcConfigureAdapter继承并重写addInterceptor方法用于添加配置拦截器
 */
@Configuration
public class MyAdapter extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加全部请求拦截器
        registry.addInterceptor(new AllInterceptor())
                .addPathPatterns("/**");
        // .excludePathPatterns("/v1/public/start/login");
        //添加接口请求拦截器
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/v1/**");
                // .excludePathPatterns("/v1/public/start/login");

    }

    @Override
    public  void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/static/frontend/assets/");
    }

    @Override
    public  void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //格式化json数据格式
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //序列化时避免精度丢失，转换为字符串
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        fastJsonConfig.setSerializeConfig(serializeConfig);
//        fastJsonConfig.setDateFormat("yyyy-HH-dd HH:mm:ss");
        fastConverter.setFastJsonConfig(fastJsonConfig);
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        converters.add(0,fastConverter);
    }
}
