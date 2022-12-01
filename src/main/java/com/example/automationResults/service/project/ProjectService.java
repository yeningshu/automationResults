/**
 * @author yedeng
 * @date 2022年11月24日
 * 
 */
package com.example.automationResults.service.project;

import java.util.List;


import com.example.automationResults.bean.project.ProjectBean;
import com.example.automationResults.pojo.ProjectPojo;


public interface ProjectService {
	/**
	 * 新增用户
	 * @param Projectbean
	 * @return
	 */
	public Integer addProject(ProjectBean Projectbean);
		
	/**
	 * 变更用户状态
	 * @param projectId 项目id
	 * @param status 项目状态 0启用, 1停用
	 * @return
	 */
	public Integer changeProject(Integer projectId, String status);
	
	/**
	 * 获取项目列表
	 * @return
	 */
	public List<ProjectPojo> getProjectList();
	
}
