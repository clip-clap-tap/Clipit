package com.clipit.clipitback.model.dao;

import com.clipit.clipitback.model.dto.Comment;

import java.util.List;
import java.util.Map;

public interface CommentDao {
    Comment selectCommentById(int id);

    List<Comment> selectCommentsByPostId(int id);

    List<Comment> selectCommentsByUserId(String id);

    int insertComment(Map<String, ?> commentInfo);

    int updateComment(Comment comment);

    int deleteComment(int id);
}
