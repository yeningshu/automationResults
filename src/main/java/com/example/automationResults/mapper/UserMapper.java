/**
 * @author yedeng
 * @date 2022年11月22日
 * 
 */
package com.example.automationResults.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.automationResults.dao.UserDAO;
import com.example.automationResults.pojo.UserPojo;

@Mapper
public interface UserMapper {
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public Integer insertUser(UserDAO user);
	
	/**
	 * 通过用户名查询用户数
	 * @param userName
	 * @return
	 */
	public Integer selectCountByUserName(String userName);
	/**
	 * 用户状态变更
	 * @param id
	 * @return
	 */
	public Integer updateUserStatus(@Param("status")String status,@Param("id")Integer id);
	
	/**
	 * 查询用户
	 * @return
	 */
	public List<UserPojo> selectByUserNameOrId(@Param("userName")String userName, @Param("id")Integer id);
}
