package com.i2i.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DatabaseException;
import com.i2i.service.UserService;
import com.i2i.model.User;
import com.i2i.model.Address;
import com.i2i.service.AddressService;
import com.i2i.service.RoleService;

/**
 * Controller to perform add, update, delete, retrieve, retrieve all operations using model class User
 * by invoking UserService class methods.
 * It is used to set views (JSP Pages) for the methods.
 * Assigns handlers (methods) to process the requests
 *   
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 * 
 */

@Controller
public class UserController {
	UserService userService = new UserService();
    RoleService roleService = new RoleService();
    AddressService addressService = new AddressService();
    
    /**
     * This returns a JSP Page where user can add it's details. It passes a User to the JSP Page
     * 
     * @return User
     *     JSP Page where user can add the user details
     */
    @RequestMapping(value = "/User", method=RequestMethod.GET) 
    public String addUser(ModelMap model) {
    	try { 
            model.addAttribute("User", new User());	
            model.addAttribute("roleList", roleService.getRoles());
    	} catch (DatabaseException ex) { 
            model.addAttribute("message", ex.getMessage().toString());                                    
        } 
        return "User";
    }       
    
    /**
     * The method gets the user details from the JSP Page and invokes the 
     * UserService class method and sends the details as an object of model class User
     * 
     * @param user
     *     user is a person who can be an admin, teacher or a student. It contains all the user details that is sent from the JSP Page
     * @return
     *     returns the JSP Page called Address
     */
    @RequestMapping(value = "/addUser", method=RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("User") User user) {      
        ModelAndView modelView = new ModelAndView();        
        try {                                                     
            modelView.addObject("Address", new Address());
            modelView.addObject("userId", userService.addUser(user));           
            modelView.setViewName("Address");         
        }  catch (DatabaseException ex) {
            modelView.setViewName("User");
            modelView.addObject("message", ex.getMessage().toString());                                   
        }
        return modelView;       
    }    
    
    /**
     * User details of a user can be viewed by passing the username of the user as a parameter
     * 
     * @param username
     *     username of the user whose user details has to be viewed
     * @return
     *     returns the JSP Page where user details of a single user can be viewed 
     */
    @RequestMapping(value = "/searchUser", method=RequestMethod.GET)  
    public ModelAndView viewUser(@RequestParam("username") String username) {                
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("User");
        modelView.addObject("User", new User());
        try {       	
            modelView.addObject("searchUser", userService.getUserByUsername(username));        	                                          
        } catch (DatabaseException e) {
            modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    } 
    
    /**
     * User details of a user can be viewed by passing the id of the user as a parameter
     * 
     * @param userId
     *     id of the user whose user details has to be viewed
     * @return
     *     returns the JSP Page where user details of a single user can be viewed 
     */
    @RequestMapping(value = "/searchUserById", method=RequestMethod.GET)  
    public ModelAndView viewUserById(@RequestParam("userId") int userId) {                
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("User");
        modelView.addObject("User", new User());
        try {       	
            modelView.addObject("searchUser", userService.getUserById(userId));        	                                          
        } catch (DatabaseException e) {
            modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    } 
    
    /**
     * Edits the details of the user using it's id
     * 
     * @param id
     *     id of user entered by the user
     * @return EditUser
     *     JSP Page where user can make changes to the various attributes of the user
     * 
     */
    @RequestMapping(value = "/editUserById", method = RequestMethod.GET)
    public String editUserForm(@RequestParam("userId") int id, ModelMap model) {
    	 try {
    	     model.addAttribute("User", userService.getUserById(id));
    		 model.addAttribute("roleList", roleService.getRoles());
             return "EditUser";
    	 } catch (DatabaseException e) {
    	     model.addAttribute("Message", e.getMessage().toString());
    		 return "EditUser";
    	 }
    }
    
    /**
     * <p>
     * Edits the user details by sending the user to the assigned JSP page.
     * Invokes the UserService method to update the changes.
     * </p>
     * 
     * @param user
     *     user is a person who can be an admin, teacher or a student. It contains all the user details that is sent from the JSP Page
     * @param message
     *     Status message
     * @return EditUser
     *     JSP Page for editing user details
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     * @throws ServletException
     *     when a servlet related problem occurs.
     */
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("User") User user, ModelMap message){  
        try {
        	userService.editUser(user);      
            message.addAttribute("Message", "User Edited Successfully");
            return "EditUser";
    	} catch (DatabaseException e) {
    	    message.addAttribute("Message", (e.getMessage().toString()));
    		return "EditUser";
    	}
    }
    
    /**
     * It invokes the UserService method to get all the users in the User class.
     * 
     * @return
     *     returns the list of users and sends to the JSP Page where they can be viewed
     */
    @RequestMapping(value = "/displayUsers", method=RequestMethod.GET) 
    public ModelAndView displayUsers() {
    	try {                                                                         
            return new ModelAndView("DisplayUsers","users", userService.getUsers());                                           
        } catch (DatabaseException e) {
            return new ModelAndView("DisplayUsers","displayMessage", e.getMessage());                                                       
        } 
    }
}