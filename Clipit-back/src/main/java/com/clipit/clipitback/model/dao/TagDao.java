package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.FavoriteTag;
import com.clipit.clipitback.model.dto.Tag;

import java.util.List;
import java.util.Map;

public interface TagDao {
    Tag selectTagByName(String name);

    int selectTagIdByName(String name);

    int insertTag(Tag tag);

    int deleteTag();

    List<FavoriteTag> selectFavoriteTagsByUserId(String id);

    int insertUserFavoriteTag(Map<String, ?> favoriteTag);

    int insertExtraFavoriteTag(Map<String, ?> favoriteTag);

    int updateUserFavoriteTag(Map<String, ?> favoriteTag);

    int deleteFavoriteTagByUserId(Map<String,?> favoriteTag);

    int insertPostTag(Map<String, ?> tagInfo);

    int deletePostTag();
}
