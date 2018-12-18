package com.zw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.zw.dao.mapper")
@SpringBootApplication
public class CfmyControllerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CfmyControllerApplication.class, args);
	}

	/**
	 *  extends SpringBootServletInitializer
	 * 实现SpringBootServletInitializer可以让spring-boot项目在web容器中运行
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.sources(this.getClass());
		return super.configure(builder);
	}

}

