package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.Post;
import com.clipit.clipitback.model.dto.UserProfile;
import com.clipit.clipitback.model.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.clipit.clipitback.model.dto.UserInfo;
import com.clipit.clipitback.model.service.UserService;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
	
	private final UserService userService;
	private final PostService postService;

	@Autowired
	public UserController(UserService userService, PostService postService) {

		this.userService = userService;
		this.postService = postService;
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
