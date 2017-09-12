package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller
@RequestMapping("/sysadmin/dept")
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Dept> deptList = deptService.findAll();
		model.addAttribute("deptList", deptList);
		return "/sysadmin/dept/jDeptList";
	}
	
	/*
	 * @RequestParam
	 * 	value表示页面提交的参数名称
	 * 	required表示当前参数是否必须提交
	 * 	defaultValue 默认值,即使没有参数也会自动添加默认值
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="deptId",required=true)String[] deptIds){
		deptService.deleteDepts(deptIds);
		
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/start")
	public String toStart(@RequestParam(value="deptId",required=true)String[] deptIds){
		int state = 1;
		
		deptService.updateState(deptIds,state);
		
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/stop")
	public String toStop(@RequestParam(value="deptId",required=true)String[] deptIds){
		int state = 0;
		//System.out.println(state);
		deptService.updateState(deptIds,state);
		
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/tocreate")
	public String toCreate(Model model){
		List<Dept> parentList = deptService.findAll();
		model.addAttribute("parentList", parentList);
		return "/sysadmin/dept/jDeptCreate";
	}
	
	@RequestMapping("/save")
	public String saveDept(Dept dept){
		
		deptService.saveDept(dept);
		
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/toview")
	public String toView(@RequestParam(required=true)String deptId,Model model){
		Dept dept = deptService.findDeptById(deptId);
		model.addAttribute("dept", dept);
		return "/sysadmin/dept/jDeptView";
	}
	
	@RequestMapping("/toupdate")
	public String toUpdate(@RequestParam(required=true)String deptId,Model model){
		Dept dept = deptService.findDeptById(deptId);
		
		List<Dept> parentList = deptService.findParentlist(deptId);
		model.addAttribute("parentList", parentList);
		model.addAttribute("dept", dept);
		return "/sysadmin/dept/jDeptUpdate";
	}
	
	@RequestMapping("/update")
	public String updateDept(Dept dept){
		
		deptService.updateDept(dept);
		
		return "redirect:/sysadmin/dept/list";
	}
}
