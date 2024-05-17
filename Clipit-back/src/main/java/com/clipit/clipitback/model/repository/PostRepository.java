package com.clipit.clipitback.model.repository;

import com.clipit.clipitback.model.entity.Post;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface PostRepository extends ElasticsearchRepository<Post, String> {
    List<Post> searchAllByTitle(String title);

    @Query("{\"nested\": {\n" +
            "      \"path\": \"writer\",\n" +
            "      \"query\": {\n" +
            "        \"match\":{\n" +
            "          \"writer.id\": \"?0\"\n" +
            "        }\n" +
            "      }\n" +
            "    } }")
    List<Post> searchAllByWriter(String username);

}