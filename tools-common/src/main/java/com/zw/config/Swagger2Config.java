package com.zw.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：zhaowei
 * Date：2018/12/15
 * Time：下午7:40
 * 魏翼超然：http://120.79.171.251:9876
 * ========================
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("token")
                .description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("MapperApi接口")
                .apiInfo(apiInfo())
                .select()
                // .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.zw.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .protocols(new HashSet<String>(Lists.newArrayList("http")))
                .pathMapping("/")
                .apiInfo(apiInfo());
    }

    @Bean
    public Docket PersonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("PersonApi接口")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo18.Person"))
                .paths(PathSelectors.any()).build();
    }

    @Bean
    public Docket ServiceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Service接口")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo18.Service"))
                .paths(PathSelectors.any()).build();
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("gradle springboot 多模块项目构建RESTful API")
                //创建人
                .contact(new Contact("魏翼超然", "http://120.79.171.251:9876", ""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}