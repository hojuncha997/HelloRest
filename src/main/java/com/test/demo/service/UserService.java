package com.test.demo.service;

import java.util.List;
import java.util.Map;

import com.test.demo.dto.SeekUserAndDeleteResponse;
import com.test.demo.dto.UserDto;
import com.test.demo.dto.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public List<UserDto> getUsers() {
		return this.userMapper.getUsers();
	}

	public int saveUser(UserEntity userEntity) {
		return this.userMapper.insertUser(userEntity);
	}

	public UserEntity findUserById(String inputId) {
		return this.userMapper.selectUserById(inputId);
	}

	public int deleteUser(String inputId) {
		return this.userMapper.deleteUserById(inputId);
	}





	public SeekUserAndDeleteResponse seekUserByIdAndDelete(String inputId) {
		UserEntity userEntity = this.userMapper.selectUserById(inputId); //기존 메소드 재사용
		
		SeekUserAndDeleteResponse seekUserAndDeleteResponse = userEntity.toSeekUserAndDeleteResponse();
		//userEntity에 담긴 데이터를 SeekUserAndDeleteResponse객체에 옮겨 담기
		
		if(seekUserAndDeleteResponse == null) {
			throw new RuntimeException(inputId+"사용자를 찾을 수 없습니다!");
		}
		int NumberOfDeletedUser = this.userMapper.deleteUserById(inputId); //기존 메소드 재사용
		
		
		return seekUserAndDeleteResponse;
//
	}
}
