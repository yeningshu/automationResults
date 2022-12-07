/**
 * @author yedeng
 * @date 2022年11月21日
 * 
 */
package com.example.automationResults.pojo;
import java.sql.Timestamp;

import lombok.Data;

/**
 * sql返回结果，字段值要和数据库保持一致
 * @author yedeng
 * @Title	
 * @date 2022年11月21日
 */
@Data
public class ProjectPojo {
	private Integer projectId;
	private String projectName;
	private String status;
	private String projectUser;
	private Timestamp createTime;
}
