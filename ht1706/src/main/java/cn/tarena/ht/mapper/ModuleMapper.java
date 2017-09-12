package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Module;

public interface ModuleMapper {
	
	public List<Module> findAll();

	public void updateState(@Param("moduleIds")String[] moduleIds, @Param("state")int state);

	@Select("select module_id from role_module_p where role_id = #{roleId}")
	public List<String> findModuleIdsByRoleId(String roleId);

	@Delete("delete from role_module_p where role_id = #{roleId}")
	public void deleteRoleModule(String roleId);

	@Insert("insert into role_module_p(role_id,module_id) values(#{roleId},#{moduleId})")
	public void saveRoleMoule(@Param("roleId")String roleId, @Param("moduleId")String moduleId);

	public void saveModule(Module module);

	@Delete("delete from module_p where module_id = #{moduleId}")
	public void deleteModule(String moduleId);

	@Delete("delete from role_module_p where module_id = #{moduleId}")
	public void deleteRole(String moduleId);

	public Module findById(String moduleId);
}
