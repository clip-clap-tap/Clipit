package com.clipit.clipitback.model.repository;

import com.clipit.clipitback.model.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface PostRepository extends ElasticsearchRepository<Post, String> {
    List<Post> searchAllByTitle(String title);

    List<Post> searchAllByDescription(String description);

    List<Post> searchAllByTitleOrDescription(String title, String description);

    List<Post> searchAllByWriter(String writer);

    List<Post> searchAllByTagsName(String tagName);


}