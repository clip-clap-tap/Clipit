package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.entity.Post;

import java.util.List;

public interface PostSearchService {
    List<Post> searchPostsByTitle(String title);
}
