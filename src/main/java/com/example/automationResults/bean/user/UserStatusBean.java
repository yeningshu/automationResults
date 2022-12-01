/**
 * @author yedeng
 * @date 2022年11月23日
 * 
 */
package com.example.automationResults.bean.user;

import lombok.Data;

@Data
public class UserStatusBean {
	
	/**
	 * 用户id
	 */
	private Integer userId;
	
	/**
	 * 是否使用该用户
	 */
	private boolean isUsing;

}
