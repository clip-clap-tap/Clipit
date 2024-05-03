package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.Post;

import java.util.List;

public interface PostDao {
    List<Post> searchPost();

    Post selectPostById();

    int updatePost();

    List<Post> selectPostsByWriterId();

    List<Post> selectFavoritePostsByUserId();

    List<Post> selectVisitedPostsByUserId();
}
