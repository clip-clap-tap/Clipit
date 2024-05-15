package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.Comment;
import com.clipit.clipitback.model.dto.Post;
import com.clipit.clipitback.model.service.*;
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
    private final CommentService commentService;
    private final TagService tagService;
    private final JWTService jwtService;

    private final PostSearchService postSearchService;

    @Autowired
    PostController(PostService postService, CommentService commentService, TagService tagService, JWTService jwtService, PostSearchService postSearchService) {
        this.postService = postService;
        this.commentService = commentService;
        this.tagService = tagService;
        this.jwtService = jwtService;
        this.postSearchService = postSearchService;
    }

    @Operation(summary = "포스트 검색")
    @GetMapping("/search")
    ResponseEntity<?> searchPost(@RequestParam(name = "title", required = false) String title) {
//        List<Post> posts = postService.searchPostsByCondition();
        List<com.clipit.clipitback.model.entity.Post> posts = postSearchService.searchPostsByTitle(title);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(summary = "id로 포스트 검색")
    @GetMapping("/{id}")
    ResponseEntity<?> getPostById(@PathVariable("id") int id) {
        Post post = postService.getPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @Operation(summary = "전체 포스트 목록")
    @GetMapping()
    ResponseEntity<?> getAllPosts(@CookieValue("token") String token) {
        List<Post> posts = postService.getAllPosts();
        jwtService.validate(token);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(summary = "포스트 등록")
    @PostMapping()
    ResponseEntity<?> addPost(@RequestBody Post post, @CookieValue("token") String token) {
        post.setWriterId(jwtService.getUserIdFromToken(token));
        int result = postService.addPost(post);
        if (post.getTags() != null && !post.getTags().isEmpty()) {
            tagService.checkTagInfo(post.getTags());
            tagService.addPostTag(post);
        }
        return new ResponseEntity<>(result, result == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED);
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
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(summary = "포스트 찜하기")
    @PutMapping("/{id}/favorite")
    ResponseEntity<?> addFavoritePost(@PathVariable("id") int postId, @CookieValue("token") String token) {
        int result = postService.addFavoritePost(jwtService.getUserIdFromToken(token), postId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(summary = "포스트 찜하기 취소")
    @DeleteMapping("/{id}/favorite")
    ResponseEntity<?> cancelFavoritePost(@PathVariable("id") int postId, @SessionAttribute(name = "userId") String userId) {
        int result = postService.cancelFavoritePost(userId, postId);
        return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "포스트 방문기록 추가")
    @PostMapping("/{id}/visited-posts")
    ResponseEntity<?> addVisitedPost(@PathVariable("id") int postId, @CookieValue("token") String token) {

        int result = postService.addVisitedPost(jwtService.getUserIdFromToken(token), postId);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Operation(summary = "포스트에 댓글 추가")
    @PostMapping("/{id}/comment")
    ResponseEntity<?> addPostComment(@PathVariable("id") int postId, @CookieValue("token") String token, @RequestBody Comment comment) {
        int result = commentService.addComment(postId, jwtService.getUserIdFromToken(token), comment);
        return new ResponseEntity<>(result, result == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED);
    }

    @Operation(summary = "포스트에 달린 댓글 목록")
    @GetMapping("/{id}/comments")
    ResponseEntity<?> getPostComments(@PathVariable("id") int postId) {
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @Operation(summary = "댓글 수정")
    @PutMapping("/comment/{id}")
    ResponseEntity<?> modifyComment(@PathVariable("id") int id, @RequestBody Comment comment) {
        comment.setId(id);
        int result = commentService.modifyComment(comment);
        return new ResponseEntity<>(result, result == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/comment/{id}")
    ResponseEntity<?> removeComment(@PathVariable("id") int id) {
        int result = commentService.removeComment(id);
        return new ResponseEntity<>(result, result == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.NO_CONTENT);
    }


}
