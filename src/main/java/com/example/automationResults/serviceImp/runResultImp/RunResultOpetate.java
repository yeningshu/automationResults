/**
 * @author yedeng
 * @date 2022年11月25日
 * 
 */
package com.example.automationResults.serviceImp.runResultImp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.automationResults.bean.runResultBean.RunResultBean;
import com.example.automationResults.mapper.RunResultMapper;
import com.example.automationResults.pojo.RunResultPojo;
import com.example.automationResults.service.runResult.RunResultService;
import com.example.automationResults.util.ResultData;
import com.example.automationResults.util.enumCode.RunRequestCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RunResultOpetate implements RunResultService {

	@Autowired
	private RunResultMapper runResultMapper;

	/**
	 * 新增操作
	 */
	@Override
	public ResultData<Integer> addResult(RunResultBean runResultBean) {

		// 判断入参
		if (runResultBean.getProjectId() == null || runResultBean.getProjectName() == null) {
			log.error("项目id活动项目或者项目名称为空");
			return ResultData.fail(RunRequestCode.ADD_RUN_REQUEST_ERROR_PARAM_IS_NULL.getCode(),
					RunRequestCode.ADD_RUN_REQUEST_ERROR_PARAM_IS_NULL.getMessage());
		}

		RunResultPojo runResultPojo = new RunResultPojo();
		runResultPojo.setProjectId(runResultBean.getProjectId());
		runResultPojo.setProjectName(runResultBean.getProjectName());
		if(runResultBean.getStartTime() == null) {
			runResultPojo.setStartTime(new Timestamp (System.currentTimeMillis()));
		}else {
			runResultPojo.setStartTime(runResultBean.getStartTime());
		}
		
		runResultPojo.setExecutor(runResultBean.getExecutor());
		// 执行入库操作
		log.info("数据库入库:" + JSONObject.toJSONString(runResultPojo));
		Integer insertResult = this.runResultMapper.insertResult(runResultPojo);
		if (insertResult == 1) {
			return ResultData.success(runResultPojo.getId());
		} else {
			return ResultData.fail(RunRequestCode.ADD_RUN_REQUEST_ERROR_REQUEST_DB.getCode(),
					RunRequestCode.ADD_RUN_REQUEST_ERROR_REQUEST_DB.getMessage());
		}

	}

	@Override
	public ResultData<PageInfo<RunResultPojo>> getResult(String projectName,Integer pageNum,Integer pageSize) {
		List<RunResultPojo> resultList = new ArrayList<RunResultPojo>();
		// 判断入参
		if("0".equals(String.valueOf(pageNum)) || "null".equals(String.valueOf(pageNum)) || pageNum <= 0) {
			pageNum = 1;
		}
		if("0".equals(String.valueOf(pageSize)) || "null".equals(String.valueOf(pageSize)) || pageSize <= 0) {
			pageSize = 10;
		}
		if(projectName == null || projectName.isEmpty()) {
			PageHelper.startPage(pageNum, pageSize);
			resultList = this.runResultMapper.getResultList(null);		
		}else {
			PageHelper.startPage(pageNum, pageSize);
			resultList = this.runResultMapper.getResultList(projectName);
		}
		PageInfo<RunResultPojo> page = new PageInfo<RunResultPojo>(resultList);
		if(pageNum > page.getPages()) {
			page.setList(new ArrayList<RunResultPojo>());
		}
		return ResultData.success(page);

	}

	/**
	 * 更新运行结果，添加成功数，失败数等数据
	 */
	@Override
	public ResultData<Integer> updateResult(RunResultBean runResultBean) {
		// 判断id不能为空
		if (runResultBean.getId() == null) {
			log.error("id为空");
			return ResultData.fail(RunRequestCode.UPDATE_RUN_REQUEST_ERROR_ID_IS_NULL.getCode(),RunRequestCode.UPDATE_RUN_REQUEST_ERROR_ID_IS_NULL.getMessage());
		}

		RunResultPojo runResultPojo = new RunResultPojo();
		runResultPojo.setId(runResultBean.getId());
		runResultPojo.setResultsSuccess(runResultBean.getResultsSuccess());
		runResultPojo.setResultsFail(runResultBean.getResultsFail());
		runResultPojo.setResultsSkip(runResultBean.getResultsSkip());
		if(runResultBean.getEndTime() == null) {
			runResultPojo.setEndTime(new Timestamp (System.currentTimeMillis()));
		}else {
			runResultPojo.setEndTime(runResultBean.getEndTime());
		}
		
		runResultPojo.setResultHtmlUrl(runResultBean.getResultHtmlUrl());
		runResultPojo.setResultLogUrl(runResultBean.getResultLogUrl());
		// 更新本地运行结果
		log.info("数据库更新:" + JSONObject.toJSONString(runResultPojo));
		Integer updateResult = this.runResultMapper.updateResultById(runResultPojo);
		if (updateResult != 1) {
			return ResultData.fail(RunRequestCode.UPDATE_RUN_REQUEST_ERROR_REQUEST_DB.getCode(),
					RunRequestCode.UPDATE_RUN_REQUEST_ERROR_REQUEST_DB.getMessage());
		}
		return ResultData.success(updateResult);
	}

}
