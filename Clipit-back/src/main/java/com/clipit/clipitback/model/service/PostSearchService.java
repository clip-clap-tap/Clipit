package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.SearchInfo;
import com.clipit.clipitback.model.entity.Post;

import java.util.List;

public interface PostSearchService {
    List<Post> searchPostsByTitle(String title);

    List<Post> search(SearchInfo searchInfo);

    List<Post> searchByCategory(SearchInfo searchInfo);

    List<Post> searchPostsByDescription(String description);

    List<Post> searchPostsByTitleOrDescription(String keyword);

    List<Post> searchPostsByWriter(String name);

    List<Post> searchPostsByTag(String name);

    Post insertPost(com.clipit.clipitback.model.dto.Post post);

    int deletePost(int id);

    Post convertPost(com.clipit.clipitback.model.dto.Post post);


}
