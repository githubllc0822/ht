package cn.tarena.ht.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.*;
public interface UserMapper {
	public List<User> findAll();
	//mybatis只支持单值传递，将参数封装为map
	public void updateState(@Param("userIds")String[] userIds, @Param("state")int state);
	//删除用户
	public void deleteUser(String[] userIds);
	//新增用户
	public void saveUser(User user);
	public List<User> findUserById(String userId);
	@Insert("insert into role_user_p  values (#{roleId},#{userId})")
	public void saveUserRole(@Param("userId")String userId, @Param("roleId")String roleId);
	
	@Delete("delete  from role_user_p where user_Id=#{userId}")
	public void deleteUserRole(String userId);
	
	@Select("select role_id from role_user_p where user_id=#{userId}")
	public List<String> findRoleIdList(String userId);
	
	//删除用户的时候 需要删除user role 中的关联关系
	public void deleteUserAndRole(String[] userIds);
	
	//登录  查询用户名 密码
	public User findUser(@Param("username")String username, @Param("password")String password);
	public User findUserByUsername(String username);
	public List<String> findPrivilegeByUserId(String userId);
	
}
