/**
 * @author yedeng
 * @date 2022年12月1日
 * 
 */
package com.example.automationResults.pojo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class FailResultPojo {
	
	private Integer id;
	
	/**
	 * 取运行表id
	 */
	private Integer runId;
	
	/**
	 * 项目id
	 */
	private Integer projectId;
	
	/**
	 * 失败的类方法
	 */
	private String failMethod;
	
	/**
	 * 失败原因
	 */
	private String failMessage;
	
	/**
	 * 归属人
	 */
	private String owner;
	
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 添加时间
	 */
	private Timestamp createTime;
	/**
	 * 确认通知人
	 */
	private String identifyPeople;
	
	/**
	 * 通知消息
	 */
	private String notificationMessage;
	
	/**
	 * 确认时间
	 */
	private Timestamp notificationTime;
	

}
