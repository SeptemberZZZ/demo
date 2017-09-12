package cn.tarena.ht.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;

@Controller
public class LoginController {
	
	@RequestMapping("toLogin")
	public String toLogin(){
		return "sysadmin/login/login";
	}
	
	@RequestMapping("login")
	public String login(String userName,String password,Model model){
		//1.判断用户输入内容是否为空
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			model.addAttribute("errorInfo","用户名或密码不能为空");
			return "sysadmin/login/login";
		}
		
		//获取subject对象
		Subject subject = SecurityUtils.getSubject();
		
		//定义登录令牌(票)
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		try {
			subject.login(token);
			User user = (User) subject.getPrincipal();
			subject.getSession().setAttribute("SessionUser", user);
			return "redirect:/home";  //如果登录成功,shiro将会放行所有请求
			//表示登录成功
		} catch (AuthenticationException e) {
			//表示登录失败
			model.addAttribute("errorInfo","用户名或密码错误");
			e.printStackTrace();
			return "sysadmin/login/login";
		} catch (Exception e){
			//表示位置错误
			e.printStackTrace();
			model.addAttribute("errorInfo","发现未知错误,联系管理员9527.");
			return "sysadmin/login/login";
		}
		
	}
	
	/*@RequestMapping("login")
	public String login(String userName,String password,Model model,HttpSession session){
		//1.判断用户输入内容是否为空
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			model.addAttribute("errorInfo","用户名或密码不能为空");
			return "sysadmin/login/login";
		}
		//2.通过用户名密码,进行查询操作,得到User对象
		String md5Password = MD5HashPassword.getPassword(userName, password);
		
		User user = UserService.findByUP(userName,md5Password);
		
		//3.如果User为null,证明用户名密码不正确 ,编辑提示信息,并跳转回login.jsp
		if(user == null){
			model.addAttribute("errorInfo","用户名或密码错误");
			return "sysadmin/login/login";
		}
		//4.如果User不为null,证明用户名密码正确,跳转到系统首页
		session.setAttribute("SessionUser", user);
		return "redirect:/home";
	}*/
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("SessionUser");
		return "sysadmin/login/login";
	}
	
	
}
