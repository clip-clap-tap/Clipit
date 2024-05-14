package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.UserInfo;

import java.util.Map;


public interface JWTService {
    String createToken(UserInfo userInfo);

    Boolean validate(String tokens);

    Map<String, ?> decode(String token);

    String getUserIdFromToken(String token);
}
