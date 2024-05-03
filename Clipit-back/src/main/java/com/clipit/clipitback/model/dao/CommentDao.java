package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.Comment;

import java.util.List;

public interface CommentDao {
    Comment selectCommentById();

    List<Comment> selectCommentsByPostId();

    List<Comment> selectCommentsByUserId();

    int updateComment();

    int deleteComment();
}
