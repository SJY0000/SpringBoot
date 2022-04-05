package com.myapp.mobile.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.mobile.model.request.UpdateUserRequest;
import com.myapp.mobile.model.request.UserRequest;
import com.myapp.mobile.model.response.UserRest;

@RestController
@RequestMapping("/users") //localhost:8070/users
public class UserController {
	
	Map<String, UserRest> users;
	
	// 효율적으로 DB를 사용하기 위해 Page 숫자와 page 당 가져올 Data 수를 정한다.
	@GetMapping
	public String getUserList(@RequestParam(value = "page", defaultValue = "1") int page,  // defaultValue -> Parameter를 입력하지 않아도 기본값 설정
								@RequestParam(value = "limit", defaultValue = "50") int limit,
								@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {  // required = false -> 값이 없어도 됨
		
		return "Return User List Page : " + page + " 페이지당 유저 수 : " + limit + " 정렬방법 : " + sort;
	}

	@GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE,
												MediaType.APPLICATION_XML_VALUE}) // produces는 Return 데이터 타입을 정해줌
	public ResponseEntity<UserRest> getUser(@PathVariable("userId") String id) { // 기본적으로 String 타입이지만 원하는 타입으로 지정 시 자동으로 변환
		
//		// Java 객체 User를 Return
//		UserRest returnUser = new UserRest();
//		
//		returnUser.setName("홍 길동");
//		returnUser.setEmail("hong@naver.com");
//		returnUser.setUserId(id);
		// id로 찾아서 User가 있으면 OK, 없으면 No_CONTENT로 Return
		if (users.containsKey(id)) {
			// 객체로 Return 할 시 RestController에서는 JSON 타입으로 Return
			return new ResponseEntity<UserRest>(users.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(users.get(id), HttpStatus.NO_CONTENT);
		}
		

	}
	
	@GetMapping("/bad")
	public ResponseEntity<String> badRequest() {
		return new ResponseEntity<String>("잘못된 요청", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping
	public ResponseEntity<UserRest> getCreateUser(@Valid @RequestBody UserRequest user) { // Date를 입력할 때는 Body에 담아야함
		UserRest returnUser = new UserRest();
		
		returnUser.setName(user.getName());
		returnUser.setEmail(user.getEmail());
		String userId = UUID.randomUUID().toString(); // 랜덤으로 Unique한 아이디 값을 정해줌
		returnUser.setUserId(userId);
		
		if (users == null) users = new HashMap<>(); // 싱글턴 -> 선언된 Map<문자열, UserRest>가 없으면 새로 생성
		
		users.put(userId, returnUser);	// (userId, UserRest) 객체 쌍으로 입력
		
		return new ResponseEntity<UserRest>(returnUser, HttpStatus.CREATED);
	}
	// Update 시 id 입력하고 body에 Update할 Name을 JSON으로 입력한다.
	@PutMapping("/{userId}")
	public UserRest getUpdateUser(@PathVariable("userId") String id, 
								@Valid @RequestBody UpdateUserRequest user) {
		UserRest savedUser = users.get(id);
		savedUser.setName(user.getName()); // 이름 수정됨
		return savedUser;
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> getDeleteUser(@PathVariable("userId") String id) {
		users.remove(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
