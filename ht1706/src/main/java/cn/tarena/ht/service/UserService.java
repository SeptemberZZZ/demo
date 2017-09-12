package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.User;

public interface UserService {
	public List<User> findAll();

	public void updateState(String[] userIds, int state);

	public void deleteUser(String[] userIds);

	public void saveUser(User user);

	public User findById(String userId);

	public void updateUser(User user);

	public void saveUserRole(String userId, String[] roleIds);

	public void deleteUserRole(String userId);

	public User findByUP(String userName, String password);

	public User findByUsername(String username);

	public List<String> findPrivilegeList(String userId);
}
