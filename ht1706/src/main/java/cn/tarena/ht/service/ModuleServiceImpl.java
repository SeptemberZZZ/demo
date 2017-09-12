package cn.tarena.ht.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;

@Service
public class ModuleServiceImpl implements ModuleService{
	@Autowired
	private ModuleMapper moduleMapper;

	@Override
	public List<Module> findAll() {
		return moduleMapper.findAll();
	}

	@Override
	public void updateState(String[] moduleIds, int state) {
		moduleMapper.updateState(moduleIds,state);
	}

	@Override
	public List<String> findModuleIdsByRoleId(String roleId) {
		return moduleMapper.findModuleIdsByRoleId(roleId);
	}

	@Override
	public void saveRoleModule(String roleId, String[] moduleIds) {
		moduleMapper.deleteRoleModule(roleId);
		for (String moduleId : moduleIds) {
			moduleMapper.saveRoleMoule(roleId,moduleId);
		}
	}

	@Override
	public void saveModule(Module module) {
		module.setModuleId(UUID.randomUUID().toString());
		moduleMapper.saveModule(module);
	}

	@Override
	public void deleteModule(String moduleId) {
		moduleMapper.deleteRole(moduleId);
		moduleMapper.deleteModule(moduleId);;
	}

	@Override
	public Module findById(String moduleId) {
		return moduleMapper.findById(moduleId);
	}

}
