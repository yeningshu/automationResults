/**
 * @author yedeng
 * @date 2022年11月24日
 * 
 */
package com.example.automationResults.util.enumCode;

public enum ProjectCode {
	ADD_PROJECT_ERROR_PROJECT_NAME(-1001,"新增项目失败--项目名称为空"),
	ADD_PROJECT_ERROR_PROJECT_USER(-1002,"新增项目失败--项目负责人为空"),
	ADD_PROJECT_ERROR_PROJECT_DB(-1003,"新增项目失败--入库失败"),
	ADD_PROJECT_ERROR_PROJECT_NAME_REPEAT(-1004,"新增项目失败--项目名称已存在"),
	CHANGE_PROJECT_ERROR_PARAM_IS_NULL(-1005,"入参值projectId或者status存在为空"),
	CHANGE_PROJECT_ERROR_STATUS_LIMITS(-1006,"status超出取值范围"),
	CHANGE_PROJECT_ERROR_STATUS_DB(-1007,"操作数据库失败");
	
	
	private Integer code;
	
	private String  message;
	
	ProjectCode(Integer code, String message) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.message = message;
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
		 for (ProjectCode c : ProjectCode.values()) {  
	           if (c.getCode() == code) {  
	               return c.message;  
	           }  	          
	}
		 return null;
}

}
