/**
 * @author yedeng
 * @date 2022年11月24日
 * 
 */
package com.example.automationResults.util.enumCode;

public enum FailRequestCode {
	ADD_FAIL_REQUEST_ERROR_PARAM_IS_NULL(-4001,"新增失败结果失败--runId为空"),
	ADD_FAIL_REQUEST_ERROR_REQUEST_DB(-4002, "新增失败结果失败--入库失败"),
	
	UPDATE_FAIL_REQUEST_ERROR_STATUS(-4003, "更新失败结果失败--status不在范围内"),
	UPDATE_FAIL_REQUEST_ERROR_ID_IS_NULL(-4004, "更新失败结果失败--id不能为空"),
	UPDATE_FAIL_REQUEST_ERROR_REQUEST_DB(-4005, "更新失败结果失败--入库失败"),
	
	SELECT_FAIL_REQUEST_ERROR_PARAM_IS_NULL(-4006, "查询失败结果失败--runId为空");

	private Integer code;

	private String message;

	FailRequestCode(Integer code, String message) {
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
		for (FailRequestCode c : FailRequestCode.values()) {
			if (c.getCode() == code) {
				return c.message;
			}
		}
		return null;
	}

}
