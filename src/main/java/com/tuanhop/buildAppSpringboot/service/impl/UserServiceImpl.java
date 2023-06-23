package com.tuanhop.buildAppSpringboot.service.impl;


import com.tuanhop.buildAppSpringboot.dto.UserDTO;
import com.tuanhop.buildAppSpringboot.entity.UserEntity;
import com.tuanhop.buildAppSpringboot.repository.UserRepository;
import com.tuanhop.buildAppSpringboot.service.UserService;
import com.tuanhop.buildAppSpringboot.util.ModelMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<UserDTO> findUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return ModelMapperUtils.mapAll(userEntities,UserDTO.class);
    }

    /**
     *
     */
    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity userEntity = ModelMapperUtils.map(userDTO, UserEntity.class);
        userRepository.save(userEntity);
    }
}
