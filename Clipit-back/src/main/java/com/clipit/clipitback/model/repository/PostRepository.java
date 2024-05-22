package com.clipit.clipitback.model.repository;

import com.clipit.clipitback.model.entity.Post;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface PostRepository extends ElasticsearchRepository<Post, String> {
    List<Post> searchAllByTitleContaining(String title);

    @Query(value = "{\"bool\": {\n\"should\": [\n{\n\"query_string\": {\n\"default_field\": \"?0\",\n\"query\": \"%?1%\"\n}\n},\n{\n\"query_string\": {\n\"default_field\": \"age_range\",\n\"query\": \"?2\"\n}\n},\n{\n\"query_string\": {\n\"default_field\": \"body_part\",\n\"query\": \"?3\"\n}\n },\n{\n\"match\": {\n\"strength\": ?4\n}\n}\n],\n\"must\": [\n]\n}\n}\n}")
    List<Post> searchByCategory(String category, String keyword, String ageRangeQuery, String bodyPartQuery, int strength);

    @Query(value = "\n{\n\"bool\": {\n\"should\": [\n{\n\"query_string\": {\n\"fields\": [\"title\", \"description\"],\n\"query\": \"%?0%\"\n}\n},\n{\n\"query_string\": {\n\"default_field\": \"age_range\",\n\"query\": \"?1\"\n}\n},\n{\n\"query_string\": {\n\"default_field\": \"body_part\",\n\"query\": \"?2\"\n}\n },\n{\n\"match\": {\n\"strength\": ?3\n}\n}\n],\n\"must\": [\n]\n}\n}")
    List<Post> search(String keyword, String ageRangeQuery, String bodyPartQuery, int strength);

    int deleteById(int id);

    List<Post> searchAllByDescriptionContaining(String description);

    List<Post> searchAllByTitleContainingOrDescriptionContaining(String title, String desc);

    List<Post> searchAllByWriterNameContaining(String writer);

    List<Post> searchAllByTagsName(String tagName);


}