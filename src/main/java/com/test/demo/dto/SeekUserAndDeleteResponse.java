package com.test.demo.dto;

public class SeekUserAndDeleteResponse {
    String id;
    String name;
    String age;
    
    
    
    //타 객체로부터 값을 받기 위한 생성자
    public SeekUserAndDeleteResponse(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }




}
