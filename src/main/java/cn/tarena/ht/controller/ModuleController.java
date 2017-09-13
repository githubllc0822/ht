package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Controller
@RequestMapping("/sysadmin/module")
public class ModuleController {
	@Autowired
	private ModuleService service;
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Module> moduleList=service.findAll();
		model.addAttribute("moduleList", moduleList);
		return "/sysadmin/module/jModuleList";
	}
	
	@RequestMapping("/start")
	public String toStart(@RequestParam(value="moduleId",required=true)String[] moduleIds){
		int state=1;
		service.updateState(moduleIds,state);
		//转到module的列表页
		return "redirect:/sysadmin/module/list";
	}
	
	//跳转到module新增页面
	@RequestMapping("/tocreate")
	public String toCreate(Model model){
		List<Module> moduleList=service.findAll();
		model.addAttribute("moduleList", moduleList);
		//转到module新增页面
		return "/sysadmin/module/jModuleCreate";
	}
	
	//插入module数据到数据库
		@RequestMapping("/save")
		public String create(Module module){	
			service.saveModule(module);
			//转到module  list页面
			return "redirect:/sysadmin/module/list";
		}
	//
}
