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
import com.i2i.model.Student;
import com.i2i.model.Teacher;
import com.i2i.model.Standard;
import com.i2i.service.StudentService;
import com.i2i.service.AddressService;
import com.i2i.service.RoleService;
import com.i2i.service.StandardService;

@Controller
public class UserController {
	StudentService studentService = new StudentService();
	StandardService standardService = new StandardService();
    UserService userService = new UserService();
    RoleService roleService = new RoleService();
    AddressService addressService = new AddressService();
    //int userId;
    
    
    @RequestMapping(value = "/User", method=RequestMethod.GET) 
    public String addUser(ModelMap model) {
    	
    	try { 
        model.addAttribute("User", new User());	
        model.addAttribute("roleList", roleService.getRoles());
    	}  catch (DatabaseException ex) { 
        	
        	model.addAttribute("message", ex.getMessage().toString());                                    
        } 
         
        return "User";
    }       
    
   
    @RequestMapping(value = "/addUser", method=RequestMethod.POST) 
    public ModelAndView addUser(@ModelAttribute("User") User user) {      
        ModelAndView modelView = new ModelAndView();        
        
        try {                                                     
        	int userId = userService.addUser(user);
        	       	
        	modelView.addObject("Address", new Address());
        	modelView.addObject("userId", userId);        	
            modelView.setViewName("Address");         
        }  catch (DatabaseException ex) { 
        	modelView.setViewName("User");
        	modelView.addObject("message", ex.getMessage().toString());                                    
        } 
        return modelView;       
    }    
    
    @RequestMapping(value = "/addAddress", method=RequestMethod.POST) 
    public ModelAndView addUser(@ModelAttribute("Address") Address address) {           
        ModelAndView modelView = new ModelAndView();
        
        try {        	
           int userId = address.getUser().getUserId();
            User user = userService.searchUser(userId);
            //String roleName = ;
            //System.out.println(roleName);
            addressService.addAddress(address);
            //modelView.addObject("Student", new Student());
            //modelView.setViewName("StudentInformation");
            if(user.getRole().getRoleName().equals("student")) { 
                modelView.setViewName("StudentInformation");
                modelView.addObject("Student", new Student());
                
            } else if (user.getRole().getRoleName().equals("teacher")){
            	modelView.setViewName("TeacherInformation");
            	modelView.addObject("Teacher", new Teacher());
                
            }
        	
            
        }  catch (DatabaseException ex) {
        	
        	modelView.setViewName("Address");
            modelView.addObject("message", ex.getMessage().toString());                                    
        } 
        return modelView;       
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
    
    @RequestMapping(value = "/addStudent", method=RequestMethod.POST) 
    public ModelAndView addStudent(@ModelAttribute("Student") Student student) {
        String message = null;    

        try {  
        	
            studentService.addStudent(student);                                        
            message = "Student is added successfully";            
        }  catch (DatabaseException ex) {        	
            message = ex.getMessage().toString();                         
        } 
        return new ModelAndView("StudentInformation","addMessage", message);       
    }

    @RequestMapping(value = "/Standard", method=RequestMethod.GET) 
    public String addStandard(ModelMap model) {
        model.addAttribute("Standard", new Standard());	 
        return "Standard";
    }   
    
    @RequestMapping(value = "/addStandard", method=RequestMethod.POST) 
    public ModelAndView addStandard(@ModelAttribute("Standard") Standard standard) {
        String message = null;  

        try {  
        	
            standardService.addStandard(standard);                                        
            message = "Standard is added successfully";            
        }  catch (DatabaseException ex) {        	
            message = ex.getMessage().toString();                         
        } 
        return new ModelAndView("Standard","addMessage", message);       
    }

    
    public ModelAndView displayStandards() {
    	
        try {                                                                         
            List<Standard> standards = standardService.getStandards();

            return new ModelAndView("DisplayStandards","standards", standards);                                           
        } catch (DatabaseException e) {
        	
            return new ModelAndView("DisplayStandards","displayMessage", e.getMessage());                                                       
        } 
    }

    
    @RequestMapping(value = "/deleteStandard", method=RequestMethod.GET) 
    public ModelAndView deleteStandard(@RequestParam("standardId") int standardId) {        
        ModelAndView modelView = new ModelAndView();
    	
    	modelView.setViewName("Standard");
        modelView.addObject("Standard", new Standard());          
        try {                                                           
            standardService.removeStandard(standardId);
            modelView.addObject("deleteMessage", "Standard Id " + standardId + " is deleted");                                   
        } catch (DatabaseException e) {
        	
        	modelView.addObject("deleteMessage", e.getMessage());                                    
        } 
        return modelView;         
    }
    
    @RequestMapping(value = "/searchStandard", method=RequestMethod.GET)  
    public ModelAndView searchStandard(@RequestParam("standardId") int standardId) {                
        ModelAndView modelView = new ModelAndView();
        
        modelView.setViewName("Standard");
        modelView.addObject("Standard", new Standard());
        try {       	
        	modelView.addObject("searchStandard", standardService.searchStandard(standardId));        	                                          
        } catch (DatabaseException e) {
        	
        	modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    }   
    

    
   

}