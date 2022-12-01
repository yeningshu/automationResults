/**
 * @author yedeng
 * @date 2022年11月22日
 * 
 */
package com.example.automationResults.conrtoller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.automationResults.bean.user.UserBean;
import com.example.automationResults.bean.user.UserStatusBean;
import com.example.automationResults.pojo.UserPojo;
import com.example.automationResults.service.user.UserService;
import com.example.automationResults.util.ResultData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@SpringBootApplication
public class UserConrtoller {
	
	@Autowired
	public UserService userService;
	
	/**
	 * 新增用户
	 * @param user
	 */
	@RequestMapping("/user/addUser")
	@ResponseBody
	public ResultData<Integer> addUser(@RequestBody UserBean user) {
		log.info("前端入参为:" + JSONObject.toJSONString(user));
		// 修改返回值
		return this.userService.addUser(user);
		
	}
	
	/**
	 * 变更用户状态
	 * @param userStatus
	 * @return 
	 */
	@RequestMapping("/user/changeUser")
	@ResponseBody
	public ResultData<Integer> changeUserStatus(@RequestBody UserStatusBean userStatus) {
		log.info("前端入参为:" + userStatus);
		return this.userService.changeUser(userStatus.getUserId(), userStatus.isUsing());
	}
	
	/**
	 * 查询用户列表
	 * @param userName
	 * @param userId
	 */
	@GetMapping(value = "/user/getUserList")
	@ResponseBody
	public ResultData<List<UserPojo>> getUserList(String userName, Integer userId) {
		log.info("前端入参为userName:" + userName + ",userId:" + userId);
		return this.userService.getUserList(userName,userId);
	}

}
