package cn.tarena.ht.service;
import java.util.List;

import cn.tarena.ht.pojo.*;
public interface UserService {
	public List<User> findAll();
	//修改用户状态
	public void updateState(String[] userIds, int state);
	public void deleteUser(String[] userIds);
	public List<UserInfo> findParentList();
	public void saveUser(User user);
	public void updateUser(User user);
	public List<User> findUserById(String userId);
	public void update(User user);
	public void saveUserRole(String userId, String[] roleIds);
	public List<String> findRoleIdList(String userId);
	public User findUser(String username, String password);
	public User findUserByUsername(String username);
	public List<String> findPrivilegeByUserId(String userId);
}
