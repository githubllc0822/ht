package cn.tarena.ht.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.*;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.service.UserServiceImpl;

@Controller
@RequestMapping("/sysadmin/user")
public class UserController extends BaseController{
	@Autowired
	private UserService service;
	@Autowired
	private DeptService deptService;
	@Autowired
	private RoleService roleService;
	@RequestMapping("/list")	
	public String findAll(Model model){
		List<User> userList = service.findAll();
		for(User u:userList){
			System.err.println(u);
		}
		model.addAttribute("userList", userList);
		return "/sysadmin/user/jUserList";
	}
	
	//状态启用
	@RequestMapping("/start")
	public String toStart(@RequestParam(value="userId",required=true)String[] userIds){
		int state=1;//启用
		service.updateState(userIds,state);
		//页面跳转到user列表页面
		return "redirect:/sysadmin/user/list";
		
	}
	
	//状态停用
		@RequestMapping("/stop")
		public String toStop(@RequestParam(value="userId",required=true)String[] userIds){
			int state=0;//停用
			service.updateState(userIds,state);
			//页面跳转到user列表页面
			return "redirect:/sysadmin/user/list";
			
		}
		//删除用户信息
		@RequestMapping("/delete")
		public String toDelete(@RequestParam(value="userId",required=true)String[] userIds){
			service.deleteUser(userIds);
			//删除完成之后，跳转到用户列表页面
			
			return "redirect:/sysadmin/user/list";
		}
		
		//用户新增
		@RequestMapping("/tocreate")
		public String toCreate(Model model){
			//查询部门列表信息
			List<Dept> deptList=deptService.findAll();
			model.addAttribute("deptList", deptList);
			
			//上级领导列表
			List<UserInfo> parentList=service.findParentList(); 
			model.addAttribute("parentList", parentList);
			//跳转到用户新增页面
			return "/sysadmin/user/jUserCreate";
		}
		
		//保存用户信息
		@RequestMapping("save")
		public String  saveUser(User user){
			service.saveUser(user);
			System.err.println(user);
			System.out.println(user.getUserInfo().getName());
			//跳转到用户列表页面
			return "redirect:/sysadmin/user/list";
		}
		
		
		//查询出用户信息 ，并且显示在页面上
		@RequestMapping("toupdate")
			public String  updateUser(String userId,Model model){
				//拿到userId   去根据这个查询user的信息
				List<User> userList=service.findUserById(userId);
				model.addAttribute("userList", userList);
				
				//查询全部的用户信息，用于显示下拉选的可选项
				List<Dept> list = deptService.findAll();
				model.addAttribute("list", list);
				
				//修改上级领导模块 
				List<User> allUserList=service.findAll();
				model.addAttribute("allUserList", allUserList);
				//跳转到用户信息页面
				return "/sysadmin/user/jUserUpdate";
				}
		
		//修改用户信息后  更新到数据库
		@RequestMapping("/update")
		public String update(User user){
			service.update(user);
			return "redirect:/sysadmin/user/list";
		}
		
		//跳转到角色分配页面
		@RequestMapping("/userRole")
		public String userRole(String userId,Model model) throws JsonProcessingException{
			//2.回显改造  根据userId查询全部 roleid
			List<String> uRoleList=service.findRoleIdList(userId);
			
			//角色列表信息  list是集合  但是ztree只认json串
			List<Role> roleList=roleService.findAll();
			
			//2.实现角色回显??
			for(Role role:roleList){
				if(uRoleList.contains(role.getId())){
					role.setChecked(true);
				}
			}
			
			//创建工具类对象
			ObjectMapper  objectMapper=new ObjectMapper();
			
			//将list转为json串
			String zTreeJSON=objectMapper.writeValueAsString(roleList);
			
			model.addAttribute("zTreeJSON", zTreeJSON);
			model.addAttribute("userId", userId);
			
			System.err.println(zTreeJSON);
			return "/sysadmin/user/jUserRole";
		}
		
		//
		
		@RequestMapping("saveUserRole")
		public String saveUserRole(String userId,String[] roleIds){
			System.err.println(userId+"aa");
			service.saveUserRole(userId,roleIds);
			return "redirect:/sysadmin/user/list";
			
		}
		
}
