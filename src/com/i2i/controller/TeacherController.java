package com.i2i.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Teacher;
import com.i2i.service.TeacherService;

@Controller
public class TeacherController {
	TeacherService teacherService = new TeacherService();
    
	   
    @RequestMapping(value = "/TeacherInformation", method=RequestMethod.GET) 
    public String addTeacherForm(ModelMap model) {
        model.addAttribute("Teacher", new Teacher());	 
        return "TeacherInformation";
    }       
    
   
    @RequestMapping(value = "/addTeacher", method=RequestMethod.POST) 
    public ModelAndView addTeacher(@ModelAttribute("Teacher") Teacher teacher) {
        String message = null;    

        try {                                                     
        	teacherService.addTeacher(teacher);                                        
            message = "Teacher is added successfully";            
        }  catch (DatabaseException ex) {        	
            message = ex.getMessage().toString();                         
        } 
        return new ModelAndView("TeacherInformation","addMessage", message);       
    }

    
    @RequestMapping(value = "/searchTeacher", method=RequestMethod.GET)  
    public ModelAndView searchTeacher(@RequestParam("teacherId") int teacherId) {                
        ModelAndView modelView = new ModelAndView();
        
        modelView.setViewName("TeacherInformation");
        modelView.addObject("Teacher", new Teacher());
        try {       	
        	modelView.addObject("searchTeacher", teacherService.searchTeacher(teacherId));        	                                          
        } catch (DatabaseException e) {
        	
        	modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    }

    
    @RequestMapping(value = "/displayTeachers", method=RequestMethod.GET) 
    public ModelAndView displayTeachers() {
    	
        try {                                                                         
            List<Teacher> teachers = teacherService.getTeachers();

            return new ModelAndView("RetrieveAllTeachers","teachers", teachers);                                           
        } catch (DatabaseException e) {
        	
            return new ModelAndView("RetrieveAllTeachers","displayMessage", e.getMessage());                                                       
        } 
    }

    
    @RequestMapping(value = "/deleteTeacher", method=RequestMethod.GET) 
    public ModelAndView deleteTeacher(@RequestParam("teacherId") int teacherId) {        
        ModelAndView modelView = new ModelAndView();
    	
    	modelView.setViewName("TeacherInformation");
        modelView.addObject("Teacher", new Teacher());          
        try {                                                           
            teacherService.removeTeacher(teacherId);
            modelView.addObject("deleteMessage", "Teacher Id " + teacherId + " is deleted");                                   
        } catch (DatabaseException e) {
        	
        	modelView.addObject("deleteMessage", e.getMessage());                                    
        } 
        return modelView;         
    }
    
   /*@RequestMapping(value = "/displayTeacher", method=RequestMethod.GET) 
    public ModelAndView displayTeacher(@RequestParam("teacherId") int teacherId) { 
                  
        try {  
            return new ModelAndView("Teacher","teacher", teacherService.searchTeacher(teacherId));                                 
        } catch (DatabaseException e) {
            return new ModelAndView("Teacher","message", e.getMessage());  
        }           
    } 
    
    
	@RequestMapping(value = "/loginVerification", method=RequestMethod.POST)
    public ModelAndView loginVerification(@RequestParam("userId") int userId, @RequestParam("password") String password, HttpSession session) {		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:index.html");
		
        try {                           
            Teacher teacher = teacherService.searchTeacher(userId); 
           	             
            if ((teacher.getPassword()).equals(password)) {
                session.setAttribute("user", userId);
                session.setAttribute("role", teacher.getRole());
                
	            if (teacher.getRole().equals("admin")) {
	            	model.setViewName("redirect:index.html");                                  
                } else {
                    model.addObject("teacher", teacher);
                    model.setViewName("Teacher");                                                      
                }
           } else {               
                model.addObject("message", "Either user name or password is wrong");
                model.setViewName("redirect:login.html");                
           } 
        } catch (DatabaseException ex) {
        	model.addObject("message", ex.getMessage().toString());
        	model.setViewName("redirect:login.html");                                  
        }
        return model;
    }
	
	
	@RequestMapping(value = "/login")  
    public String getLoginPage() {
        return "login";                       		
    }
	
	
	@RequestMapping(value = "/index")  
    public String getindexPage() {
        return "index";                       		
    }
	
	
	@RequestMapping(value = "/displayTeacher")  
    public String getTeacherPage() {
        return "Teacher";                       		
    }
	
	
	@RequestMapping(value = "/loginVerification", method=RequestMethod.GET)  
    public ModelAndView getTeacher(HttpSession session) {		
		return new ModelAndView("redirect:displayTeacher.html?teacherId="+(Integer)session.getAttribute("user"));                             		
    }
	
	
	@RequestMapping(value = "/logout")
    public String logout(HttpSession session) {    	
    	
    	if(null != session.getAttribute("user")) {
    	    session.invalidate();
    	}    	
    	return "login";
    } */
}