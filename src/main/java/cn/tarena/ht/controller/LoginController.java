package cn.tarena.ht.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.tool.MD5HashPassword;



@Controller
public class LoginController {
	@Autowired
	private UserService service;
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "/sysadmin/login/login";
	}
	
	@RequestMapping("/login")
	public String login(String userName,String password,Model model,HttpSession session){
		/*
		 * 	判断用户输入的内容是否为空
		 * 通过用户名和密码进行查询操作 得到user对象
		 * 如果的为null，证明用户名和密码不正确  编辑提示信息 页面跳转到登录页面
		 * 如果user对象不为null  则证明用户名和密码正确  跳转到系统首页
		 * */
		System.err.println(userName);
		System.err.println(password);
		if(StringUtils.isEmpty(password) || StringUtils.isEmpty(userName)){
			//证明用户名或者密码为空
			model.addAttribute("errorInfo", "用户名或者密码不能为空");
			//转页面3中方式 转发 return 重定向
			//页面转向到登录页面 --此处不能写重定向，否则model中的数据无法传过去
			return "/sysadmin/login/login";
		}
		
		//1.获取subject对象
		Subject sub=SecurityUtils.getSubject();
		
		//2.定义登录的令牌  将用户名和密码包装为令牌
		UsernamePasswordToken token=new UsernamePasswordToken(userName, password);
		//3.通过subject进行登录操作
		try {
			
			sub.login(token);
			//表示登录成功   还缺乏session管理
			User user=(User) sub.getPrincipal();
			session.setAttribute("sessionUser", user);
			//或者通过shiro的session设置也可以
			//sub.getSession().setAttribute("sessionUser", user);
			return "redirect:home.action";//如果登录成功，shiro将会放in个所有的请求
		} catch (AuthenticationException a) {
			// TODO: handle exception
			//表示登录失败
			model.addAttribute("errorInfo", "用户名或者密码错误");
			a.printStackTrace();
			return "/sysadmin/login/login";
		}catch(Exception e){
			//表示一些未知错误
			e.printStackTrace();
			model.addAttribute("errorInfo", "发现未知错误，联系管理员");
			return "/sysadmin/login/login";
		}
		
		
	}
}
