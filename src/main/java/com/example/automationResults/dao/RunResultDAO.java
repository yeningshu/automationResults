/**
 * @author yedeng
 * @date 2022年11月25日
 * 
 */
package com.example.automationResults.dao;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RunResultDAO {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 项目id
	 */
	private Integer projectId;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 本次运行成功数
	 */
	private Integer resultsSuccess;
	/**
	 * 本次运行失败数
	 */
	private Integer resultsFail;
	/**
	 * 本次运行跳过数
	 */
	private Integer resultsSkip;
	/**
	 * 起始时间
	 */
	private Timestamp startTime;
	/**
	 * 结束时间
	 */
	private Timestamp endTime;
	/**
	 * 执行人
	 */
	private String executor;
	/**
	 * 报告URL地址
	 */
	private String resultHtmlUrl;
	/**
	 * 日志url地址
	 */
	private String resultLogUrl;
	

}
