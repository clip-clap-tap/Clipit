package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.Post;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface PostDao {
	List<Post> searchPost();

  Post selectPostById(int id);

  List<Post> selectPostsByWriterId(String id);

  List<Post> selectFavoritePostsByUserId(String id);

  List<Post> selectVisitedPostsByUserId(String id);

  int insertPost(Post post);

  int updatePost(Post post);

  int updatePostStatus(Map<String, ?> updateInfo);

  int insertFavoritePost(Map<String, ?> favoritePostInfo);

  List<Post> selectAllPostsByUserId(String id);

  int insertVisitedPost(Map<String,?> VisitedPostId);
}
