package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Role;

public interface RoleMapper {
	/*
	 * @Select
	 * @Update
	 * @Insert   简单单表操作时可以通过注解进行sql操作
	 * @Delete
	 * sql语句的返回值会自动根据方法返回值自动封装
	 */
	@Select("select * from role_p order by order_no")
	public List<Role> findAll();

	public void deleteRole(String[] roleIds);

	public void saveRole(Role role);

	@Select("select * from role_p where role_id = #{roleId}")
	public Role findById(String roleId);

	@Select("select role_id from role_user_p where user_id = #{userId}")
	public List<String> findRoleIdByUserId(String userId);

	@Delete("delete from role_user_p where role_id = #{roleId}")
	public void deleteUserRole(String roleId);
}
