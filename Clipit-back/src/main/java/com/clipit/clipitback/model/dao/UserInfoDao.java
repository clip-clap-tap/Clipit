package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.UserInfo;

import java.util.List;

public interface UserInfoDao {
    int signup(UserInfo userInfo);

    UserInfo login(String id, String password);

    UserInfo selectUserInfoById(String id);

    List<UserInfo> selectAllUsers();

    int updateUser(UserInfo userInfo);

    int resign(String id);
}
