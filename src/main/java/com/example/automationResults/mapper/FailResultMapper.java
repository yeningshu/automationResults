/**
 * @author yedeng
 * @date 2022年12月1日
 * 
 */
package com.example.automationResults.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.automationResults.pojo.FailResultPojo;

@Mapper
public interface FailResultMapper {
	
	/**
	 * 获取列表
	 * @return
	 */
	public List<FailResultPojo> getFailResultList(Integer runId);
	
	/**
	 * 批量添加
	 * @param failResult
	 * @return
	 */
	public Integer insertFailResult(List<FailResultPojo> failResult);
	
	/**
	 * 状态变更
	 * @param id、status、identify_people、notification_message、notification_time
	 * @return
	 */
	public Integer updateStatus(FailResultPojo failResultPojo);
}
