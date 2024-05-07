package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.UserProfile;

public interface UserProfileDao {
	UserProfile selectUserProfile(String id);

	int insertUserProfile(String id);

	int updateUserProfile(UserProfile userProfile);
}
