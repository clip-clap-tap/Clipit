package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.Tag;

import java.util.List;

public interface TagDao {
    List<Tag> selectFavoriteTagsByUserId();

    List<Tag> selectTagsByName(String name);

    int insertUserFavoriteTag();

    int deleteUserFavoriteTag();

    int insertTag(Tag tag);

    int deleteTag();

    int insertPostTag();

    int deletePostTag();
}
