package com.example.automationResults;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动目录
 * @author yedeng
 * @Title	
 * @date 2022年11月22日
 */
@SpringBootApplication
@MapperScan("com.example.automationResults.mapper")
public class AutomationResultsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomationResultsApplication.class, args);
	}

}
