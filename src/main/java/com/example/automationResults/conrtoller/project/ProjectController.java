/**
 * @author yedeng
 * @date 2022年11月24日
 * 
 */
package com.example.automationResults.conrtoller.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.automationResults.bean.project.ProjectBean;
import com.example.automationResults.pojo.ProjectPojo;
import com.example.automationResults.service.project.ProjectService;
import com.example.automationResults.util.ResultData;
import com.example.automationResults.util.enumCode.ProjectCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@SpringBootApplication
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	/**
	 * 新增项目
	 * @param projectBean 
	 */
	@RequestMapping("/project/addProject")
	@ResponseBody
	public ResultData<Integer> addProject(@RequestBody ProjectBean projectBean) {
		log.info("前端入参为:" + JSONObject.toJSONString(projectBean)); 
		
		Integer addProjectNum = this.projectService.addProject(projectBean);
		// 常见异常返回
		if(addProjectNum == ProjectCode.ADD_PROJECT_ERROR_PROJECT_NAME.getCode()) {
			log.error(ProjectCode.ADD_PROJECT_ERROR_PROJECT_NAME.getMessage(addProjectNum));
			return ResultData.fail(addProjectNum, ProjectCode.ADD_PROJECT_ERROR_PROJECT_NAME.getMessage(addProjectNum));
		}
		if(addProjectNum == ProjectCode.ADD_PROJECT_ERROR_PROJECT_USER.getCode()) {
			log.error(ProjectCode.ADD_PROJECT_ERROR_PROJECT_USER.getMessage(addProjectNum));
			return ResultData.fail(addProjectNum, ProjectCode.ADD_PROJECT_ERROR_PROJECT_USER.getMessage(addProjectNum));
		}
		if(addProjectNum == ProjectCode.ADD_PROJECT_ERROR_PROJECT_DB.getCode()) {
			log.error(ProjectCode.ADD_PROJECT_ERROR_PROJECT_DB.getMessage(addProjectNum));
			return ResultData.fail(addProjectNum, ProjectCode.ADD_PROJECT_ERROR_PROJECT_DB.getMessage(addProjectNum));
		}
		if(addProjectNum == ProjectCode.ADD_PROJECT_ERROR_PROJECT_NAME_REPEAT.getCode()) {
			log.error(ProjectCode.ADD_PROJECT_ERROR_PROJECT_NAME_REPEAT.getMessage(addProjectNum));
			return ResultData.fail(addProjectNum, ProjectCode.ADD_PROJECT_ERROR_PROJECT_NAME_REPEAT.getMessage(addProjectNum));
		}
		
		log.info("新增项目成功,数量为:" + addProjectNum);
		
		return ResultData.success(addProjectNum);
		
		
	}
	
	/**
	 * 变更项目状态
	 * @param userStatus
	 * @return 
	 */
	@RequestMapping("/project/changeProjectStatus")
	@ResponseBody
	public ResultData<Integer> changeProjectStatus(Integer projectId, String status) {
		log.info("前端入参为:projectId" + projectId + ",status:" + status); 
		// 入参校验
		if(projectId == null || status.isEmpty()) {
			log.error("入参有为空");
			return ResultData.fail(ProjectCode.CHANGE_PROJECT_ERROR_PARAM_IS_NULL.getCode(), ProjectCode.CHANGE_PROJECT_ERROR_PARAM_IS_NULL.getMessage());
		}
		if("0".equals(status)||"1".equals(status)) {
			log.error("status取值错误");
			return ResultData.fail(ProjectCode.CHANGE_PROJECT_ERROR_STATUS_LIMITS.getCode(), ProjectCode.CHANGE_PROJECT_ERROR_STATUS_LIMITS.getMessage());			
		}
		// 变更
		Integer changeProjectNum = this.projectService.changeProject(projectId, status);
		// 数据库变更校验
		if(changeProjectNum != 1) {
			log.error("修改数据库失败");
			ResultData.fail(ProjectCode.CHANGE_PROJECT_ERROR_STATUS_DB.getCode(), ProjectCode.CHANGE_PROJECT_ERROR_STATUS_DB.getMessage());
		}
		//修改返回值
		log.info("项目修改完成");
		return ResultData.success(changeProjectNum);
	}
	
	/**
	 * 查询项目列表
	 */
	@GetMapping(value = "/project/getProjectList")
	@ResponseBody
	public ResultData<List<ProjectPojo>> getProjectList() {
		List<ProjectPojo> projectList = this.projectService.getProjectList();
		//修改返回值
		log.info(projectList.toString());
		return ResultData.success(projectList);
	}
	

}
