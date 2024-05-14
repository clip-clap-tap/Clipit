package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.UserInfo;
import com.clipit.clipitback.model.dto.UserProfile;

import java.util.List;

public interface UserService {

    // 회원가입
    public int signup(UserInfo userInfo);

    // 로그인
    public String login(UserInfo userInfo);

    // 회원정보 검색
    public UserInfo getUserInfoById(String id);

    // 전체 회원 리스트
    public List<UserInfo> getUserInfoList();

    // 회원정보 수정
    public int modifyUserInfo(UserInfo userInfo);

    // 회원 비활성화
    public int inactivate(String id);

    // 회원프로필 상세보기
    public UserProfile getUserProfileById(String id);

    // 회원프로필 수정
    public int modifyUserProfile(UserProfile userProfile);

    // 회원프로필 등록
    public int registUserProfile(UserProfile userProfile);
}
