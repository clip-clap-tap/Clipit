package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.Tag;

import java.util.List;

public interface TagDao {
	public List<Tag> selectFavoriteTagsByUserId();

	public List<String> selectAllCategories();

	public List<Tag> selectTagsByCategory();

	public List<Tag> searchTag();

	public int insertUserFavoriteTag();

	public int deleteUserFavoriteTag();
}
