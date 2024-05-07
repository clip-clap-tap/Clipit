package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.UserProfile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.clipit.clipitback.model.dto.UserInfo;
import com.clipit.clipitback.model.service.UserService;

@RequestMapping("/users")
@RestController
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@Operation(summary="회원가입")
	@PostMapping("/signup")
	public ResponseEntity<?> signup(UserInfo userinfo){
		
		int res = userService.signup(userinfo);
		userService.registUserProfile(userinfo.getId());
		
		return new ResponseEntity<>(res, res==1? HttpStatus.OK : HttpStatus.BAD_REQUEST);
		
	}

	@Operation(summary="회원정보 확인")
	@GetMapping("/{id}/info")
	public ResponseEntity<?> getUserInfo(@PathVariable("id") String id){
		UserInfo userInfo = userService.getUserInfoById(id);
		return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
	}

	@Operation(summary="프로필 확인")
	@GetMapping("/profile/{id}")
	public ResponseEntity<?> getProfile(@PathVariable("id") String id){
		UserProfile userProfile = userService.getUserProfileById(id);
		userProfile.setId(id);

		return new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
	}


	@Operation(summary="프로필 수정")
	@PutMapping("/profile/{id}")
	public ResponseEntity<?> updateProfile(@PathVariable("id") String id, UserProfile userProfile){
		userProfile.setId(id);
		int res = userService.modifyUserProfile(userProfile);
		return new ResponseEntity<>(res, res==1? HttpStatus.OK : HttpStatus.BAD_REQUEST);

	}
}
