/**
 * @author yedeng
 * @date 2022年11月24日
 * 
 */
package com.example.automationResults.serviceImp.projectImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.automationResults.bean.project.ProjectBean;
import com.example.automationResults.mapper.ProjectMapper;
import com.example.automationResults.pojo.ProjectPojo;
import com.example.automationResults.service.project.ProjectService;
import com.example.automationResults.util.enumCode.ProjectCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProjectOpetate implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;
	
	/**
	 * 新增项目
	 */
	@Override
	public Integer addProject(ProjectBean projectbean) {

		if (projectbean.getProjectUser().isEmpty()) {
			log.error("项目名为空");
			return ProjectCode.ADD_PROJECT_ERROR_PROJECT_NAME.getCode();			
		}
		if(projectbean.getProjectUser().isEmpty()) {
			log.error("项目负责人为空");
			return ProjectCode.ADD_PROJECT_ERROR_PROJECT_USER.getCode();	
		}
		Integer projectNum = this.projectMapper.selectProjiectNumByProjectName(projectbean.getProjectName());
		if(projectNum !=0) {
			log.error("该项目已存在" + projectbean.getProjectName());
			return ProjectCode.ADD_PROJECT_ERROR_PROJECT_NAME_REPEAT.getCode();	
		}
		// 数据入库,返回项目条数
		Integer insertProject = this.projectMapper.insertProject(projectbean.getProjectName(),projectbean.getProjectUser());
		if(insertProject != 1) {
			log.error("新建项目入库失败");
			return ProjectCode.ADD_PROJECT_ERROR_PROJECT_DB.getCode();
		}
		return insertProject;
	}

	/**
	 * 变更项目状态
	 */
	@Override
	public Integer changeProject(Integer projectId, String status) {
		Integer updateProjectStatus = this.projectMapper.updateProjectStatus(projectId, status);
		return updateProjectStatus;
	}
	
	/**
	 * 查询项目列表，要做分页
	 */
	@Override
	public List<ProjectPojo> getProjectList() {
		List<ProjectPojo> projectList = this.projectMapper.getProjectList();
		log.info("查询项目列表数量为:" + projectList.size());
		return projectList;
	}

}
