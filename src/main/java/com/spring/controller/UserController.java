package com.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.UserEntity;
import com.spring.service.UserService;
import com.spring.service.UserServiceImpl;

@Controller
@RequestMapping(value = "/")
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 
	 * @param user - get all users
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView list(@ModelAttribute("user") UserEntity user) {
		ModelAndView model = new ModelAndView("list");
		List<UserEntity> userList = userService.getAll();
		//System.out.println(userList);
		model.addObject("userList", userList);
		return model;

	}
	/**
	 * 
	 * @param user - NEW FORM
	 * @return
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView newForm(@ModelAttribute("user") UserEntity user) {
		ModelAndView model = new ModelAndView("form");
		model.addObject("isAdd", true);

		return model;

	}
	/**
	 * 
	 * @param user - CREATE NEW USER
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("user") UserEntity user) {

		try {
			userService.create(user);
			System.out.println("nEW USER CREATED"+user);
			return new ModelAndView("redirect:/");
		} catch (Exception ex) {
			ModelAndView model = new ModelAndView("form");
			model.addObject("error", ex.getMessage());
			model.addObject("user", user);
			return model;
		}
	}
	/**
	 * 
	 * @param user - DELETE THE USER
	 * @return
	 */
	@RequestMapping(value = "/delete/{userid}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView delete(@PathVariable int userid) throws Exception {
		// ModelAndView model = new ModelAndView("delete");

		userService.delete(userid);
		System.out.println(userid);
		return new ModelAndView("redirect:/");

	}
	/**
	 * 
	 * @param user - GET THE USER BY ID
	 * @return
	 */
	@RequestMapping(value = "/edit/{userid}")
	public ModelAndView edit(@PathVariable int userid) {
		System.out.println("edit by getting id");
		UserEntity user = userService.getById(userid);
		ModelAndView model = new ModelAndView("form");
		model.addObject("user", user);
		model.addObject("isEdit", true);
		return model;
	}
	
	/**
	 * 
	 * @param user - UPDATE THE USER
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")	
	public ModelAndView editUser(@ModelAttribute("user") UserEntity user) throws Exception {
		
		try{
			UserEntity entity = userService.update(user);
			System.out.println("after update entity " + entity.getUserid());
		return new ModelAndView("redirect:/");
		} catch (Exception ex) {
			ModelAndView model = new ModelAndView("form");
			model.addObject("error", ex.getMessage());
			model.addObject("user", user);
			return model;
		}
	
		
	}
}
