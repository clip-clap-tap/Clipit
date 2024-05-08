package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.Comment;

import java.util.List;

public interface CommentService {
    Comment getCommentById(int id);

    List<Comment> getCommentsByPostId(int id);

    List<Comment> getCommentsByUserId(String id);

    int addComment(int postId, String userId, Comment comment);

    int modifyComment(Comment comment);

    int removeComment(int id);

}
