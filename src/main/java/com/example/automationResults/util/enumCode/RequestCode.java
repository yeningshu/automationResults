/**
 * @author yedeng
 * @date 2022年11月23日
 * 
 */
package com.example.automationResults.util.enumCode;

public enum RequestCode {
	
	  SUCCESS(0, "操作成功"),
	  ERROR(1, "操作失败");
	
	  
	   //自定义状态码
	    private  int code;
	    //自定义描述
	    private  String message;
	    
	    
		RequestCode(int code, String message) {
			this.code = code;
			this.message = message;
		}
		
		public int getCode() {
			return code;
		}
		public String getMessage() {
			return message;
		}

}
