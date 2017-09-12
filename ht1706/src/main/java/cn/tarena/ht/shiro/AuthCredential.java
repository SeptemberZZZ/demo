package cn.tarena.ht.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.tarena.ht.tool.MD5HashPassword;

//shiro密码加密的处理方式
public class AuthCredential extends  SimpleCredentialsMatcher{
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		
		UsernamePasswordToken loginToken = (UsernamePasswordToken)token;
		String username = loginToken.getUsername();
		String password = String.valueOf(loginToken.getPassword());
		String Md5Password = MD5HashPassword.getPassword(username, password);
		loginToken.setPassword(Md5Password.toCharArray());
		//将用户输入的内容和真实数据匹配
		return super.doCredentialsMatch(loginToken, info);
	}
}
