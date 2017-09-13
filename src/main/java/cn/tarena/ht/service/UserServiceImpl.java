package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.tool.MD5HashPassword;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper mapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}
	
	public void updateState(String[] userIds, int state) {
		// TODO Auto-generated method stub
		mapper.updateState(userIds,state);
	}
	
	public void deleteUser(String[] userIds) {
		// TODO Auto-generated method stub
		userInfoMapper.deleteUserInfo(userIds);
		mapper.deleteUser(userIds);//删除主表信息
		
		//删除用户 与角色 表中的信息		
		mapper.deleteUserAndRole(userIds);
	}
	
	public List<UserInfo> findParentList() {
		// TODO Auto-generated method stub
		return userInfoMapper.findParentList();
	}
	
	public void saveUser(User user) {
		UserInfo info=user.getUserInfo();
		//补齐属性值
		String uuid=UUID.randomUUID().toString();
		user.setUserId(uuid);
		user.setCreateTime(new Date());
		user.setUpdateTime(user.getCreateTime());
		//把用户输入的密码 经过md5hash算法  插入到数据库
		String md5Hash=MD5HashPassword.getPsw(user.getPassword(), user.getUsername());
		user.setPassword(md5Hash);
		
		info.setUserInfoId(uuid);
		info.setCreateTime(new Date());
		info.setUpdateTime(info.getCreateTime());
		//两张表同时新增操作
		mapper.saveUser(user);
		userInfoMapper.saveUserInfo(info);		
	}
	
	
	
	public void updateUser(User user) {
		UserInfo info=user.getUserInfo();
		//补齐属性值
		String uuid=UUID.randomUUID().toString();
		user.setUserId(uuid);
		user.setCreateTime(new Date());
		user.setUpdateTime(user.getCreateTime());
		
		info.setUserInfoId(uuid);
		info.setCreateTime(new Date());
		info.setUpdateTime(info.getCreateTime());
		//两张表同时新增操作
		mapper.saveUser(user);
		userInfoMapper.saveUserInfo(info);
	}
	
	public List<User> findUserById(String userId) {
		// TODO Auto-generated method stub
		return mapper.findUserById(userId);
	}
	
	//执行数据库更新操作
	@Override
	public void update(User user) {
		UserInfo info=user.getUserInfo();

		user.setUpdateTime(new Date());
		
		info.setUpdateTime(new Date());
		
		//对两张表更新
		
	}

	@Override
	public void saveUserRole(String userId, String[] roleIds) {
		mapper.deleteUserRole(userId);
		for(String roleId:roleIds){			
			mapper.saveUserRole(userId,roleId);
		}
		
	}

	@Override
	public List<String> findRoleIdList(String userId) {
		// TODO Auto-generated method stub
		return mapper.findRoleIdList(userId);
	}
	
	//根据用户命密码查询user  ————登录
	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		return mapper.findUser(username,password);
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return mapper.findUserByUsername(username);
	}

	@Override
	public List<String> findPrivilegeByUserId(String userId) {
		// TODO Auto-generated method stub
		return mapper.findPrivilegeByUserId(userId);
	}

}
