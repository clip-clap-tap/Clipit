package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.entity.Post;

import java.util.List;

public interface PostSearchService {
    List<Post> searchPostsByTitle(String title);

    Post insertPost(com.clipit.clipitback.model.dto.Post post);

    Post convertPost(com.clipit.clipitback.model.dto.Post post);
}
