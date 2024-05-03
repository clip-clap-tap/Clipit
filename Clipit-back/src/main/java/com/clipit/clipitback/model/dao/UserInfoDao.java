package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.UserInfo;

import java.util.List;

public interface UserInfoDao {
    int signup();

    UserInfo login();

    UserInfo selectUserInfoById();

    List<UserInfo> selectAllUsers();

    int updateUser();

    int resign();
}
