package com.clipit.clipitback.model.repository;

import com.clipit.clipitback.model.entity.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface PostRepository extends ElasticsearchRepository<Post, String> {

    List<Post> searchAllByTitle(String title);
}