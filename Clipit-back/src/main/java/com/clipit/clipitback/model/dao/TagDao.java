package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.FavoriteTag;
import com.clipit.clipitback.model.dto.Tag;

import java.util.List;
import java.util.Map;

public interface TagDao {
    Tag selectTagByName(String name);

    int insertTag(Tag tag);

    int deleteTag();

    List<FavoriteTag> selectFavoriteTagsByUserId(String id);

    int insertUserFavoriteTag(Map<String, ?> favoriteTag);

    int updateUserFavoriteTag(Map<String, ?> favoriteTag);

    int deleteUserFavoriteTagByUserId(String userId);

    int insertPostTag(Map<String, ?> tagInfo);

    int deletePostTag();
}
