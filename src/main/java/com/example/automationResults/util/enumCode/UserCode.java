/**
 * @author yedeng
 * @date 2022年11月24日
 * 
 */
package com.example.automationResults.util.enumCode;

public enum UserCode {
	ADD_USER_ERROR_USER_NAME(-2001,"新增用户失败--用户名称为空"),
	ADD_USER_ERROR_USER_DB(-2003,"新增用户失败--入库失败"),
	ADD_USER_ERROR_USER_NAME_REPEAT(-2004,"新增用户失败--用户名称已存在"),
	CHANGE_USER_ERROR_PARAM_IS_NULL(-2005,"入参值projectId或者status存在为空"),
	CHANGE_USER_ERROR_STATUS_DB(-2007,"变更数据库失败");
	
	
	private Integer code;
	
	private String  message;
	
	UserCode(Integer code, String message) {
		this.code = code;
		this.message = message;
		// TODO Auto-generated constructor stub
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	/**
	 * 通过code获取message
	 * @param code
	 * @return
	 */
	public String getMessage(Integer code) {
		 for (UserCode c : UserCode.values()) {  
	           if (c.getCode() == code) {  
	               return c.message;  
	           }  	          
	}
		 return null;
}

}
