package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dao.PostDao;
import com.clipit.clipitback.model.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    private final PostDao postDao;

    @Autowired
    PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }
    
    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = postDao.searchPost();
        return posts;
    }

    @Override
    public Post getPostById(int id) {
        Post post = postDao.selectPostById(id);
        return post;
    }


    @Override
    public List<Post> getVisitedPostsByUserId(String userId) {
        List<Post> posts = postDao.selectVisitedPostsByUserId(userId);
        return posts;
    }


    @Override
    public int addPost(Post post) {
        if (post.getStatus() == null) post.setStatus("public");
        int result = postDao.insertPost(post);
        return result;
    }

    @Override
    public int modifyPost(Post post) {
        int result = postDao.updatePost(post);
        return result;
    }

    @Override
    public int modifyPostStatus(int id, String status) {
        int result = postDao.updatePostStatus(Map.of("id", id, "status", status));
        return result;
    }

    @Override
    public int addFavoritePost(String userId, int postId) {
        int result = postDao.insertFavoritePost(Map.of("userId", userId, "postId", postId));
        return result;
    }

    @Override
    public int addVisitedPost(String userId, int postId) {
        int result = postDao.insertVisitedPost(Map.of("userId", userId, "postId", postId));
        return result;
    }

    @Override
    public int cancelFavoritePost(String userId, int postId) {
        int result = postDao.deleteFavoritePost(Map.of("userId", userId, "postId", postId));
        return result;
    }

}
