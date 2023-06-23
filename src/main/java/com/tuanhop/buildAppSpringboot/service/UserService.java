package com.tuanhop.buildAppSpringboot.service;

import com.tuanhop.buildAppSpringboot.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findUsers();
    void saveUser(UserDTO userDTO);
}

