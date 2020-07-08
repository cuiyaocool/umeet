package com.example.daocommons.data;

import lombok.Data;

import java.util.Date;

@Data
public class UserData {
    private Integer userId;
    private String name;
    private String nickName;
    private String avatarUrl;
    private String mobile;
    private int gender;
    private String country;
    private String province;
    private String city;
    private String password;
    private Date birthday;
    private int status;
    private String email;
}
