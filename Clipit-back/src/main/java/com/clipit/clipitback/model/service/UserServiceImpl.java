package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dao.UserInfoDao;
import com.clipit.clipitback.model.dao.UserProfileDao;
import com.clipit.clipitback.model.dto.UserInfo;
import com.clipit.clipitback.model.dto.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserInfoDao userInfoDao;
    private final UserProfileDao userProfileDao;
    private final JWTService jwtService;

    @Autowired
    public UserServiceImpl(@Qualifier("userInfoDao") UserInfoDao userInfoDao, @Qualifier("userProfileDao") UserProfileDao userProfileDao, JWTService jwtService) {
        this.userInfoDao = userInfoDao;
        this.userProfileDao = userProfileDao;
        this.jwtService = jwtService;
    }


    @Override
    public int signup(UserInfo userInfo) {

        return userInfoDao.signup(userInfo);
    }

    @Override
    public String login(UserInfo userInfo) {
        UserInfo target = getUserInfoById(userInfo.getId());
        String token = null;
        if (target.getPassword().equals(userInfo.getPassword())) {
            token = jwtService.createToken(userInfo);
        }
        return token;
    }

    @Override
    public UserInfo getUserInfoById(String id) {

        return userInfoDao.selectUserInfoById(id);
    }

    @Override
    public List<UserInfo> getUserInfoList() {

        return userInfoDao.selectAllUsers();
    }

    @Override
    public int modifyUserInfo(UserInfo userInfo) {

        return userInfoDao.updateUser(userInfo);
    }

    @Override
    public int inactivate(String id) {

        return userInfoDao.resign(id);
    }

    @Override
    public UserProfile getUserProfileById(String id) {

        return userProfileDao.selectUserProfile(id);
    }

    @Override
    public int modifyUserProfile(UserProfile userProfile) {

        return userProfileDao.updateUserProfile(userProfile);
    }

    @Override
    public int registUserProfile(UserProfile userProfile) {
        return userProfileDao.insertUserProfile(userProfile);
    }


}
