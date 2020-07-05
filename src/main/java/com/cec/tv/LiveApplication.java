package com.cec.tv;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EnableSwagger2Doc
@SpringBootApplication
@MapperScan(basePackages = "com.cev.tv.dao")
public class LiveApplication {//extends SpringBootServletInitializer

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(LiveApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(LiveApplication.class, args);
	}

}
