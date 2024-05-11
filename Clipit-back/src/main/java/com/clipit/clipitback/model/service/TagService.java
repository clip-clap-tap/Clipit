package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.Post;
import com.clipit.clipitback.model.dto.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTagsByName(String name);

    int addTag(Tag tag);

    int removeTag();

    void checkTagInfo(List<Tag> tags);

    List<Tag> getFavoriteTagsByUserId();


    int addUserFavoriteTag();

    int removeUserFavoriteTag();

    int addPostTag(Post post);

    int removePostTag();
}
