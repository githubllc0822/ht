package cn.tarena.ht.service;
import java.util.List;

import cn.tarena.ht.pojo.*;
public interface RoleService {
	public List<Role> findAll();

	public void deleteRole(String[] roleIds);

	public void saveRole(Role role);

	public List<Role> toView(String roleId);

	public Role findRole(String id);

	public void update(Role role);

	public void saveRoleModule(String roleId, String[] moduleIds);

	public List<String> findModuleByRoleId(String roleId);
}
