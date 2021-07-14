package com.test.demo.controller;

import java.util.List;

import com.test.demo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.demo.service.UserService;

@RestController
public class HelloController {

	
	@Autowired
	UserService userService;
	
	@GetMapping("/hello")
	public String hi(@RequestParam(required = false, name = "name") String name) {
		//https://velog.io/@hellozin/RequestParamrequired-false-%EC%A3%BC%EC%9D%98%ED%95%A0-%EC%A0%90
		
//		if(name==null) {
//			return "no parameter";
//		} else {
//			return name;	
//		} 
// 			이렇게 하면 로직이 통째로 하나이다. 그리고 else를 뺄 수 있으면 뺴는 게  좋다. 한 번 더 연산하기 때문이다.
// 			그리고 부정 연산 '!='는 최대한 안 쓰는 게 좋다. 위와 같은 이유다.
		
		if(name==null) {
			return "no parameter";
		}
		return name;
		//로직이 두 개가 되고 빨라진다.
	}

	@GetMapping(path = "/userlist")
	public List<UserDto> getAllUsers() {
		return this.userService.getUsers();
	}

	@PostMapping(path = "/user")
	public AddUserResponse addUser(@RequestBody AddUserRequest request) {

		UserEntity user = request.toEntity();

		this.userService.saveUser(user);

		return new AddUserResponse(user.getName());
	}

	@GetMapping(path = "/finduser")
	public FindUserResponse finduser(String inputId) {
	//public FindUserResponse finduser(@RequestBody FindUserRequest request) 	{
	// 굳이 객체로 받지 않아도 된다. id 조회이기 때문에 String만 받아도 충분하다. 따라서 수정
	//	UserEntity user = request.toEntity(); id조회는 문자열만 있어도 되기 때문에 굳이 객체를 만들어줄 필요가 없다.
		//String inputId를 받는 것은 @RequestParam을 사용해 볼 것.

		UserEntity found = this.userService.findUserById(inputId);

		return FindUserResponse.from(found);
	}



	@GetMapping(path="/deleteUser")
	public int deleteUser  (@RequestParam(required = true, name = "id") String inputId) {
		return this.userService.deleteUser(inputId);
	}


	@PostMapping("/postMethod2")
	public String postMethod(String name) {
		return name; 
	}

	/*
	 영서님 방법

	@GetMapping("/seekUser")
	public SeekUserAndDeleteResponse seekUser(@RequestParam(name = "id") String inputId) {
		try {
			UserEntity toResponse = this.userService.seekUserById(inputId);

			SeekUserAndDeleteResponse seekRes = toResponse.toSeekUserResponse();
			return seekRes;
		} catch (RuntimeException exception) {
			return new SeekUserAndDeleteResponse(null,null,null);
		}
	}
*/


	@GetMapping("/findUserAndDelete")
	public SeekUserAndDeleteResponse seekUserAndDelete(@RequestParam(name="id") String inputId) {
		SeekUserAndDeleteResponse seekUserAndDeleteResponse = this.userService.seekUserByIdAndDelete(inputId);

		return seekUserAndDeleteResponse;

		//"위의 데이터가 삭제되었습니다." 라는 메시지 내보내기
		// NumberOfDeletedUser 변수 내보내는 방식 질문하기.

	}


}