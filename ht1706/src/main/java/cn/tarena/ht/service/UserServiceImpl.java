package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.tool.MD5HashPassword;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}
	@Override
	public void updateState(String[] userIds, int state) {
		userMapper.updateState(userIds,state);
	}
	@Override
	public void deleteUser(String[] userIds) {
		userInfoMapper.deleteUserInfo(userIds);
		
		for (String userId : userIds) {
			userMapper.deleteUserRole(userId);
		}
		
		userMapper.deleteUser(userIds);
	}
	@Override
	public void saveUser(User user) {
		user.setPassword(MD5HashPassword.getPassword(user.getUsername(), user.getPassword()));
		userInfoMapper.saveUserInfo(user.getUserInfo());
		userMapper.saveUser(user);
	}
	@Override
	public User findById(String userId) {
		return userMapper.findById(userId);
	}
	@Override
	public void updateUser(User user) {
		
		userInfoMapper.updateUserInfo(user.getUserInfo());
		userMapper.updateUser(user);
	}
	@Override
	public void saveUserRole(String userId, String[] roleIds) {
		
		for (String roleId : roleIds) {
			userMapper.saveUserRole(userId,roleId);
		}
	}
	@Override
	public void deleteUserRole(String userId) {
		
		userMapper.deleteUserRole(userId);
	}
	@Override
	public User findByUP(String userName, String password) {
		return userMapper.findByUP(userName,password);
	}
	@Override
	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}
	@Override
	public List<String> findPrivilegeList(String userId) {
		return userMapper.findPrivilegeList(userId);
	}
	
}
