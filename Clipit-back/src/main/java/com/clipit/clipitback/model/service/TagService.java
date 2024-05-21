package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.FavoriteTag;
import com.clipit.clipitback.model.dto.Post;
import com.clipit.clipitback.model.dto.Tag;

import java.util.List;

public interface TagService {
    Tag getTagByName(String name);

    int addTag(Tag tag);

    int removeTag();

    void checkTagInfo(List<Tag> tags);

    List<FavoriteTag> getFavoriteTagsByUserId(String userId);

    int addUserFavoriteTag(String userId, List<Tag> tags);

    int modifyFavoriteTag(String userId, List<Tag> tags);

    int removeAllUserFavoriteTag(String userId);

    int addPostTag(Post post);

    int removePostTag();
}
