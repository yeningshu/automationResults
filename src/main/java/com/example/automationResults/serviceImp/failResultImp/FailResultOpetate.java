/**
 * @author yedeng
 * @date 2022年12月2日
 * 
 */
package com.example.automationResults.serviceImp.failResultImp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.automationResults.bean.failResult.AddFailResultBean;
import com.example.automationResults.bean.failResult.ReviseFailResultBean;
import com.example.automationResults.mapper.FailResultMapper;
import com.example.automationResults.pojo.FailResultPojo;
import com.example.automationResults.service.failResult.FailResultService;
import com.example.automationResults.util.ResultData;
import com.example.automationResults.util.enumCode.FailRequestCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FailResultOpetate implements FailResultService{
	
	private FailResultMapper failResultMapper;

	@Override
	public ResultData<Integer> addFailResult(AddFailResultBean failResultBean) {
		if(failResultBean.getRunId() == null) {
			log.error("runId为空");
			return ResultData.fail(FailRequestCode.ADD_FAIL_REQUEST_ERROR_PARAM_IS_NULL.getCode(), FailRequestCode.ADD_FAIL_REQUEST_ERROR_PARAM_IS_NULL.getMessage());
		}
		// 组装db入参
		FailResultPojo failResultPojo = new FailResultPojo();
		failResultPojo.setRunId(failResultBean.getRunId());
		// 加个判断，当failResultBean.getProjectId() 为空时，查询run_request结果
		failResultPojo.setProjectId(failResultBean.getProjectId());  
		failResultPojo.setFailMethod(failResultBean.getFailMethod());
		failResultPojo.setFailMessage(failResultBean.getFailMessage());
		// 加个判断，当failResultBean.getOwner() 为空时，查询run_request结果
		failResultPojo.setOwner(failResultBean.getOwner());
		failResultPojo.setStatus(failResultBean.getStatus()==null ? "0" : failResultBean.getStatus());
		failResultPojo.setCreateTime(new Timestamp (System.currentTimeMillis()));
		List<FailResultPojo> failResultPojoList = new ArrayList<FailResultPojo>();
		failResultPojoList.add(failResultPojo);
		Integer failNumber = this.failResultMapper.insertFailResult(failResultPojoList);
		log.info("更新数量为:" + failNumber);
		if(failNumber != 1) {
			return ResultData.fail(FailRequestCode.ADD_FAIL_REQUEST_ERROR_REQUEST_DB.getCode(), FailRequestCode.ADD_FAIL_REQUEST_ERROR_REQUEST_DB.getMessage());
		}
		return ResultData.success(failNumber);
	}

	@Override
	public ResultData<Integer> addFailResult(List<AddFailResultBean> failResultBeanList) {
		List<FailResultPojo> failResultPojoList = new ArrayList<FailResultPojo>();
		for (AddFailResultBean failResultBean : failResultBeanList) {
			if(failResultBean.getRunId() == null) {
				log.error("runId为空");
				return ResultData.fail(FailRequestCode.ADD_FAIL_REQUEST_ERROR_PARAM_IS_NULL.getCode(), FailRequestCode.ADD_FAIL_REQUEST_ERROR_PARAM_IS_NULL.getMessage());
			}
			
			FailResultPojo failResultPojo = new FailResultPojo();
			failResultPojo.setRunId(failResultBean.getRunId());
			// 加个判断，当failResultBean.getProjectId() 为空时，查询run_request结果
			failResultPojo.setProjectId(failResultBean.getProjectId());  
			failResultPojo.setFailMethod(failResultBean.getFailMethod());
			failResultPojo.setFailMessage(failResultBean.getFailMessage());
			// 加个判断，当failResultBean.getOwner() 为空时，查询run_request结果
			failResultPojo.setOwner(failResultBean.getOwner());
			failResultPojo.setStatus(failResultBean.getStatus()==null ? "0" : failResultBean.getStatus());
			failResultPojo.setCreateTime(new Timestamp (System.currentTimeMillis()));
			failResultPojoList.add(failResultPojo);
		}
		// 调用db
		Integer failNumber = this.failResultMapper.insertFailResult(failResultPojoList);
		log.info("更新数量为:" + failNumber);
		// 数据量过大时要拆分
		if(failNumber != failResultPojoList.size()) {
			return ResultData.fail(FailRequestCode.ADD_FAIL_REQUEST_ERROR_REQUEST_DB.getCode(), FailRequestCode.ADD_FAIL_REQUEST_ERROR_REQUEST_DB.getMessage());
		}
		return ResultData.success(failNumber);
		
	}

	@Override
	public ResultData<Integer> reviseFailResult(ReviseFailResultBean reviseFailResult) {
		// 入参判断
		if(reviseFailResult.getId() == null) {
			log.error("Id为空");
			return ResultData.fail(FailRequestCode.UPDATE_FAIL_REQUEST_ERROR_ID_IS_NULL.getCode(), FailRequestCode.UPDATE_FAIL_REQUEST_ERROR_REQUEST_DB.getMessage());
		}
		String[] statisEnum = new String[] {"0","1","2","3"};
		if(!new HashSet<>(Arrays.asList(statisEnum)).contains(reviseFailResult.getStatus())) {
			log.error("status不在范围内");
			return ResultData.fail(FailRequestCode.UPDATE_FAIL_REQUEST_ERROR_STATUS.getCode(), FailRequestCode.UPDATE_FAIL_REQUEST_ERROR_STATUS.getMessage());
		}
		
		FailResultPojo failResultPojo = new FailResultPojo();
		failResultPojo.setId(reviseFailResult.getId());
		failResultPojo.setStatus(reviseFailResult.getStatus());
		failResultPojo.setIdentifyPeople(reviseFailResult.getIdentifyPeople());
		failResultPojo.setNotificationMessage(reviseFailResult.getNotificationMessage());
		failResultPojo.setNotificationTime(new Timestamp (System.currentTimeMillis()));
		Integer updateStatusNum = this.failResultMapper.updateStatus(failResultPojo);
		log.info("更新数量为:" + updateStatusNum);
		if(updateStatusNum != 1) {
			return ResultData.fail(FailRequestCode.UPDATE_FAIL_REQUEST_ERROR_REQUEST_DB.getCode(), FailRequestCode.UPDATE_FAIL_REQUEST_ERROR_REQUEST_DB.getMessage());
		}
		return ResultData.success(updateStatusNum);
	}

	@Override
	public ResultData<List<FailResultPojo>> getFailResultList(Integer runId) {
		if(runId == null) {
			log.error("runId为空");
			return ResultData.fail(FailRequestCode.SELECT_FAIL_REQUEST_ERROR_PARAM_IS_NULL.getCode(), FailRequestCode.SELECT_FAIL_REQUEST_ERROR_PARAM_IS_NULL.getMessage());
		}
		return ResultData.success(this.failResultMapper.getFailResultList(runId));
	}

}
