package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.ModuleService;
import cn.tarena.ht.service.RoleService;

@Controller
@RequestMapping("/sysadmin/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("/list")
	public String findAll(Model model){
		
		List<Role> roleList = roleService.findAll();
		model.addAttribute("roleList", roleList);
		
		return "/sysadmin/role/jRoleList";
	}
	
	@RequestMapping("/delete")
	public String todelete(@RequestParam("roleId")String[] roleIds){
		
		roleService.deleteRole(roleIds);
		
		return "redirect:/sysadmin/role/list";
	}
	
	@RequestMapping("/tocreate")
	public String tocreate(){
		return "/sysadmin/role/jRoleCreate";
	}
	
	@RequestMapping("/save")
	public String saveRole(Role role){
		roleService.saveRole(role);
		return "redirect:/sysadmin/role/list";
	}
	
	@RequestMapping("/toview")
	public String toview(String roleId,Model model){
		Role role = roleService.findById(roleId);
		model.addAttribute("role", role);
		return "/sysadmin/role/jRoleView";
	}
	
	@RequestMapping("/tomodule")
	public String tomodule(Model model,String roleId) throws JsonProcessingException{
		
		List<String> moduleIdList = moduleService.findModuleIdsByRoleId(roleId);
		List<Module> moduleList = moduleService.findAll();
		for (Module module : moduleList) {
			if(moduleIdList.contains(module.getModuleId())){
				module.setChecked(true);
			}
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJson = objectMapper.writeValueAsString(moduleList);
		System.out.println(zTreeJson);
		model.addAttribute("zTreeJson", zTreeJson);
		model.addAttribute("roleId", roleId);
		return "/sysadmin/role/jRoleModule";
	}
	
	@RequestMapping("/saveRoleModule")
	public String saveUserRole(String roleId,String[] moduleIds){
		
		moduleService.saveRoleModule(roleId,moduleIds);
		
		return "redirect:/sysadmin/role/list";
	}
}
