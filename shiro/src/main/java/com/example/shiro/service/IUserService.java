package com.example.shiro.service;

import com.example.daocommons.dto.UserDTO;

public interface IUserService {
    UserDTO saveUser(UserDTO dto);

    UserDTO getUser(String userId);
}
