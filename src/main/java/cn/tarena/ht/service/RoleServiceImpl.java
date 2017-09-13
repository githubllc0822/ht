package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper mapper;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}
	@Override
	public void deleteRole(String[] roleIds) {
		mapper.deleteRole(roleIds);
		mapper.deleteUserAndRole(roleIds);
		
	}
	//角色保存
	@Override
	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		role.setRoleId(uuid);
		role.setCreateTime(new Date());
		role.setUpdateTime(role.getCreateTime());
		mapper.saveRole(role);
	}
	@Override
	public List<Role> toView(String roleId) {
		// TODO Auto-generated method stub
		return mapper.toView(roleId);
	}
	@Override
	public Role findRole(String id) {
		// TODO Auto-generated method stub
		return mapper.findRole(id);
	}
	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		role.setUpdateTime(new Date());
		mapper.update(role);
	}
	@Override
	public void saveRoleModule(String roleId, String[] moduleIds) {
		mapper.deleteModuleByRoleId(roleId);
		// TODO Auto-generated method stub
		for(String moduleId:moduleIds){			
			mapper.saveRoleModule(roleId,moduleId);
		}
	}
	@Override
	public List<String> findModuleByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return mapper.findModuleByRoleId(roleId);
	}

}
