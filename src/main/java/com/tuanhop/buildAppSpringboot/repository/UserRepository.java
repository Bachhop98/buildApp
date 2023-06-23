package com.tuanhop.buildAppSpringboot.repository;

import com.tuanhop.buildAppSpringboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<UserEntity, Long> {

}