package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.*;
import com.clipit.clipitback.model.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final TagService tagService;
    private final VideoService videoService;
    private final JWTService jwtService;
    private final KakaoService kakaoService;

    @Autowired
    public UserController(UserService userService, PostService postService, TagService tagService, VideoService videoService, JWTService jwtService, PostSearchService postSearchService, KakaoService kakaoService) {

        this.userService = userService;
        this.postService = postService;
        this.tagService = tagService;
        this.videoService = videoService;
        this.jwtService = jwtService;
        this.kakaoService = kakaoService;
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
        String token = userService.login(userinfo);

        HttpHeaders headers = new HttpHeaders();
        ResponseCookie resCookie = ResponseCookie.from("token", token).maxAge(1000 * 60).path("/").httpOnly(true).secure(false).build();
        headers.set(HttpHeaders.SET_COOKIE, resCookie.toString());

        return new ResponseEntity<>(token, headers, HttpStatus.OK);
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
    public ResponseEntity<?> modifyUserInfo(@PathVariable("id") String id, @RequestBody UserInfo userInfo) {
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

    @Operation(summary = "찜한 포스트/작성한 포스트 목록 확인")
    @GetMapping("/{id}/all-posts")
    public ResponseEntity<?> getWrittenOrFavoritePostsByUserId(@PathVariable("id") String id) {
        List<Post> list = postService.getWrittenOrFavoritePostsByUserId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @Operation(summary = "찜한 포스트 목록 확인")
    @GetMapping("/{id}/favorite-posts")
    public ResponseEntity<?> getFavoritePostsByUserId(@PathVariable("id") String id) {
        List<Post> list = postService.getFavoritePostsByUserId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Operation(summary = "게시한 포스트 목록 확인")
    @GetMapping("/{id}/posts")
    public ResponseEntity<?> getWrittenPostsByUserId(@PathVariable("id") String id) {
        List<Post> list = postService.getWrittenPostsByUserId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Operation(summary = "최근 방문 포스트 목록 확인")
    @GetMapping("/visited-posts")
    public ResponseEntity<?> getVisitedPostsByUserId(@CookieValue("token") String token) {
        List<Post> list = postService.getVisitedPostsByUserId(jwtService.getUserIdFromToken(token));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @Operation(summary = "마크한 영상 목록 확인")
    @GetMapping("/{id}/marked-videos")
    public ResponseEntity<?> getMarkedVideosByUserId(String id) {
        List<MarkedVideo> list = videoService.getMarkedVideosByUserId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Operation(summary = "관심 태그 목록")
    @GetMapping("/{id}/tags")
    public ResponseEntity<?> getFavoriteTagsByUserId(@PathVariable("id") String id) {

        List<FavoriteTag> list = tagService.getFavoriteTagsByUserId(id);

        System.out.println(list);

        if (list.size() == 0) {
            return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @Operation(summary = "관심 태그 등록")
    @PostMapping("/{id}/tags")
    public ResponseEntity<?> addFavoriteTagsByUserId(@PathVariable("id") String id, @RequestBody List<Tag> tags, @CookieValue("token") String token) {

        tagService.checkTagInfo(tags);

        int res = tagService.addUserFavoriteTag(id, tags);

        return new ResponseEntity<>(res, res == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }

    @Operation(summary = "관심 태그 수정")
    @PutMapping("/{id}/tags")
    public ResponseEntity<?> modifyFavoriteTagsByUserId(@PathVariable("id") String id, @RequestBody List<Tag> tags) {

        tagService.checkTagInfo(tags);

        int res = tagService.modifyFavoriteTag(id, tags);

        return new ResponseEntity<>(res, res == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }


    @Operation(summary = "프로필 확인")
    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getProfile(@PathVariable("id") String id) {
        UserProfile userProfile = userService.getUserProfileById(id);
        System.out.println(id);

        if (userProfile == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }


    @Operation(summary = "프로필 수정")
    @PutMapping("/profile/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable("id") String id, @RequestBody UserProfile userProfile) {
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

    @GetMapping("/login/kakao")
    public ResponseEntity<?> kakaoLogin() throws URISyntaxException {
        StringBuffer url = new StringBuffer();
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("client_id=27b5dbc96596ad8fccb20d4c85f25f2b");
        url.append("&redirect_uri=http://localhost:8080/users/login/kakao/token");
        url.append("&response_type=code");

        URI redirectUri = new URI(url.toString());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUri);


        return new ResponseEntity<>("login", httpHeaders, HttpStatus.TEMPORARY_REDIRECT);
    }

    @GetMapping("/login/kakao/token")
    public ResponseEntity<?> kakaoGetToken(@RequestParam("code") String code) throws URISyntaxException, JsonProcessingException {
        String accessToken = kakaoService.getKakaoToken(code);
        UserInfo user = kakaoService.getKakaoInfo(accessToken);
        user = kakaoService.getUserInfo(user);
        String token = userService.login(user);

        URI redirectUri = new URI("http://localhost:5173/login");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(redirectUri);

        ResponseCookie resCookie = ResponseCookie.from("token", token).maxAge(1000 * 60).path("/").httpOnly(true).secure(false).build();
        headers.set(HttpHeaders.SET_COOKIE, resCookie.toString());

        return new ResponseEntity<>(token, headers, HttpStatus.TEMPORARY_REDIRECT);


    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@CookieValue(value = "token", required = false) String token) {
        boolean result = token != null ? jwtService.validate(token) : false;
        return new ResponseEntity<>(token, result ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }

    @GetMapping("/{id}/exercise-history")
    public ResponseEntity<?> getHistory(@PathVariable("id") String id) {
        int[] history = userService.getUserExerciseHistory(id);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @GetMapping("/{id}/exercise-statistics")
    public ResponseEntity<?> getExerciseStatistics(@PathVariable("id") String id) {
        Map<String, Integer> statistics = userService.getUserExerciseStatistics(id);
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @GetMapping("/{id}/post-statistics")
    public ResponseEntity<?> getPostStatistics(@PathVariable("id") String id) {
        Map<String, Integer> statistics = userService.getUserPostStatistics(id);
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

}
