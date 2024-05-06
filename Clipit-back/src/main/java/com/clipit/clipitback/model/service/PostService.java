package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.Post;

import java.util.List;

public interface PostService {
    List<Post> searchPostsByCondition();

    List<Post> getAllPosts();

    Post getPostById(int id);

    List<Post> getPostsByWriterId(int id);

    List<Post> getFavoritePostsByUserId(int id);

    List<Post> getVisitedPostsByUserId(int id);

    int modifyPost(Post post);

    int addPost(Post post);

    int modifyPostStatus(int id, String status);
}
