/**
 * @author yedeng
 * @date 2022年11月24日
 * 
 */
package com.example.automationResults.util.enumCode;

public enum RunRequestCode {
	ADD_RUN_REQUEST_ERROR_PARAM_IS_NULL(-3001,"新增运行结果失败--项目id或者名称为空"),
	ADD_RUN_REQUEST_ERROR_REQUEST_DB(-3002, "新增运行结果失败--入库失败"),

	UPDATE_RUN_REQUEST_ERROR_ID_IS_NULL(-3003, "更新运行结果失败--id不能为空"),
	UPDATE_RUN_REQUEST_ERROR_REQUEST_DB(-3004, "更新运行结果失败--入库失败");

	private Integer code;

	private String message;

	RunRequestCode(Integer code, String message) {
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
	 * 
	 * @param code
	 * @return
	 */
	public String getMessage(Integer code) {
		for (RunRequestCode c : RunRequestCode.values()) {
			if (c.getCode() == code) {
				return c.message;
			}
		}
		return null;
	}

}
