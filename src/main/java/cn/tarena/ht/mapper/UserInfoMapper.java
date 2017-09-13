package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.UserInfo;

public interface UserInfoMapper {
	public void deleteUserInfo(String[] userInfoIds);
	
	//查询领导信息
	public List<UserInfo> findParentList();

	public void saveUserInfo(UserInfo userInfo);
}
