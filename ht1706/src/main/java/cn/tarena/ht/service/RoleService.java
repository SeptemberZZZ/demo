package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Role;

public interface RoleService {
	public List<Role> findAll();

	public void deleteRole(String[] roleIds);

	public void saveRole(Role role);

	public Role findById(String roleId);

	public List<String> findRoleIdByUserId(String userId);
}
