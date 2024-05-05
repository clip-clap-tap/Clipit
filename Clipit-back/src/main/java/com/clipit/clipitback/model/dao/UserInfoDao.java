package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.UserInfo;

import java.util.List;

public interface UserInfoDao {
    public int signup();

    public UserInfo login();

    public UserInfo selectUserInfoById();

    public List<UserInfo> selectAllUsers();

    public int updateUser();

    public int resign();
}
