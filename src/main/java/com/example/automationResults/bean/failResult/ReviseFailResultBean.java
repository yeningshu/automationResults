/**
 * @author yedeng
 * @date 2022年12月1日
 * 
 */
package com.example.automationResults.bean.failResult;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReviseFailResultBean {
	
	private Integer id;
	
	/**
	 * 状态
	 */
	private String status;

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
