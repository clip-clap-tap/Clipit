package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.UserProfile;
import com.clipit.clipitback.model.dto.mapperDTO.HistoryMap;

import java.util.List;

public interface UserProfileDao {
    UserProfile selectUserProfile(String id);

    int insertUserProfile(UserProfile userProfile);

    int updateUserProfile(UserProfile userProfile);

    List<HistoryMap> selectUserExerciseHistory(String id);
}
