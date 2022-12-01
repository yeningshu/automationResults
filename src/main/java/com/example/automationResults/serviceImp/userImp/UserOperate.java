/**
 * @author yedeng
 * @date 2022年11月22日
 * 
 */
package com.example.automationResults.serviceImp.userImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.automationResults.bean.user.UserBean;
import com.example.automationResults.dao.UserDAO;
import com.example.automationResults.mapper.UserMapper;
import com.example.automationResults.pojo.UserPojo;
import com.example.automationResults.service.user.UserService;
import com.example.automationResults.util.ResultData;
import com.example.automationResults.util.enumCode.UserCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserOperate implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 新增用户
	 */
	@Override
	public ResultData<Integer> addUser(UserBean user) {
		// 入参校验
		if(user.getUserName().isEmpty()) {
			log.error("入参用户名为空");
			return ResultData.fail(UserCode.ADD_USER_ERROR_USER_NAME.getCode(), UserCode.ADD_USER_ERROR_USER_NAME.getMessage());
		}
		// 查询用户是否已存在
		Integer selectCountByProjectName = userMapper.selectCountByUserName(user.getUserName());
		if(selectCountByProjectName != 0) {
			log.error("该用户名已存在" + user.getUserName());
			return ResultData.fail(UserCode.ADD_USER_ERROR_USER_NAME_REPEAT.getCode(), UserCode.ADD_USER_ERROR_USER_NAME_REPEAT.getMessage());

		}
		// 执行操作
		log.info("开始增加新用户");
		UserDAO userDao = new UserDAO();
		userDao.setUserName(user.getUserName());
		userDao.setPassWord(user.getPassWord());
		userDao.setUserWxAddr(user.getUserWxAddr());
		userDao.setUserEmailAddr(user.getUserEmailAddr());
		// 入库操作
		Integer insertUserNumber = userMapper.insertUser(userDao);
		if (insertUserNumber == 1) {
			log.info("增加新用户成功");
			return ResultData.success(insertUserNumber);
		}else {
			log.info("入库失败");
			return ResultData.fail(UserCode.ADD_USER_ERROR_USER_DB.getCode(), UserCode.ADD_USER_ERROR_USER_DB.getMessage());
		}
		
	}
	
	/**
	 * 是否启用用户，true 启用，false停用
	 * @return 
	 */
	@Override
	public ResultData<Integer> changeUser(Integer userId, boolean isUsing) {
		// 入参校验
		if(userId == null) {
			log.error("入参为空");
			return ResultData.fail(UserCode.CHANGE_USER_ERROR_PARAM_IS_NULL.getCode(), UserCode.CHANGE_USER_ERROR_PARAM_IS_NULL.getMessage());
		}
		Integer updateUserNum = -1;
		// 操作账号状态
		if(isUsing) {
			log.info("启用用户");
			updateUserNum = this.userMapper.updateUserStatus("0", userId);
		}else {
			log.info("停用用户");
			updateUserNum = this.userMapper.updateUserStatus("1", userId);			
		}
		if(updateUserNum != 1) {
			log.error("改变用户状态失败");
			return ResultData.fail(UserCode.CHANGE_USER_ERROR_STATUS_DB.getCode(), UserCode.CHANGE_USER_ERROR_STATUS_DB.getMessage());
		}
		return ResultData.success(updateUserNum);
		
	}
	
	/**
	 * 获取用户列表
	 */
	@Override
	public ResultData<List<UserPojo>> getUserList(String userName, Integer userId) {	
		List<UserPojo> userList = this.userMapper.selectByUserNameOrId(userName, userId);
		log.info("查询用户列表" + userList);
		return ResultData.success(userList);		
	}

}
