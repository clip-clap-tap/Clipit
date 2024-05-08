package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.Post;

import java.util.List;
import java.util.Map;

public interface PostDao {
	List<Post> searchPost();

  Post selectPostById(int id);

  List<Post> selectPostsByWriterId(int id);

  List<Post> selectFavoritePostsByUserId(int id);

  List<Post> selectVisitedPostsByUserId(int id);

  int insertPost(Post post);

  int updatePost(Post post);

  int updatePostStatus(Map<String, ?> updateInfo);

  int insertFavoritePost(Map<String, ?> favoritePostInfo);
}
