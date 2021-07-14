package com.test.demo.dto;

public class AddUserResponse {
    String name;

    public AddUserResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
