package cn.tarena.ht.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserInfoService;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/sysadmin/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/list")
	public String fandAll(Model model){
		List<User> userList = userService.findAll();
		/*for (User user : userList) {
			System.out.println(user);
		}*/
		model.addAttribute("userList", userList);
		return "/sysadmin/user/jUserList";
	}
	
	@RequestMapping("/start")
	public String toStart(@RequestParam(value="userId",required=true)String[] userIds){
		int state = 1;
		userService.updateState(userIds,state);
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/stop")
	public String toStop(@RequestParam(value="userId",required=true)String[] userIds){
		int state = 0;
		userService.updateState(userIds,state);
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/delete")
	public String toDelete(@RequestParam(value="userId",required=true)String[] userIds){
		userService.deleteUser(userIds);
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/tocreate")
	public String toSave(Model model){
		List<Dept> deptList = deptService.findAll();
		List<UserInfo> managerList = userInfoService.findManagerList();
		model.addAttribute("deptList", deptList);
		model.addAttribute("managerList", managerList);
		return "/sysadmin/user/jUserCreate";
	}
	
	@RequestMapping("/save")
	public String saveUser(User user){
		UserInfo info = user.getUserInfo();
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		user.setCreateTime(new Date());
		user.setUpdateTime(user.getCreateTime());
		
		info.setUserInfoId(id);
		info.setCreateTime(user.getCreateTime());
		info.setUpdateTime(user.getUpdateTime());
		
		userService.saveUser(user);
		
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/toview")
	public String viewUser(String userId,Model model){
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		return "/sysadmin/user/jUserView";
	}
	
	@RequestMapping("/toupdate")
	public String toupdate(String userId,Model model){
		User user = userService.findById(userId);
		List<Dept> deptList = deptService.findAll();
		model.addAttribute("user", user);
		model.addAttribute("deptList", deptList);
		List<UserInfo> managerList = userInfoService.findManagerList();
		model.addAttribute("managerList", managerList);
		return "/sysadmin/user/jUserUpdate";
	}
	
	@RequestMapping("/update")
	public String updateUser(User user){
		UserInfo info = user.getUserInfo();
		user.setUpdateTime(new Date());
		info.setUpdateTime(user.getUpdateTime());
		info.setUserInfoId(user.getUserId());
		userService.updateUser(user);
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/torole")
	public String toRole(String userId,Model model) throws JsonProcessingException{
		List<String> roleIdList = roleService.findRoleIdByUserId(userId);

		List<Role> roleList = roleService.findAll();
		
		for (Role role : roleList) {
			if(roleIdList.contains(role.getRoleId())){
				role.setChecked(true);
			}
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String zTreeJson = objectMapper.writeValueAsString(roleList);
		model.addAttribute("zTreeJson", zTreeJson);
		model.addAttribute("userId", userId);
		return "/sysadmin/user/jUserRole";
	}
	
	@RequestMapping("/saveUserRole")
	public String saveUserRole(String userId,String[] roleIds){
		
		userService.deleteUserRole(userId);
		userService.saveUserRole(userId,roleIds);
		
		return "redirect:/sysadmin/user/list";
	}
	
}
