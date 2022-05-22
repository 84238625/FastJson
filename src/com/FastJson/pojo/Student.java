package com.FastJson.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private  Integer id;
    private String name;
    private Integer age;
    private String email;
    private Date birthday;

}
