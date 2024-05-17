package com.clipit.clipitback.model.repository;

import com.clipit.clipitback.model.entity.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface PostRepository extends ElasticsearchRepository<Post, String> {
    List<Post> searchAllByTitle(String title);


    List<Post> searchAllByWriterId(String username);


    List<Post> searchAllByDescription(String description);

    List<Post> searchAllByTitleOrDescription(String title, String description);

    List<Post> searchAllByWriterName(String writer);

    List<Post> searchAllByTagsName(String tagName);


}