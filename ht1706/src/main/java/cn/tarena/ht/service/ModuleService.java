package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Module;

public interface ModuleService {

	List<Module> findAll();

	void updateState(String[] moduleIds, int state);

	List<String> findModuleIdsByRoleId(String roleId);


	void saveRoleModule(String roleId, String[] moduleIds);

	void saveModule(Module module);

	void deleteModule(String moduleId);

	Module findById(String moduleId);

}
