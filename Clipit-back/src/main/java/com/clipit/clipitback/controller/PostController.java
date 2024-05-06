package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.Post;
import com.clipit.clipitback.model.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/posts")
@Tag(name = "Post-Controller")
public class PostController {
    private final PostService postService;

    @Autowired
    PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(summary = "포스트 검색")
    @GetMapping("/search")
    ResponseEntity<?> searchPost() {
        List<Post> posts = postService.searchPostsByCondition();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(summary = "전체 포스트 목록")
    @GetMapping()
    ResponseEntity<?> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(summary = "포스트 등록")
    @PostMapping()
    ResponseEntity<?> addPost(@RequestBody Post post) {
        int result = postService.addPost(post);
        if (result == 1) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(summary = "포스트 수정")
    @PutMapping("/{id}")
    ResponseEntity<?> modifyPost(@PathVariable("id") int id, @RequestBody Post post) {
        post.setId(id);
        int result = postService.modifyPost(post);
        if (result == 0) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(summary = "포스트 상태 수정")
    @PatchMapping("/{id}")
    ResponseEntity<?> modifyPostStatus(@PathVariable("id") int id, @RequestBody Map<String, String> statusInfo) {
        int result = postService.modifyPostStatus(id, statusInfo.get("status"));
        if (result == 0) {
            return new ResponseEntity<>(1, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
