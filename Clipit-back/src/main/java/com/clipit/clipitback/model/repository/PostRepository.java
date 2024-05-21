package com.clipit.clipitback.model.repository;

import com.clipit.clipitback.model.entity.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface PostRepository extends ElasticsearchRepository<Post, String> {
    List<Post> searchAllByTitleContaining(String title);


    List<Post> searchAllByDescriptionContaining(String description);

    List<Post> searchAllByTitleContainingOrDescriptionContaining(String title, String desc);

    List<Post> searchAllByWriterNameContaining(String writer);

    List<Post> searchAllByTagsName(String tagName);


}