package com.clipit.clipitback.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clipit.clipitback.model.dao.UserInfoDao;
import com.clipit.clipitback.model.dao.UserProfileDao;
import com.clipit.clipitback.model.dto.UserInfo;
import com.clipit.clipitback.model.dto.UserProfile;

@Service
public class UserServiceImpl implements UserService{

	private final UserInfoDao userInfoDao;
	private final UserProfileDao userProfileDao;

	@Autowired
	public UserServiceImpl(@Qualifier("userInfoDao") UserInfoDao userInfoDao, @Qualifier("userProfileDao") UserProfileDao userProfileDao) {
	    this.userInfoDao = userInfoDao;
	    this.userProfileDao = userProfileDao;
	}

	
	@Override
	public int signup(UserInfo userInfo) {
		return userInfoDao.signup();
	}

	@Override
	public UserInfo login(String id, String password) {
		return null;
	}

	@Override
	public UserInfo getUserInfoById(String id) {
		return null;
	}

	@Override
	public List<UserInfo> getUserInfoList() {
		return null;
	}

	@Override
	public int modifyUserInfo(UserInfo userInfo) {
		return 0;
	}

	@Override
	public int inactivate(String id) {
		return 0;
	}
	
	@Override
	public UserProfile getUserProfileById(String id) {
		return null;
	}

	@Override
	public int modifyUserProfile(UserProfile userProfile) {
		return 0;
	}


}
