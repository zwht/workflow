package com.zw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

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
        /*UserController userController = SpringUtil.getBean(UserController.class);
        System.out.println("拿到bean了，哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"+userController);*/
		builder.sources(this.getClass());
		return super.configure(builder);
	}

}

