package com.i2i.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DatabaseException;
import com.i2i.service.UserService;
import com.i2i.model.Role;
import com.i2i.model.User;

/**
 * <p>
 * Used to check the login credentials of the user when a user attempts to login. It checks if the username and password exists.
 * If it exists it creates a session object. Depending on the role it redirects the user to the corresponding JSP Page.
 * When a user logs out it invalidates the session
 * </p>
 * 
 * @author Zeeshan
 * 
 * @created 2015-08-27
 */
@Controller
public class LoginController {
	UserService userService = new UserService();
	
	/**
	 * Returns the login page where user can enter it's login credentials to login as admin 
	 * @return
	 */
	@RequestMapping("/Login")
	public String loginAdminPage() {
		return "Login";
	}
	
	/**
	 * Returns the login page where user can enter it's login credentials to login as teacher 
	 * @return
	 */
	@RequestMapping("/TeacherLogin")
	public String loginTeacherPage() {
		return "TeacherLogin";
	}
	
	/**
	 * Returns the login page where user can enter it's login credentials to login as student
	 * @return
	 */
	@RequestMapping("/StudentLogin")
	public String loginStudentPage() {
		return "StudentLogin";
	}
	
	/**
	 * Checks if the user logging in exists and redirects it to another page based on it's role
	 * 
	 * @param username
	 *     username of the user
	 * @param password
	 *     password of the user
	 * @param session
	 *     HttpSession
	 * @return
	 *     returns home JSP page if the user is an admin
	 *     returns the teacher JSP page if the user is a teacher
	 *     returns the student JSP page if the user is a student
	 * @throws IOException
	 *     if there is failed or interrupted input output operations.
	 * @throws ServletException
	 *     when a servlet related problem occurs.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCheck(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, ModelMap map) throws  IOException, ServletException {
    	try {
    		User user = userService.getUserByUsername(username);
    	    if (password.equals(user.getPassword()) ) {
                Role role = user.getRole();
                if(role.getRoleName().equals("admin")) {
                	session.setAttribute("username", username);
                	session.setAttribute("role",role.getRoleName());
                	return "home";
                } else {
                	map.addAttribute("message","Are you sure you're an admin?");
				}
    	    } else {
    	    	map.addAttribute("message","Invalid username or password");
			}
    	} catch (DatabaseException e) {
    		map.addAttribute("message",e.getMessage().toString());
    	}
    	return "Login";
    }
	
	/**
	 * Checks if the user logging in exists and redirects it to another page based on it's role
	 * 
	 * @param username
	 *     username of the user
	 * @param password
	 *     password of the user
	 * @param session
	 *     HttpSession
	 * @return
	 *     returns the teacher JSP page if the user is a teacher
	 * @throws IOException
	 *     if there is failed or interrupted input output operations.
	 * @throws ServletException
	 *     when a servlet related problem occurs.
	 */
	@RequestMapping(value = "/teacherlogin", method = RequestMethod.POST)
	public String teacherLoginCheck(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, ModelMap map) throws  IOException, ServletException {
		try {
			User user = userService.getUserByUsername(username);
    	    if (password.equals(user.getPassword()) ) {
                Role role = user.getRole();
		        if (role.getRoleName().equals("teacher")) {
            	    session.setAttribute("username", username);
            	    session.setAttribute("role",role.getRoleName());
            	    return "redirect:displayTeacher.html?teacherId="+user.getTeacher().getTeacherId();
		        } else {
		        	map.addAttribute("message","Are you sure you're teacher?");
				}
    	    }  else {
    	    	map.addAttribute("message", "Invalid username or password" );
    	    }
		} catch (DatabaseException e) {
			map.addAttribute("message", e.getMessage().toString());
		}
		return "TeacherLogin";
	}

	/**
	 * Redirects to teacher home page
	 * 
	 * @param username
	 *     username of the user
	 * @return
	 *     returns the teacher JSP page 
	 * @throws IOException
	 *     if there is failed or interrupted input output operations.
	 * @throws ServletException
	 *     when a servlet related problem occurs.
	 */
	@RequestMapping(value = "/teacherlogin", method = RequestMethod.GET)
	public String teacherLoginCheck(@RequestParam("username") String username, ModelMap map) throws  IOException, ServletException {
		try {
		    User user = userService.getUserByUsername(username);
    	            return "redirect:displayTeacher.html?teacherId="+user.getTeacher().getTeacherId();		        
		} catch (DatabaseException e) {
		    map.addAttribute("message", e.getMessage().toString());
		}
		return "DisplayTeacher";
	}
	
	/**
	 * Checks if the user logging in exists and redirects it to another page based on it's role
	 * 
	 * @param username
	 *     username of the user
	 * @param password
	 *     password of the user
	 * @param session
	 *     HttpSession
	 * @return
	 *     returns the student JSP page if the user is a student
	 * @throws IOException
	 *     if there is failed or interrupted input output operations.
	 * @throws ServletException
	 *     when a servlet related problem occurs.
	 */
	@RequestMapping(value = "/studentlogin", method = RequestMethod.POST)
	public String studentLoginCheck(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, ModelMap map) throws  IOException, ServletException {
		try {
			User user = userService.getUserByUsername(username);
    	    if (password.equals(user.getPassword()) ) {
                Role role = user.getRole();
		        if (role.getRoleName().equals("student")) {
            	    session.setAttribute("username", username);
            	    session.setAttribute("role",role.getRoleName());
            	    return "redirect:displayStudent?rollNumber="+user.getStudent().getRollNumber();
		        } else {
		        	map.addAttribute("message","Are you sure you're a student?");
				}
    	    } else {
    	    	map.addAttribute("message", "Invalid username or password" );
    	    }
		} catch (DatabaseException e) {
			map.addAttribute("message", e.getMessage().toString());
		}
		return "StudentLogin";
	}
	
	/**
	 * Redirects to student home page
	 * 
	 * @param username
	 *     username of the user 
	
	 * @return
	 *     returns the student JSP page 
	 * @throws IOException
	 *     if there is failed or interrupted input output operations.
	 * @throws ServletException
	 *     when a servlet related problem occurs.
	 */
	@RequestMapping(value = "/studentlogin", method = RequestMethod.GET)
	public String studentLoginCheck(@RequestParam("username") String username, ModelMap map) throws  IOException, ServletException {
		try {
		    User user = userService.getUserByUsername(username);
    	    	    return "redirect:displayStudent?rollNumber="+user.getStudent().getRollNumber();		    
		} catch (DatabaseException e) {
		    map.addAttribute("message", e.getMessage().toString());
		}
		return "DisplayStudent";
	}
	
	/**
	 * Returns to the home JSP Page
	 * @return
	 */
	@RequestMapping("/home")
	String homePage() {
		return "home";
	}
	
	/**
     * <p>
     * Invalidates the session object.
     * Sets the session attribute to null and removes it.
     * </p>
     * 
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
