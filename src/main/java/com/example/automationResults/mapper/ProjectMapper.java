/**
 * @author yedeng
 * @date 2022年11月21日
 * 
 */
package com.example.automationResults.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.automationResults.pojo.ProjectPojo;

@Mapper
public interface ProjectMapper {
	/**
	 * 获取项目列表
	 * @return
	 */
	public List<ProjectPojo> getProjectList();
	
	/**
	 * 新增项目
	 * @param projectName
	 * @param projectUser
	 * @return
	 */
	public Integer insertProject(@Param("projectName") String projectName,@Param("projectUser") String projectUser);
	
	/**
	 * 修改项目状态
	 * @param status
	 * @param projectId
	 * @return
	 */
	public Integer updateProjectStatus(@Param("projectId")Integer projectId,@Param("status")String status);
	
	/**
	 * 通过项目名获取项目数量
	 * @param projectName
	 * @return
	 */
	public Integer selectProjiectNumByProjectName(String projectName);
}
