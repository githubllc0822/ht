package cn.tarena.ht.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;
@Service
public class ModuleServiceImpl  implements ModuleService{
@Autowired
private ModuleMapper mapper;
	public List<Module> findAll() {
		return mapper.findAll();
	}
	@Override
	public void updateState(String[] moduleIds, int state) {
		// TODO Auto-generated method stub
		mapper.updateState(moduleIds,state);
	}
	@Override
	public void saveModule(Module module) {
		// TODO Auto-generated method stub
		String  uuid=UUID.randomUUID().toString();
		module.setModuleId(uuid);
		mapper.saveModule(module);
	}

}
