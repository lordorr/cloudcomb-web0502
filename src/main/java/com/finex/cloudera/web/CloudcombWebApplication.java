package com.finex.cloudera.web;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ServletComponentScan
@ComponentScan
@EnableAutoConfiguration
@EnableSwagger2
public class CloudcombWebApplication {

    private static final Logger logger = Logger.getLogger(CloudcombWebApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CloudcombWebApplication.class, args);
		logger.info("springboot 启动成功，请开始愉快的开发之旅吧！");
	}
}
