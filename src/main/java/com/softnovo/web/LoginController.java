package com.softnovo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.softnovo.domain.User;
import com.softnovo.service.UserService;

@RestController
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index")
	public String loginPage() {
		return "index";
	}
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public String add() {
		userService.addUser(null);
		return "adddfdfdf";
	}

	@RequestMapping(value = "/main")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
		User user = new User();
		user.setUserName("cccc");
		user.setUserId(123);
		user.setPassword("********");
		request.getSession().setAttribute("user", user);
		return new ModelAndView("main");
	}
}
