package com.clipit.clipitback.controller;

import com.clipit.clipitback.model.dto.UserProfile;
import io.swagger.v3.oas.annotations.Operation;
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
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
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
	public ResponseEntity<?> signup(UserInfo userinfo){
		
		int res = userService.signup(userinfo);
		
		return new ResponseEntity<>(res, res==1? HttpStatus.OK : HttpStatus.BAD_REQUEST);
		
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

	@Operation(summary="프로필 확인")
	@GetMapping("/profile/{id}")
	public ResponseEntity<?> getProfile(@PathVariable("id") String id){
		UserProfile userProfile = userService.getUserProfileById(id);

		return new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
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
