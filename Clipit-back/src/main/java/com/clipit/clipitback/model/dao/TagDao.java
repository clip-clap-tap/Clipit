package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.Tag;

import java.util.List;
import java.util.Map;

public interface TagDao {
    Tag selectTagByName(String name);

    int insertTag(Tag tag);

    int deleteTag();

    List<Tag> selectFavoriteTagsByUserId();


    int insertUserFavoriteTag();

    int deleteUserFavoriteTag();

    int insertPostTag(Map<String, ?> tagInfo);

    int deletePostTag();
}
