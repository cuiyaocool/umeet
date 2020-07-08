package com.example.daocommons.dto;

import com.example.daocommons.data.UserData;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserDTO {
    private Integer userId;
    @NotNull(message = "name不能为空")
    private String name;
    private String nickName;
    private String avatarUrl;
    private String mobile;
    private Integer gender;
    private String country;
    private String province;
    private String city;
    private String password;
    private Date birthday;
    @Pattern(regexp = "-1|0|1|2", message = "状态无效")
    private Integer status;
    private String email;

    public UserDTO(UserData data) {
        this.userId = data.getUserId();
        this.name = data.getName();
        this.nickName = data.getNickName();
        this.avatarUrl = data.getAvatarUrl();
        this.mobile = data.getMobile();
        this.gender = data.getGender();
        this.country = data.getCountry();
        this.province = data.getProvince();
        this.city = data.getCity();
        this.password = data.getPassword();
        this.birthday = data.getBirthday();
        this.status = data.getStatus();
        this.email = data.getEmail();
    }

    public UserData toData() {
        UserData data = new UserData();
        data.setUserId(userId);
        data.setName(name);
        data.setNickName(nickName);
        data.setAvatarUrl(avatarUrl);
        data.setMobile(mobile);
        data.setGender(gender == null || gender == 0 ? 0 : gender);
        data.setCountry(country);
        data.setProvince(province);
        data.setCity(city);
        data.setPassword(password);
        data.setBirthday(birthday);
        data.setStatus(status == null || status == 0 ? 0 : status);
        data.setEmail(email);
        return data;
    }
}
