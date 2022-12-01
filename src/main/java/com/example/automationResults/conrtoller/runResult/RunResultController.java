/**
 * @author yedeng
 * @date 2022年11月25日
 * 
 */
package com.example.automationResults.conrtoller.runResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.automationResults.bean.runResultBean.RunResultBean;
import com.example.automationResults.pojo.RunResultPojo;
import com.example.automationResults.service.runResult.RunResultService;
import com.example.automationResults.util.ResultData;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@SpringBootApplication
public class RunResultController {
	
	@Autowired
	private RunResultService runResultService;
	
	/**
	 * 新增运行结果
	 * @param runResultBean
	 * @return
	 */
	@PostMapping("/runRequest/addRunRequest")
	@ResponseBody
	public ResultData<Integer> addRunRequest(@RequestBody RunResultBean runResultBean){
		log.info("前端入参为:" + JSONObject.toJSONString(runResultBean));
		return this.runResultService.addResult(runResultBean);		
	}
	
	
	/**
	 * 更新运行结果
	 * @param runResultBean
	 * @return
	 */
	@PostMapping("/runRequest/updateRunRequest")
	@ResponseBody
	public ResultData<Integer> updateRunRequest(@RequestBody RunResultBean runResultBean){
		log.info("前端入参为:" + JSONObject.toJSONString(runResultBean));
		return this.runResultService.updateResult(runResultBean);		
	}
	
	
	/**
	 * 查询运行结果
	 * @param runResultBean
	 * @return
	 */
	@GetMapping("/runRequest/getRunRequest")
	@ResponseBody
	public ResultData<PageInfo<RunResultPojo>> getRunRequestList(String projectName,Integer pageNum,Integer pageSize){
		log.info("前端入参为:" + projectName);
		return this.runResultService.getResult(projectName,pageNum,pageSize);		
	}

}
