/**
 * @author yedeng
 * @date 2022年12月1日
 * 
 */
package com.example.automationResults.conrtoller.failResult;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.automationResults.bean.failResult.AddFailResultBean;
import com.example.automationResults.bean.failResult.ReviseFailResultBean;
import com.example.automationResults.pojo.FailResultPojo;
import com.example.automationResults.service.failResult.FailResultService;
import com.example.automationResults.util.ResultData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@SpringBootApplication
public class FailResultController {
	
	@Autowired
	private FailResultService failResultService;
	
	/**
	 * 单个新增
	 * @param addFailResultBean
	 * @return
	 */
	@PostMapping("")
	@ResponseBody
	public ResultData<Integer> addFail(@RequestBody AddFailResultBean addFailResultBean) {
		log.info("前端入参为:" + JSONObject.toJSONString(addFailResultBean));
		return this.failResultService.addFailResult(addFailResultBean);
	}
	
	/**
	 * 批量添加
	 * @param addFailResultBeanList
	 * @return
	 */
	@PostMapping("")
	@ResponseBody
	public ResultData<Integer> addFailtList(@RequestBody List<AddFailResultBean> addFailResultBeanList) {
		log.info("前端入参为:" + JSONObject.toJSONString(addFailResultBeanList));
		return this.failResultService.addFailResult(addFailResultBeanList);
	}
	
	/**
	 * 修改状态，发送通知
	 * @param reviseFailResult
	 * @return
	 */
	@PostMapping("")
	@ResponseBody
	public ResultData<Integer> reviseResult(@RequestBody ReviseFailResultBean reviseFailResult) {
		log.info("前端入参为:" + JSONObject.toJSONString(reviseFailResult));
		return this.failResultService.reviseFailResult(reviseFailResult);
	}
	
	/**
	 * 获取列表
	 * @param id
	 * @return
	 */
	@GetMapping("")
	@ResponseBody
	public ResultData<List<FailResultPojo>> reviseResult(Integer id) {
		log.info("前端入参为:" + id);
		return this.failResultService.getFailResultList(id);
	}
	
}
