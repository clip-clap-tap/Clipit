package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.Tag;

import java.util.List;

public interface TagDao {
    List<Tag> selectFavoriteTagsByUserId();

    List<String> selectAllCategories();

    List<Tag> selectTagsByCategory();

    List<Tag> searchTag();

    int insertUserFavoriteTag();

    int deleteUserFavoriteTag();
}
