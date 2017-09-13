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
import cn.tarena.ht.service.RoleServiceImpl;

@Controller
@RequestMapping("/sysadmin/role")
public class RoleController {
	@Autowired
	private RoleService service;
	@Autowired
	private ModuleService moduleService;
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Role> roleList=service.findAll();
		model.addAttribute("roleList", roleList);
		System.err.println(111);
		return "/sysadmin/role/jRoleList";
	}
	//角色删除
	@RequestMapping("/delete")
	public String toDelete(@RequestParam("roleId")String[] roleId){//???
		System.err.println(roleId);
		service.deleteRole(roleId);
		return "redirect:/sysadmin/role/list";
	}
	
	//角色新增
	@RequestMapping("/tocreate")
	public String toCreate(){
		return "/sysadmin/role/jRoleCreate";
	}
	
	//角色保存
	@RequestMapping("/save")
	public String saveRole(Role role){
		service.saveRole(role);
		return "redirect:/sysadmin/role/list";
	}
	
	//角色查询
	@RequestMapping("toview")
	public String toView(String roleId,Model model){
		List<Role> roleList=service.toView(roleId);
		model.addAttribute("roleList", roleList);
		return "/sysadmin/role/jRoleList";
		
	}
	
	
	//角色修改--信息查询与回显
	@RequestMapping("toupdate")
	public String toUpdate(String roleId,Model model){
		Role role=service.findRole(roleId);
		model.addAttribute("role", role);
		return "/sysadmin/role/jRoleUpdate";
	}
	
	@RequestMapping("update")
	public String update(Role role){
		service.update(role);

		return "redirect:/sysadmin/role/list";
	}
	
	
	@RequestMapping("/roleModule")
	public String roleModule(String roleId,Model model) throws JsonProcessingException{
		
		//查询全部的模块信息
		List<Module> moduleList=moduleService.findAll();
		//将数据转换为json串
		ObjectMapper obj=new ObjectMapper();
		
		//数据回显，从模块与角色关联的表中根据roleId查询  
		List<String> moduleIdList=service.findModuleByRoleId(roleId);
		for(Module m:moduleList){
			if(moduleIdList.contains(m.getModuleId())){
				m.setChecked(true);
			}
		}
		String zTreeJSON=obj.writeValueAsString(moduleList);
		model.addAttribute("zTreeJSON", zTreeJSON);
		model.addAttribute("roleId", roleId);
		//跳转到模块展现页面
		return "sysadmin/role/jRoleModule";
	}
	
	//保存角色模块关联关系
	@RequestMapping("/saveRoleModule")
	public String saveRoleModule(String roleId,@RequestParam(value="moduleId",required=true)String[] moduleIds){		
		service.saveRoleModule(roleId,moduleIds);
		//跳转到角色展现页面
		return "redirect:/sysadmin/role/list";
	}
}
