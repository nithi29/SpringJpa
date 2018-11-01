package com.spring.service;

import java.util.List;

import com.spring.entity.UserEntity;


public interface UserService {
	    public  UserEntity getById(int userid);
	    public  UserEntity create(UserEntity user) throws Exception;
	    public  UserEntity update(UserEntity user) throws Exception;
	    public  int delete(int userid) throws Exception;
	    public  List<UserEntity> getAll();
}
