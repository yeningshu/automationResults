/**
 * @author yedeng
 * @date 2022年11月21日
 * 
 */
package com.example.automationResults.dao;

import java.sql.Timestamp;

import lombok.Data;

/**
 * mapperSql入参类型
 * @author yedeng
 * @Title	
 * @date 2022年11月21日
 */
@Data
public class ProjectDAO {
	private Integer projectId;
	private String projectName;
	private String status;
	private String projectUser;
	private Timestamp creatTime;
}
