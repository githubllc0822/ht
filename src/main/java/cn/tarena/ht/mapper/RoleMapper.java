package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.tarena.ht.pojo.Role;

public interface RoleMapper {
	@Select(value = { "select * from role_p order by order_no" })
//采用接口形式  直接将sql语句写到接口方法中，可以不用写mapper.xml
	public List<Role> findAll();
//	@Insert(value = { "" })
//	@Update(value = { "" })
//	@Delete(value = { "" })

	//批量删除
	public void deleteRole(String[] roleIds);
	//角色保存
	public void saveRole(Role role);
	
	//查询
	@Select(value = { "select * from role_p where role_id=#{roleId}" })
	public List<Role> toView(String roleId);
	
	//根据roleid查询role信息
	@Select(value = { "select * from role_p where role_id=#{roleId}" })
	public Role findRole(String id);
	

	public void update(Role role);

	public void deleteUserAndRole(String[] roleIds);
	
	//保存角色模块的关联关系
	public void saveRoleModule(@Param("roleId")String roleId, @Param("moduleId")String moduleId);
	
	@Delete("delete from role_module_p where role_id=#{roleId}")
	public void deleteModuleByRoleId(String roleId);
	@Select("select module_id from role_module_p where role_id = #{roleId}")
	public List<String> findModuleByRoleId(String roleId);
}
