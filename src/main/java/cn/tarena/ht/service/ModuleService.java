package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Module;

public interface ModuleService {
	public List<Module> findAll();

	public void updateState(String[] moduleIds, int state);

	public void saveModule(Module module);
}
