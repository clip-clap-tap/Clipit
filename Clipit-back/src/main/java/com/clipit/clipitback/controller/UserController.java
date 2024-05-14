package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.*;
import com.clipit.clipitback.model.service.PostService;
import com.clipit.clipitback.model.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.clipit.clipitback.model.service.UserService;

import java.util.List;
import java.util.Map;

@RequestMapping("/users")
@RestController
public class UserController {
	
	private final UserService userService;
	private final PostService postService;
	private final VideoService videoService;

	@Autowired
	public UserController(UserService userService, PostService postService, VideoService videoService) {

		this.userService = userService;
		this.postService = postService;
		this.videoService = videoService;
	}

	@Operation(summary = "전체 회원정보 목록")
	@GetMapping()
	public ResponseEntity<?> getAllUserInfo(){
		List<UserInfo> list = userService.getUserInfoList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Operation(summary = "회원정보 확인")
	@GetMapping("/{id}/info")
	public ResponseEntity<?> getUserInfo(@PathVariable("id") String id){
		UserInfo userInfo = userService.getUserInfoById(id);

		if(userInfo == null){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(userInfo, HttpStatus.OK);
	}

	@Operation(summary="회원가입")
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody UserInfo userinfo){
		int res = userService.signup(userinfo);
		
		return new ResponseEntity<>(res, res==1? HttpStatus.OK : HttpStatus.BAD_REQUEST);
		
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserInfo userInfo, HttpSession session){
		UserInfo target = userService.getUserInfoById(userInfo.getId());
		if(target.getPassword().equals(userInfo.getPassword())){
			session.setAttribute("userId", userInfo.getId());
			return new ResponseEntity<>(userInfo, HttpStatus.OK);
		}
		return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
	}

	@Operation(summary="회원정보 수정")
	@PutMapping("/{id}/info")
	public ResponseEntity<?> modifyUserInfo(@PathVariable("id") String id, UserInfo userInfo){
		userInfo.setId(id);
		int res = userService.modifyUserInfo(userInfo);
		return new ResponseEntity<>(res, res==1? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@Operation(summary="회원 탈퇴")
	@PatchMapping("/{id}/info")
	public ResponseEntity<?> inactivate(@PathVariable("id") String id){
		int res = userService.inactivate(id);
		return new ResponseEntity<>(res, res==1? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@Operation(summary="찜한 포스트 목록 확인")
	@GetMapping("/{id}/favorite-posts")
	public ResponseEntity<?> getFavoritePostsByUserId(String id){
		List<Post> list = postService.getFavoritePostsByUserId(id);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Operation(summary="게시한 포스트 목록 확인")
	@GetMapping("/{id}/posts")
	public ResponseEntity<?> getWrittenPostsByUserId(String id){
		List<Post> list = postService.getPostsByWriterId(id);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Operation(summary="최근 방문 포스트 목록 확인")
	@GetMapping("/visited-posts")
	public ResponseEntity<?> getVisitedPostsByUserId(@SessionAttribute("userId") String userId){
		List<Post> list = postService.getVisitedPostsByUserId(userId);
		System.out.println(list);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

//	@Operation(summary="최근 열람 포스트 추가")
//	@PostMapping("/{id}/visited-posts")
//	public ResponseEntity<?> addVisitedPosts(@PathVariable("id") String id, @RequestBody Post post){
//		int res = postService.addVisitedPosts(id);
//		return new ResponseEntity<>(res, res==1? HttpStatus.OK : HttpStatus.BAD_REQUEST);
//	}

	@Operation(summary="마크한 영상 목록 확인")
	@GetMapping("/{id}/marked-videos")
	public ResponseEntity<?> getMarkedVideosByUserId(String id){
		List<MarkedVideo> list = videoService.getMarkedVideosByUserId(id);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}



	@Operation(summary="유저별 전체 포스트 목록 확인")
	@GetMapping("/{id}/all-posts")
	public ResponseEntity<?> getFavoriteOrWrittenPostsByUserId(String id){
		List<Post> list = postService.getAllPostsByUserId(id);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}


	@Operation(summary="프로필 확인")
	@GetMapping("/profile/{id}")
	public ResponseEntity<?> getProfile(@PathVariable("id") String id){
		UserProfile userProfile = userService.getUserProfileById(id);

		if(userProfile==null){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userProfile, HttpStatus.OK);
	}


	@Operation(summary="프로필 수정")
	@PutMapping("/profile/{id}")
	public ResponseEntity<?> updateProfile(@PathVariable("id") String id, UserProfile userProfile){
		userProfile.setId(id);
		int res = userService.modifyUserProfile(userProfile);
		return new ResponseEntity<>(res, res==1? HttpStatus.OK : HttpStatus.BAD_REQUEST);

	}

	@Operation(summary="프로필 등록")
	@PostMapping("/profile/{id}")
	public ResponseEntity<?> regist(@PathVariable("id") String id, @RequestBody UserProfile userProfile){

		userProfile.setId(id);
		int res = userService.registUserProfile(userProfile);
		return new ResponseEntity<>(res, res==1? HttpStatus.OK : HttpStatus.BAD_REQUEST);

	}
}
