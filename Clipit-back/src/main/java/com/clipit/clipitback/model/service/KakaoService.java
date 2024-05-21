package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface KakaoService {

    String getKakaoToken(String code) throws JsonProcessingException;

    UserInfo getKakaoInfo(String accessToken) throws JsonProcessingException;

    UserInfo getUserInfo(UserInfo userInfo);
}
