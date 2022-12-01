/**
 * @author yedeng
 * @date 2022年11月22日
 * 
 */
package com.example.automationResults.dao;

import lombok.Data;

@Data
public class UserDAO {
	
	private Integer id; 
	
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

}
