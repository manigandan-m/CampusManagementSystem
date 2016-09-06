package com.i2i.controller;

import java.util.List;
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

@Controller
public class UserController {
    UserService userService = new UserService();
    
    
    @RequestMapping(value = "/User", method=RequestMethod.GET) 
    public String addUser(ModelMap model) {
        model.addAttribute("User", new User());	 
        return "User";
    }       
    
   
    @RequestMapping(value = "/addUser", method=RequestMethod.POST) 
    public ModelAndView addUser(@ModelAttribute("User") User user) {
        String message = null;    

        try {                                                     
            userService.addUser(user);                                        
            message = "User is added successfully";            
        }  catch (DatabaseException ex) {        	
            message = ex.getMessage().toString();                         
        } 
        return new ModelAndView("Address","addMessage", message);       
    }
    
    @RequestMapping(value = "/Address", method=RequestMethod.GET) 
    public String addAddress(ModelMap model) {
        model.addAttribute("User", new User());	 
        return "Address";
    }   
    @RequestMapping(value = "/addAddress", method=RequestMethod.POST) 
    public ModelAndView addUser(@ModelAttribute("Address") Address address) {
        String message = null;    

        try {                                                     
            userService.addAddress(address);                                        
            message = "Address is added successfully";            
        }  catch (DatabaseException ex) {        	
            message = ex.getMessage().toString();                         
        } 
        return new ModelAndView("User","addMessage", message);       
    }

    
    @RequestMapping(value = "/searchUser", method=RequestMethod.GET)  
    public ModelAndView searchUser(@RequestParam("username") String username) {                
        ModelAndView modelView = new ModelAndView();
        
        modelView.setViewName("User");
        modelView.addObject("User", new User());
        try {       	
        	modelView.addObject("searchUser", userService.searchUser(username));        	                                          
        } catch (DatabaseException e) {
        	
        	modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    }

    
    @RequestMapping(value = "/displayUsers", method=RequestMethod.GET) 
    public ModelAndView displayUsers() {
    	
        try {                                                                         
            List<User> users = userService.getUsers();

            return new ModelAndView("DisplayUsers","users", users);                                           
        } catch (DatabaseException e) {
        	
            return new ModelAndView("DisplayUsers","displayMessage", e.getMessage());                                                       
        } 
    }

    
    @RequestMapping(value = "/deleteUser", method=RequestMethod.GET) 
    public ModelAndView deleteUser(@RequestParam("username") String username) {        
        ModelAndView modelView = new ModelAndView();
    	
    	modelView.setViewName("User");
        modelView.addObject("User", new User());          
        try {                                                           
            userService.removeUser(username);
            modelView.addObject("deleteMessage", "User Id " + username + " is deleted");                                   
        } catch (DatabaseException e) {
        	
        	modelView.addObject("deleteMessage", e.getMessage());                                    
        } 
        return modelView;         
    }

}
