package com.test.demo.dto;

public class FindUserResponse {
    String id;
    String name;



    public FindUserResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static FindUserResponse from(UserEntity userEntity) {
        return new FindUserResponse(
                userEntity.getId(),
                userEntity.getName()
        );
    }

}
