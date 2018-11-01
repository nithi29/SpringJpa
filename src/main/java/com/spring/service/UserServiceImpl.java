package com.spring.service;

import java.util.List;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.spring.dao.UserDao;
import com.spring.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Transactional
	public UserEntity create(UserEntity user) throws Exception {validateUser(user);
 	userDao.save(user);
   System.out.println(user.getUserid());
    return user;
	
	}
	@Transactional
	public UserEntity update(UserEntity user) throws Exception {
		validateUser(user);
       return userDao.save(user);
	}
	@Transactional
	public int delete(int userid) throws Exception {
		userDao.delete(userid);
		return userid;
	}
	@Transactional
	public List<UserEntity> getAll() {
		return (List<UserEntity>) userDao.findAll();

	}
	@Transactional
	public UserEntity getById(int userid) {
		return userDao.findOne(userid);
	}

	private void validateUser(UserEntity user) throws Exception {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);

		String regex = "^[a-zA-Z]+$";
		
		if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
			throw new Exception("First name is required");
		} else if (user.getFirstName().length() < 3) {
			throw new Exception("First name is too short");
		} else if (user.getFirstName().matches(regex) == false || user.getLastName().matches(regex) == false) {
			throw new Exception("Name should be in alphabets only");
		} else if (user.getLastName() == null || user.getLastName().isEmpty()) {
			throw new Exception("Last name is required");
		} else if (user.getLastName().length() < 1) {
			throw new Exception("Last name is too short");
		} else if (user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new Exception("Email cant be empty");
		} else if (user.getEmail().matches(emailRegex) == false) {
			throw new Exception("Invalid mail address");
		} else if(user.getFirstName().length() > 50 || user.getLastName().length() >50){
			throw new Exception("Name is too long");			
		}

	}
}

