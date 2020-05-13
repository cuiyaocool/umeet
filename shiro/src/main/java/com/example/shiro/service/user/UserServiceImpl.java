package com.example.shiro.service.user;

import com.example.daocommons.dto.UserDTO;
import com.example.shiro.service.IUserService;

public class UserServiceImpl implements IUserService {
    @Override
    public UserDTO saveUser(UserDTO dto) {
        return new UserDTO();
    }

    @Override
    public UserDTO getUser(String userId) {
        return null;
    }
}
