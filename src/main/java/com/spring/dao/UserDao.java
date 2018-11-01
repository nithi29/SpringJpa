package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer>{
 
}
	
	