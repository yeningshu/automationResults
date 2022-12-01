/**
 * @author yedeng
 * @date 2022年11月23日
 * 
 */
package com.example.automationResults.util;

import com.example.automationResults.util.enumCode.RequestCode;

public class ResultData <T> {

    //返回状态码
    private Integer status;
    //返回消息
    private String message;
    //返回数据
    private T data;
    
  	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	//Success结果
    public static  <T> ResultData<T> success(T data){
        ResultData<T> resultData=new ResultData<>();
        resultData.setStatus(RequestCode.SUCCESS.getCode());
        resultData.setMessage(RequestCode.SUCCESS.getMessage());
        resultData.setData(data);
        return resultData;
    }
    //Fail结果
    public static <T> ResultData<T> fail(int code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
//        resultData.setData(null);
        return resultData;
    }
    


}
