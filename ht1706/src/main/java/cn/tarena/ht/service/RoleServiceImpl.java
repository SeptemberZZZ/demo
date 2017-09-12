package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> findAll() {
		return roleMapper.findAll();
	}

	@Override
	public void deleteRole(String[] roleIds) {
		for (String roleId : roleIds) {
			roleMapper.deleteUserRole(roleId);
		}
		roleMapper.deleteRole(roleIds);
	}

	@Override
	public void saveRole(Role role) {
		role.setRoleId(UUID.randomUUID().toString());
		role.setCreateTime(new Date());
		role.setUpdateTime(role.getCreateTime());
		roleMapper.saveRole(role);
	}

	@Override
	public Role findById(String roleId) {
		return roleMapper.findById(roleId);
	}

	@Override
	public List<String> findRoleIdByUserId(String userId) {
		return roleMapper.findRoleIdByUserId(userId);
	}
}
