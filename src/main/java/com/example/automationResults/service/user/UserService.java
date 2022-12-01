/**
 * @author yedeng
 * @date 2022年11月22日
 * 
 */
package com.example.automationResults.service.user;

import java.util.List;

import com.example.automationResults.bean.user.UserBean;
import com.example.automationResults.pojo.UserPojo;
import com.example.automationResults.util.ResultData;

/**
 * 用户相关操作
 * @author yedeng
 * @Title	
 * @date 2022年11月22日
 */
public interface UserService {
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	public ResultData<Integer> addUser(UserBean user);  // 增加用户
	/**
	 * 变更用户
	 * @param userId
	 * @param isUsing  true为启用，FALSE为暂停
	 * @return
	 */
	public ResultData<Integer> changeUser(Integer userId,boolean isUsing);   // 
	/**
	 * 获取用户列表
	 * @return 
	 */
	public ResultData<List<UserPojo>> getUserList(String userName, Integer id);  // 获取用户列表
}
