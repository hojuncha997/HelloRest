package com.test.demo.dto;

public class FindUserRequest {
    String id;
    String name;
    String age;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public UserEntity toEntity() {
        return new UserEntity(
                this.id,
                this.name,
                this.age
        );
    }
}
