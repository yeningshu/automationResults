package com.example.automationResults;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.automationResults.mapper.ProjectMapper;
import com.example.automationResults.pojo.ProjectPojo;
import com.example.automationResults.util.enumCode.RunRequestCode;
import com.example.automationResults.util.enumCode.UserCode;

@SpringBootTest
class AutomationResultsApplicationTests {
	

	@Test
	void contextLoads() { 
		long millis=System.currentTimeMillis();
		Date time = new Date(millis);
		System.out.println(time);
	}
	
	

}
