package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.MarkedVideo;
import com.clipit.clipitback.model.dto.Post;
import com.clipit.clipitback.model.dto.UserInfo;
import com.clipit.clipitback.model.dto.UserProfile;
import com.clipit.clipitback.model.service.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final VideoService videoService;
    private final JWTService jwtService;

    private final PostSearchService postSearchService;

    @Autowired
    public UserController(UserService userService, PostService postService, VideoService videoService, JWTService jwtService, PostSearchService postSearchService) {

        this.userService = userService;
        this.postService = postService;
        this.videoService = videoService;
        this.jwtService = jwtService;
        this.postSearchService = postSearchService;
    }

    @Operation(summary = "전체 회원정보 목록")
    @GetMapping()
    public ResponseEntity<?> getAllUserInfo() {
        List<UserInfo> list = userService.getUserInfoList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Operation(summary = "회원정보 확인")
    @GetMapping("/{id}/info")
    public ResponseEntity<?> getUserInfo(@PathVariable("id") String id) {
        UserInfo userInfo = userService.getUserInfoById(id);

        if (userInfo == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserInfo userinfo) {
        int res = userService.signup(userinfo);

        return new ResponseEntity<>(res, res == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);

    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserInfo userInfo) {
        String token = userService.login(userInfo);
        if (token == null) {
            return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        ResponseCookie resCookie = ResponseCookie.from("token", token).maxAge(1000 * 60).path("/").httpOnly(true).secure(false).build();
        headers.set(HttpHeaders.SET_COOKIE, resCookie.toString());

        return new ResponseEntity<>(token, headers, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {

        HttpHeaders headers = new HttpHeaders();
        ResponseCookie resCookie = ResponseCookie.from("token", "deleted").maxAge(0).path("/").httpOnly(true).secure(false).build();
        headers.set(HttpHeaders.SET_COOKIE, resCookie.toString());

        return new ResponseEntity<>("deleted", headers, HttpStatus.OK);
    }


    @Operation(summary = "회원정보 수정")
    @PutMapping("/{id}/info")
    public ResponseEntity<?> modifyUserInfo(@PathVariable("id") String id, UserInfo userInfo) {
        userInfo.setId(id);
        int res = userService.modifyUserInfo(userInfo);
        return new ResponseEntity<>(res, res == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "회원 탈퇴")
    @PatchMapping("/{id}/info")
    public ResponseEntity<?> inactivate(@PathVariable("id") String id) {
        int res = userService.inactivate(id);
        return new ResponseEntity<>(res, res == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "찜한 포스트 목록 확인")
    @GetMapping("/{id}/favorite-posts")
    public ResponseEntity<?> getFavoritePostsByUserId(String id) {
        List<com.clipit.clipitback.model.entity.Post> list = postSearchService.searchPostsByUserId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Operation(summary = "게시한 포스트 목록 확인")
    @GetMapping("/{id}/posts")
    public ResponseEntity<?> getWrittenPostsByUserId(@PathVariable("id") String id) {
        List<com.clipit.clipitback.model.entity.Post> list = postSearchService.searchPostsByUserId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Operation(summary = "최근 방문 포스트 목록 확인")
    @GetMapping("/visited-posts")
    public ResponseEntity<?> getVisitedPostsByUserId(@CookieValue("token") String token) {
        List<Post> list = postService.getVisitedPostsByUserId(jwtService.getUserIdFromToken(token));
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @Operation(summary = "마크한 영상 목록 확인")
    @GetMapping("/{id}/marked-videos")
    public ResponseEntity<?> getMarkedVideosByUserId(String id) {
        List<MarkedVideo> list = videoService.getMarkedVideosByUserId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @Operation(summary = "프로필 확인")
    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getProfile(@PathVariable("id") String id) {
        UserProfile userProfile = userService.getUserProfileById(id);

        if (userProfile == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }


    @Operation(summary = "프로필 수정")
    @PutMapping("/profile/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable("id") String id, UserProfile userProfile) {
        userProfile.setId(id);
        int res = userService.modifyUserProfile(userProfile);
        return new ResponseEntity<>(res, res == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);

    }

    @Operation(summary = "프로필 등록")
    @PostMapping("/profile/{id}")
    public ResponseEntity<?> regist(@PathVariable("id") String id, @RequestBody UserProfile userProfile) {

        userProfile.setId(id);
        int res = userService.registUserProfile(userProfile);
        return new ResponseEntity<>(res, res == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);

    }
}
