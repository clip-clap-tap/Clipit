package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.Post;
import com.clipit.clipitback.model.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/posts")
@Tag(name="Post-Controller")
public class PostController {
    private PostService postService;
    @Autowired
    PostController(PostService postService){
        this.postService = postService;
    }
    @Operation(summary = "포스트 검색")
    @GetMapping("/search")
    ResponseEntity<?> searchPost(){
        List<Post> posts = postService.searchPostsByCondition();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
