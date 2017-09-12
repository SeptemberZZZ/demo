package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.UserInfo;

public interface UserInfoMapper {
	public void deleteUserInfo(String[] userIds);

	public List<UserInfo> findManagerList();

	public void saveUserInfo(UserInfo userInfo);

	public void updateUserInfo(UserInfo userInfo);
}
