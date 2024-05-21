package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.Post;

import java.util.List;
import java.util.Map;

public interface PostDao {
    List<Post> selectAllPosts();

    Post selectPostById(int id);

    List<Post> selectRecentPosts();

    List<Post> selectPopularPosts();

    List<Post> selectUserRelatedPostsByUserId(String id);

    List<Post> selectPostsByWriterId(String id);

    List<Post> selectFavoritePostsByUserId(String id);

    List<Post> selectVisitedPostsByUserId(String userId);

    int insertPost(Post post);

    int updatePost(Post post);

    int updatePostStatus(Map<String, ?> updateInfo);

    int increaseViewCount(int id);

    int insertFavoritePost(Map<String, ?> favoritePostInfo);

    int deleteFavoritePost(Map<String, ?> favoritePostInfo);


    int insertVisitedPost(Map<String, ?> VisitedPostId);

}
