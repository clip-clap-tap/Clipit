package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.Post;

import java.util.List;

public interface PostDao {
	public List<Post> searchPost();

	public Post selectPostById();

	public int updatePost();

	public List<Post> selectPostsByWriterId();

	public List<Post> selectFavoritePostsByUserId();

	public List<Post> selectVisitedPostsByUserId();
}
