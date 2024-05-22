package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.Comment;
import com.clipit.clipitback.model.dto.Post;
import com.clipit.clipitback.model.dto.SearchInfo;
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
    private final VideoService videoService;
    private final JWTService jwtService;

    private final PostSearchService postSearchService;

    @Autowired
    PostController(PostService postService, CommentService commentService, TagService tagService, VideoService videoService, JWTService jwtService, PostSearchService postSearchService) {
        this.postService = postService;
        this.commentService = commentService;
        this.tagService = tagService;
        this.videoService = videoService;
        this.jwtService = jwtService;
        this.postSearchService = postSearchService;
    }

    @Operation(summary = "포스트 검색")
    @GetMapping("/search")
    ResponseEntity<?> searchPost(SearchInfo searchInfo) {
        System.out.println(searchInfo);
        List<com.clipit.clipitback.model.entity.Post> posts = null;
        if (searchInfo.getCategory().isEmpty() || searchInfo.getCategory().equals("all")) {
            posts = postSearchService.search(searchInfo);
        } else {
            posts = postSearchService.searchByCategory(searchInfo);
        }
        System.out.println(posts);
        return new ResponseEntity<>(posts, HttpStatus.OK);

    }


    @Operation(summary = "타이틀로 포스트 검색")
    @GetMapping("/search/title")
    ResponseEntity<?> searchPostByTitle(@RequestParam(name = "title", required = false) String title) {
        List<com.clipit.clipitback.model.entity.Post> posts = postSearchService.searchPostsByTitle(title);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(summary = "상세내용으로 포스트 검색")
    @GetMapping("/search/description")
    ResponseEntity<?> searchPostByDescription(@RequestParam(name = "dsp", required = false) String description) {
        List<com.clipit.clipitback.model.entity.Post> posts = postSearchService.searchPostsByDescription(description);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

//    @Operation(summary = "타이틀 또는 상세내용으로 포스트 검색")
//    @GetMapping("/search")
//    ResponseEntity<?> searchPostByPostOrDescription(@RequestParam(name = "keyword", required = false) String keyword) {
//        List<com.clipit.clipitback.model.entity.Post> posts = postSearchService.searchPostsByTitleOrDescription(keyword);
//        return new ResponseEntity<>(posts, HttpStatus.OK);
//    }

    @Operation(summary = "작성자로 포스트 검색")
    @GetMapping("/search/writer")
    ResponseEntity<?> searchPostByWriterName(@RequestParam(name = "writer", required = false) String writer) {
        List<com.clipit.clipitback.model.entity.Post> posts = postSearchService.searchPostsByWriter(writer);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(summary = "태그로 포스트 검색")
    @GetMapping("/tag-earch")
    ResponseEntity<?> searchPostByTag(@RequestParam(name = "tagName", required = false) String tagName) {
        List<com.clipit.clipitback.model.entity.Post> posts = postSearchService.searchPostsByTag(tagName);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @Operation(summary = "id로 포스트 detail 받아오기")
    @GetMapping("/{id}")
    ResponseEntity<?> getPostById(@PathVariable("id") int id, @CookieValue(name = "token", required = false) String token) {
        Post post = postService.getPostDetailById(id);
        if (token != null) {
            postService.addVisitedPost(jwtService.getUserIdFromToken(token), post.getId());
        }
        int result = postService.increaseViewCount(post.getId());
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @Operation(summary = "전체 포스트 목록")
    @GetMapping()
    ResponseEntity<?> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(summary = "최근 포스트 목록")
    @GetMapping("/recent")
    ResponseEntity<?> getRecentPosts() {
        List<Post> posts = postService.getRecentPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(summary = "인기 포스트 목록")
    @GetMapping("/popular")
    ResponseEntity<?> getPopularPosts() {
        List<Post> posts = postService.getPopularPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(summary = "포스트 등록")
    @PostMapping()
    ResponseEntity<?> addPost(@RequestBody Post post, @CookieValue("token") String token) {
        post.setWriterId(jwtService.getUserIdFromToken(token));
        System.out.println(post);
        if (post.getTags() != null && !post.getTags().isEmpty()) {
            tagService.checkTagInfo(post.getTags());
        }

        if (post.getVideos() != null && !post.getVideos().isEmpty()) {
            videoService.checkVideoInfo(post.getVideos());
        }
        int result = postService.addPost(post);
        postSearchService.insertPost(postService.getPostDetailById(post.getId()));
        return new ResponseEntity<>(result, result == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED);
    }

    @Operation(summary = "포스트 수정")
    @PutMapping("/{id}")
    ResponseEntity<?> modifyPost(@PathVariable("id") int id, @CookieValue("token") String token, @RequestBody Post post) {
        post.setId(id);
        post.setWriterId(jwtService.getUserIdFromToken(token));
        int result = postService.modifyPost(post);
        postSearchService.updatePost(postService.getPostDetailById(post.getId()));
        if (result == 0) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(summary = "포스트 상태 수정")
    @PatchMapping("/{id}")
    ResponseEntity<?> modifyPostStatus(@PathVariable("id") int id, @RequestBody Map<String, String> statusInfo) {
        int result = postService.modifyPostStatus(id, statusInfo.get("status"));
        postSearchService.deletePost(id);
        if (result == 0) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(summary = "포스트 찜 여부 확인")
    @GetMapping("/{id}/favorite")
    ResponseEntity<?> checkIsFavorite(@PathVariable("id") int postId, @CookieValue("token") String token) {
        boolean result = postService.getIsFavorite(jwtService.getUserIdFromToken(token), postId);
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
    ResponseEntity<?> cancelFavoritePost(@PathVariable("id") int postId, @CookieValue("token") String token) {
        int result = postService.cancelFavoritePost(jwtService.getUserIdFromToken(token), postId);
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
        for (Comment comment : comments) {
            System.out.println(comment);
        }
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
    ResponseEntity<?> removeComment(@PathVariable("id") int id, @CookieValue("token") String token) {
        if (!jwtService.getUserIdFromToken(token).equals(commentService.getCommentById(id).getWriterId())) {
            return new ResponseEntity<>(0, HttpStatus.FORBIDDEN);
        }
        int result = commentService.removeComment(id);
        return new ResponseEntity<>(result, result == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.NO_CONTENT);
    }


}
