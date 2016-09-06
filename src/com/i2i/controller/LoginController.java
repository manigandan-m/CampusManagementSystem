package com.i2i.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DatabaseException;
import com.i2i.service.UserService;
import com.i2i.model.Role;
import com.i2i.model.User;

@Controller
public class LoginController {
	UserService userService = new UserService();
	
	@RequestMapping("/Login")
	public String loginPage() {
		return "Login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCheck(@RequestParam("username") String username, @RequestParam("password") String password) throws  IOException, ServletException {
    	try {
    		System.out.println("come in logincheck");
    	    User user = userService.searchUser(username);
    	    if (password.equals(user.getPassword()) ) {
                Role role = user.getRole();
                if(role.getRoleName().equals("admin")) {
                    return "index.jsp";
                } else if (role.getRoleName().equals("teacher")) {
                	return "redirect:teacher.jsp";
                } else if (role.getRoleName().equals("student")) {
    	    	      return "redirect:student.jsp";
    	        }
    	    } else {
    	    	return "redirect:index.jsp";
    	    }
    	} catch (DatabaseException e) {
    		return "redirect:index.jsp";
    	}
    	return null;
    }
}
