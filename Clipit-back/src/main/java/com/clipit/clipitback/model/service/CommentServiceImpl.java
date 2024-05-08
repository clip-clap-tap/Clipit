package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dao.CommentDao;
import com.clipit.clipitback.model.dto.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public Comment getCommentById(int id) {
        return commentDao.selectCommentById(id);
    }

    @Override
    public List<Comment> getCommentsByPostId(int id) {
        return commentDao.selectCommentsByPostId(id);
    }

    @Override
    public List<Comment> getCommentsByUserId(String id) {
        return commentDao.selectCommentsByUserId(id);
    }

    @Override
    public int addComment(int postId, String userId, Comment comment) {
        return commentDao.insertComment(Map.of("postId", postId, "userId", userId, "content", comment.getContent()));
    }

    @Override
    public int modifyComment(Comment comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public int removeComment(int id) {
        return commentDao.deleteComment(id);
    }
}
