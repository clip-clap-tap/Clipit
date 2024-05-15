package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.entity.Post;
import com.clipit.clipitback.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSearchServiceImpl implements PostSearchService {

    private final PostRepository postRepository;

    @Autowired
    public PostSearchServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> searchPostsByTitle(String title) {
        System.out.println(title);
        List<Post> result = postRepository.searchAllByTitle(title);
        System.out.println(result);
        return result;
    }
}
