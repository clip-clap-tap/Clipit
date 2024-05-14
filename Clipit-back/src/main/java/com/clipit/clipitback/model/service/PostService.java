package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.Post;

import java.util.List;

public interface PostService {
    List<Post> searchPostsByCondition();

    List<Post> getAllPosts();

    Post getPostById(int id);

    List<Post> getPostsByWriterId(String id);

    List<Post> getFavoritePostsByUserId(String id);

    List<Post> getAllPostsByUserId(String id);

    List<Post> getVisitedPostsByUserId(String userId);

    int modifyPost(Post post);

    int addPost(Post post);

    int modifyPostStatus(int id, String status);

    int addFavoritePost(String userId, int postId);

    int addVisitedPost(String userId, int postId);
}
