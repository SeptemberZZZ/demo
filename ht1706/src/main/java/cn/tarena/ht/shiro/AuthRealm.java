package cn.tarena.ht.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.org.apache.xerces.internal.xs.StringList;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

public class AuthRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;

	//权限认证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		User user  = (User) SecurityUtils.getSubject().getPrincipal();
		
		List<String> pList = userService.findPrivilegeList(user.getUserId());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(pList);
		return null;
	}

	//登录认证 shiro安全中心调用realm查询用户真实信息.传递token数据
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//为shiro安全中心提供真实的用户数据  需要根据用户名查询user对象
		UsernamePasswordToken loginToken = (UsernamePasswordToken)token;
		String username = loginToken.getUsername();
		//根据用户名查询数据时，用户名必须唯一
		User user = userService.findByUsername(username);
		
		/*
		 * 1.principal  表示用户真实对象
		 * 2.credentials 校验密码时使用的(真实密码)
		 * 3.realmName  当前realm名称
		 */
		
		
		
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		
		
		return info;
	}
	
}
