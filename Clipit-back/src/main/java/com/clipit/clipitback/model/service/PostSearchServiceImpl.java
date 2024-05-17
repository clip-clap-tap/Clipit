package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.entity.Post;
import com.clipit.clipitback.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSearchServiceImpl implements PostSearchService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Autowired
    public PostSearchServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public List<Post> searchPostsByTitle(String title) {
        List<Post> result = postRepository.searchAllByTitle(title);
        return result;
    }

    @Override
    public List<Post> searchPostsByDescription(String description) {
        List<Post> result = postRepository.searchAllByDescription(description);
        return result;
    }

    @Override
    public List<Post> searchPostsByTitleOrDescription(String keyword) {
        List<Post> result = postRepository.searchAllByTitleOrDescription(keyword, keyword);
        return result;
    }

    @Override
    public List<Post> searchPostsByWriter(String writer) {
        List<Post> result = postRepository.searchAllByWriter(writer);
        return result;
    }

    @Override
    public Post insertPost(com.clipit.clipitback.model.dto.Post post) {
        Post result = postRepository.save(convertPost(post));
        return result;
    }

    public Post convertPost(com.clipit.clipitback.model.dto.Post post) {
        Post postForSearch = new Post();
        postForSearch.setId(post.getId());
        postForSearch.setTitle(post.getTitle());
        postForSearch.setWriter(userService.getUserInfoById(post.getWriterId()).getUsername());
        postForSearch.setDescription(post.getDescription());
        postForSearch.setStatus(post.getStatus());
        postForSearch.setCreateDate(post.getCreateDate());
        postForSearch.setUpdateDate(post.getUpdateDate());
        postForSearch.setAgeRange(post.getAgeRange());
        postForSearch.setBodyPart(post.getBodyPart());
        postForSearch.setStrength(post.getStrength());

        return postForSearch;

    }

    @Override
    public List<Post> searchPostsByTag(String tagName) {
        List<Post> result = postRepository.searchAllByTagsName(tagName);
        return result;
    }
}
