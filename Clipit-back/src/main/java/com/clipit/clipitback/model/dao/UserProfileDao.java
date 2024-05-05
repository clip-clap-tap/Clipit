package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.UserProfile;

public interface UserProfileDao {
	public UserProfile selectUserProfile();

	public UserProfile updateUserProfile();
}
