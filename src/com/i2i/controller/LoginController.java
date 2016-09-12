package com.i2i.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

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
    public String loginCheck(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) throws  IOException, ServletException {
    	try {
    		User user = userService.getUserByUsername(username);
    	    if (password.equals(user.getPassword()) ) {
                Role role = user.getRole();
                if(role.getRoleName().equals("admin")) {
                	session.setAttribute("username", username);
                	session.setAttribute("role",role);
                	System.out.println("admin");
                    return "home";
                } else if (role.getRoleName().equals("teacher")) {
                	session.setAttribute("username", username);
                	session.setAttribute("role",role);
                	return "redirect:viewTeacher?teacherId="+user.getTeacher().getTeacherId();
                } else if (role.getRoleName().equals("student")) {
                	session.setAttribute("username", username);
                	session.setAttribute("role",role);
                	return "redirect:viewStudent?rollNUmber="+user.getStudent().getRollNumber();
    	        }
    	    }
    	} catch (DatabaseException e) {
    		e.printStackTrace();
    		return "redirect:index.jsp";
    	}
    	return null;
    }
	
	@RequestMapping("/home")
	String homePage() {
		return "redirect:home.jsp";
	}
	
	/**
     * <p>
     * Invalidates the session object.
     * Sets the session attribute to null and removes it.
     * </p>
     * 
     * @param session
     *     HttpSession interface reference
     * @return Login
     *     JSP Page for login 
     */
    @RequestMapping("/Logout")
    public String logout(HttpSession session) {
    	session.setAttribute("username", null);
	    session.removeAttribute("username");
	    return "redirect:index.jsp";
    }
}
