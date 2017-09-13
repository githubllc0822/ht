package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Module;

public interface ModuleMapper {
	public List<Module> findAll();

	public void updateState(@Param(value="moduleIds")String[] moduleIds, @Param(value="state")int state);

	public void saveModule(Module module);
}
