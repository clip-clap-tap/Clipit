package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.Tag;

import java.util.List;

public interface TagService {

    List<Tag> getFavoriteTagsByUserId();


    List<Tag> getTagsByName(String name);

    int addUserFavoriteTag();

    int removeUserFavoriteTag();

    int addTag(Tag tag);

    int removeTag();

    int addPostTag();

    int removePostTag();
}
