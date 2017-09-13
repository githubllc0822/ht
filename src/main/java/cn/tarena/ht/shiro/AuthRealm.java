package cn.tarena.ht.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import cn.tarena.ht.service.*;
public class AuthRealm extends AuthorizingRealm{
	@Autowired
	private UserService service;
	//权限认证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		//获取用户的真实对象
		User user=(User)SecurityUtils.getSubject().getPrincipal();
		//List<String> list=new ArrayList<String>();
		List<String> list=service.findPrivilegeByUserId(user.getUserId());
		//System.err.println(555555);
//		list.add("货运管理");
//		list.add("基础信息");
//		list.add("系统管理");
		
		//为权限控制提供真实数据
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addStringPermissions(list);
		return info;
	}
	//登录认证  shiro安全中心调用用户真实信息，传递token数据，
	//需要为shiro安全中心提供真实的用户数据  需要根据用户名查询user对象
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//1.转化为usernameandpasswordtoken
		UsernamePasswordToken loginToken=(UsernamePasswordToken) token;
		
		//2.获取用户名
		String username=loginToken.getUsername();
		//3.根据用户名查询对象
		User user=service.findUserByUsername(username);
		
		//4.把user返回给shiro安全中心
		//1.principal   表示用户的真实对象
		
		//2.credentials  校验密码使用的真实密码
		//3.realmName	realm的名称
		AuthenticationInfo info=new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		
		//问题：用户输入的密码是明文密码  用户的真是密码是密文 如何做到匹配
		return info;
	}
	
	
	
	
}
