package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.UserProfile;
import com.clipit.clipitback.model.dto.mapperDTO.HistoryMap;
import com.clipit.clipitback.model.dto.mapperDTO.StatisticsMap;

import java.util.List;

public interface UserProfileDao {
    UserProfile selectUserProfile(String id);

    int insertUserProfile(UserProfile userProfile);

    int updateUserProfile(UserProfile userProfile);

    List<HistoryMap> selectUserExerciseHistory(String id);

    List<StatisticsMap> selectUserExerciseStatistics(String id);

    List<StatisticsMap> selectUserPostStatistics(String id, String id2);
}
