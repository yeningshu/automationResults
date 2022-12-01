/**
 * @author yedeng
 * @date 2022年11月22日
 * 
 */
package com.example.automationResults.bean.user;

import java.sql.Timestamp;

import lombok.Data;

/**
 * 接收前端传的JavaBean对象
 * @author yedeng
 * @Title	
 * @date 2022年11月22日
 */
@Data
public class UserBean {
	
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 用户名
	 */
	private String userName; 
	/**
	 * 密码
	 */
	private String passWord;
	/**
	 * 企微地址
	 */
	private String userWxAddr;
	/**
	 * 邮箱地址
	 */
	private String userEmailAddr;
	
	/**
	 * 用户状态
	 */
	private String status;
	
	/**
	 * 创建时间
	 */
	private Timestamp crteteTime;
}
