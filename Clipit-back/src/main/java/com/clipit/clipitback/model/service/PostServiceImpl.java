package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dao.PostDao;
import com.clipit.clipitback.model.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private PostDao postDao;
    @Autowired
    PostServiceImpl(PostDao postDao){this.postDao = postDao;}
    @Override
    public List<Post> searchPostsByCondition() {
        List<Post> posts = postDao.searchPost();
        return posts;
    }

    @Override
    public Post getPostById(int id) {
        Post post = postDao.selectPostById(id);
        return post;
    }

    @Override
    public List<Post> getPostsByWriterId(int id) {
        List<Post> posts = postDao.selectPostsByWriterId(id);
        return posts;
    }

    @Override
    public List<Post> getFavoritePostsByUserId(int id) {
        List<Post> posts = postDao.selectFavoritePostsByUserId(id);
        return posts;
    }

    @Override
    public List<Post> getVisitedPostsByUserId(int id) {
        List<Post> posts = postDao.selectVisitedPostsByUserId(id);
        return posts;
    }

    @Override
    public int modifyPost(Post post) {
        int result = postDao.updatePost(post);
        return result;
    }
}
