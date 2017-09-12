package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.User;

public interface UserMapper {
	public List<User> findAll();

	//多值参数,需要加注解
	public void updateState(@Param("userIds")String[] userIds, @Param("state")int state);

	public void deleteUser(String[] userIds);

	public void saveUser(User user);

	public User findById(String userId);

	public void updateUser(User user);

	@Insert("insert into role_user_p(role_id,user_id) values(#{roleId,jdbcType=VARCHAR},#{userId,jdbcType=VARCHAR})")
	public void saveUserRole(@Param("userId")String userId, @Param("roleId")String roleId);

	@Delete("delete from role_user_p where user_id = #{userId}")
	public void deleteUserRole(String userId);

	public User findByUP(@Param("username")String userName, @Param("password")String password);

	public User findByUsername(String username);

	public List<String> findPrivilegeList(String userId);
}
