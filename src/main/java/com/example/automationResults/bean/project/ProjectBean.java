/**
 * @author yedeng
 * @date 2022年11月24日
 * 
 */
package com.example.automationResults.bean.project;

import lombok.Data;

@Data
public class ProjectBean {
	/**
	 * 项目名称
	 */
	private String projectName;
	
	/**
	 * 项目状态
	 */
	private String status;
	
	/**
	 * 项目负责人
	 */
	private String projectUser;

}
