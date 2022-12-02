/**
 * @author yedeng
 * @date 2022年12月1日
 * 
 */
package com.example.automationResults.service.failResult;

import java.util.List;

import com.example.automationResults.bean.failResult.AddFailResultBean;
import com.example.automationResults.bean.failResult.ReviseFailResultBean;
import com.example.automationResults.pojo.FailResultPojo;
import com.example.automationResults.util.ResultData;

public interface FailResultService {
	/**
	 * 添加失败结果
	 * @param failResultBean
	 */
	public ResultData<Integer> addFailResult(AddFailResultBean failResultBean);
	
	/**
	 * 批量添加失败结果
	 * @param failResultBeanList
	 */
	public ResultData<Integer> addFailResult(List<AddFailResultBean> failResultBeanList);
	
	/**
	 * 修改状态，发送通知
	 * @param reviseFailResult
	 */
	public ResultData<Integer> reviseFailResult(ReviseFailResultBean reviseFailResult);
	
	/**
	 * 获取失败结果列表
	 */
	public ResultData<List<FailResultPojo>> getFailResultList(Integer runId);
	
}
