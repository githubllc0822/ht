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
		// TODO Auto-generated method stub
		
		//需要将token密码进行加密处理
		UsernamePasswordToken loginToken=(UsernamePasswordToken) token;
		String username=loginToken.getUsername();
		String psw=new String(loginToken.getPassword());//或者String.valueof(char[]);
		
		String md5Psw=MD5HashPassword.getPsw(psw, username);
		//将密码存入令牌中
		loginToken.setPassword(md5Psw.toCharArray());
		//将用户输入的内容和真实数据做匹配
		return super.doCredentialsMatch(loginToken, info);
	}
	
}
