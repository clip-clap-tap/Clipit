package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    List<Post> getWrittenOrFavoritePostsByUserId(String id);

    List<Post> getWrittenPostsByUserId(String id);

    Post getPostDetailById(int id);

    List<Post> getRecentPosts();

    List<Post> getPopularPosts();

    int addPost(Post post);

    int modifyPost(Post post);

    int modifyPostStatus(int id, String status);

    int increaseViewCount(int id);

    List<Post> getFavoritePostsByUserId(String userId);

    int addFavoritePost(String userId, int postId);

    int cancelFavoritePost(String userId, int postId);

    List<Post> getVisitedPostsByUserId(String userId);

    int addVisitedPost(String userId, int postId);


}
