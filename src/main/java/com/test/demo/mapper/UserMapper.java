package com.test.demo.mapper;

import java.util.List;
import java.util.Map;

import com.test.demo.dto.UserDto;
import com.test.demo.dto.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	List<UserDto> getUsers();

	int insertUser(UserEntity user); //마이바티스에서 사용자 추가는 int로 한다.https://pjs21s.github.io/mybatis-return-int/

	int deleteUserById(String inputId); //사용자 데이터 삭제

	//int updateById(String inputId);

	UserEntity selectUserById(String inputId); //id로 유저 선택하기


}