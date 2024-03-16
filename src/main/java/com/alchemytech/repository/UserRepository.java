package com.alchemytech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alchemytech.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
