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
import com.i2i.service.StudentService;
import com.i2i.model.Student;


@Controller
public class StudentController  {
    StudentService studentService = new StudentService();
    
   
    @RequestMapping(value = "/StudentInformation", method=RequestMethod.GET) 
    public String addStudent(ModelMap model) {
        model.addAttribute("Student", new Student());	 
        return "StudentInformation";
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
        return new ModelAndView("StudentOperations","addMessage", message);       
    }

    
    @RequestMapping(value = "/searchStudent", method=RequestMethod.GET)  
    public ModelAndView searchStudent(@RequestParam("studentId") int studentId) {                
        ModelAndView modelView = new ModelAndView();
        
        modelView.setViewName("StudentOperations");
        modelView.addObject("Student", new Student());
        try {       	
        	modelView.addObject("searchStudent", studentService.searchStudent(studentId));        	                                          
        } catch (DatabaseException e) {
        	
        	modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    }

    
    @RequestMapping(value = "/displayStudents", method=RequestMethod.GET) 
    public ModelAndView displayStudents() {
    	
        try {                                                                         
            List<Student> students = studentService.getStudents();

            return new ModelAndView("DisplayStudents","students", students);                                           
        } catch (DatabaseException e) {
        	
            return new ModelAndView("DisplayStudents","displayMessage", e.getMessage());                                                       
        } 
    }

    
    @RequestMapping(value = "/deleteStudent", method=RequestMethod.GET) 
    public ModelAndView deleteStudent(@RequestParam("studentId") int studentId) {        
        ModelAndView modelView = new ModelAndView();
    	
    	modelView.setViewName("StudentOperations");
        modelView.addObject("Student", new Student());          
        try {                                                           
            studentService.removeStudent(studentId);
            modelView.addObject("deleteMessage", "Student Id " + studentId + " is deleted");                                   
        } catch (DatabaseException e) {
        	
        	modelView.addObject("deleteMessage", e.getMessage());                                    
        } 
        return modelView;         
    }
    
    
    /*@RequestMapping(value = "/displayStudent", method=RequestMethod.GET) 
    public ModelAndView displayStudent(@RequestParam("studentId") int studentId) { 
                  
        try {  
            return new ModelAndView("Student","student", studentService.searchStudent(studentId));                                 
        } catch (DatabaseException e) {
            return new ModelAndView("Student","message", e.getMessage());  
        }           
    } 
    
    
	@RequestMapping(value = "/loginVerification", method=RequestMethod.POST)
    public ModelAndView loginVerification(@RequestParam("userId") int userId, @RequestParam("password") String password, HttpSession session) {		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:index.html");
		
        try {                           
            Student student = studentService.searchStudent(userId); 
           	             
            if ((student.getPassword()).equals(password)) {
                session.setAttribute("user", userId);
                session.setAttribute("role", student.getRole());
                
	            if (student.getRole().equals("admin")) {
	            	model.setViewName("redirect:index.html");                                  
                } else {
                    model.addObject("student", student);
                    model.setViewName("Student");                                                      
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
	
	
	@RequestMapping(value = "/displayStudent")  
    public String getStudentPage() {
        return "Student";                       		
    }
	
	
	@RequestMapping(value = "/loginVerification", method=RequestMethod.GET)  
    public ModelAndView getStudent(HttpSession session) {		
		return new ModelAndView("redirect:displayStudent.html?studentId="+(Integer)session.getAttribute("user"));                             		
    }
	
	
	@RequestMapping(value = "/logout")
    public String logout(HttpSession session) {    	
    	
    	if(null != session.getAttribute("user")) {
    	    session.invalidate();
    	}    	
    	return "login";
    } */ 	
}
