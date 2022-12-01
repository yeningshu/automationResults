/**
 * @author yedeng
 * @date 2022年11月23日
 * 
 */
package com.example.automationResults.pojo;

import lombok.Data;

@Data
public class UserPojo {
	
	/**
	 * 用户id
	 */
	private Integer userId;
	
	/**
	 * 用户名
	 */
	private String userName; 
	
	/**
	 * 企微地址
	 */
	private String userWxAddr;
	
	/**
	 * 邮箱地址
	 */
	private String userEmailAddr;

}
