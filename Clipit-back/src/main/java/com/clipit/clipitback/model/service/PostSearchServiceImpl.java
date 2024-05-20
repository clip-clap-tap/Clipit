package com.clipit.clipitback.model.service;

import com.clipit.clipitback.model.dto.SearchInfo;
import com.clipit.clipitback.model.entity.Post;
import com.clipit.clipitback.model.repository.PostRepository;
import org.modelmapper.ModelMapper;
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
        List<Post> result = postRepository.searchAllByTitleContaining(title);
        return result;
    }

    @Override
    public List<Post> search(SearchInfo searchInfo) {
        String keyword = searchInfo.getKeyword();
        String ageRangeQuery = (searchInfo.getAgeRange() == null || searchInfo.getAgeRange().isEmpty()) ? "" : String.join(" AND ", searchInfo.getAgeRange().stream().map(age -> "(" + age + ")").toList());
        String bodyPartsQuery = (searchInfo.getBodyParts() == null || searchInfo.getBodyParts().isEmpty()) ? "" : String.join(" AND ", searchInfo.getBodyParts());
        int strength = searchInfo.getStrength();
        return postRepository.search(keyword, ageRangeQuery, bodyPartsQuery, strength);
    }

    @Override
    public List<Post> searchByCategory(SearchInfo searchInfo) {
        String category = searchInfo.getCategory();
        String keyword = searchInfo.getKeyword();
        String ageRangeQuery = (searchInfo.getAgeRange() == null || searchInfo.getAgeRange().isEmpty()) ? "" : String.join(" AND ", searchInfo.getAgeRange().stream().map(age -> "(" + age + ")").toList());
        String bodyPartsQuery = (searchInfo.getBodyParts() == null || searchInfo.getBodyParts().isEmpty()) ? "" : String.join(" AND ", searchInfo.getBodyParts());
        int strength = searchInfo.getStrength();
        return postRepository.searchByCategory(category, keyword, ageRangeQuery, bodyPartsQuery, strength);
    }


    @Override
    public List<Post> searchPostsByDescription(String description) {
        List<Post> result = postRepository.searchAllByDescriptionContaining(description);
        return result;
    }

    @Override
    public List<Post> searchPostsByTitleOrDescription(String keyword) {
        List<Post> result = postRepository.searchAllByTitleContainingOrDescriptionContaining(keyword, keyword);
        return result;
    }

    @Override
    public List<Post> searchPostsByWriter(String name) {
        List<Post> result = postRepository.searchAllByWriterNameContaining(name);
        return result;
    }


    @Override
    public Post insertPost(com.clipit.clipitback.model.dto.Post post) {
        Post result = postRepository.save(convertPost(post));
        return result;
    }

    @Override
    public int deletePost(int id) {
        return postRepository.deleteById(id);
    }


    public Post convertPost(com.clipit.clipitback.model.dto.Post post) {
        ModelMapper mapper = new ModelMapper();
        Post postForSearch = mapper.map(post, Post.class);
        postForSearch.setWriterName(userService.getUserInfoById(post.getWriterId()).getUsername());
        return postForSearch;

    }

    @Override
    public List<Post> searchPostsByTag(String tagName) {
        List<Post> result = postRepository.searchAllByTagsName(tagName);
        return result;
    }
}
