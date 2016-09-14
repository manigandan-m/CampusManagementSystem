package com.i2i.controller;

import java.io.IOException;

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
import com.i2i.model.User;
import com.i2i.service.TeacherService;
import com.i2i.service.UserService;

/**
 * Controller to perform add, update, delete, retrieve, retrieve all operations using model class Teacher
 * by invoking TeacherService class methods.
 * It is used to set views (JSP Pages) for the methods.
 * Assigns handlers (methods) to process the requests
 *   
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 * 
 */
@Controller
public class TeacherController {
	TeacherService teacherService = new TeacherService();
	UserService userService = new UserService();
    
	/**
     * Sends the object of Teacher class to the JSP Page where details of the teacher can be entered
     * @param model
     *     passes the object of Teacher class by using the addAttribute
     * @return
     */   
    @RequestMapping(value = "/addTeacher", method=RequestMethod.GET) 
    public String addTeacherForm(ModelMap model) {
        model.addAttribute("Teacher", new Teacher());	 
        return "AddTeacher";
    }       
    
    /**
     * Gets the teacher details from the JSP Page and passes it as an object of Teacher class.
     * It gets the userId and invokes the UserService method to get the corresponding user object.
     * It invokes the TeacherService method and sends the user and teacher object for adding teacher details
     *  
     * @param teacher
     *     object of Teacher class
     * @return
     */
    @RequestMapping(value = "/addTeacher", method=RequestMethod.POST)
    public ModelAndView addTeacher(@ModelAttribute("Teacher") Teacher teacher) {
        String message = null;    
        try {      
            User user = userService.getUserById(teacher.getUser().getUserId());          
            teacherService.addTeacher(teacher, user);                                       
            message = "Teacher is added successfully";            
        } catch (DatabaseException ex) {            
            message = ex.getMessage().toString();                         
        }
        return new ModelAndView("AddTeacher","addMessage", message);       
    }

    
    /**
     * Used to view the record of the teacher by passing roll number
     * It invokes the StudemtService class method and gets the object of Teacher class and passes it to JSP Page
     * 
     * @param teacherId
     *     roll number of the teacher
     * @return
     *     JSP Page where the teacher details can be viewed
     */
    @RequestMapping(value = "/viewTeacher", method=RequestMethod.GET) 
    public ModelAndView viewTeacher(@RequestParam("teacherId") int teacherId) {               
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("SearchTeacher");
        try {          
            modelView.addObject("searchTeacher", teacherService.getTeacherById(teacherId));                                                     
        } catch (DatabaseException e) {
            modelView.addObject("searchMessage", e.getMessage());            
        }
        return modelView;
    }   
    
    /**
     * It displays all the teachers by invoking the TeacherService class method.
     * It sends the list of the teachers to the JSP Page by using ModelAndView object
     *  
     * @return
     *     returns the JSP Page where all the teachers are displayed
     */
    @RequestMapping(value = "/displayTeachers", method=RequestMethod.GET) 
    public ModelAndView displayTeachers() {
    	
        try {                                                                         
            return new ModelAndView("RetrieveTeachers","teachers", teacherService.getTeachers());                                           
        } catch (DatabaseException e) {
        	return new ModelAndView("RetrieveTeachers","displayMessage", e.getMessage());                                                       
        } 
    }
    
    /**
     * Deletes the teacher record by passing the roll number of the teacher
     * 
     * @param teacherId
     *     roll number of the teacher whose record has to be deleted
     * @return
     *     JSP Page where the user is redirected
     */
    @RequestMapping(value = "/deleteTeacher", method=RequestMethod.GET) 
    public ModelAndView deleteTeacher(@RequestParam("teacherId") int teacherId) {       
        ModelAndView modelView = new ModelAndView();
        try {                                                          
            teacherService.removeTeacherById(teacherId);
        } catch (DatabaseException e) {
            modelView.addObject("deleteMessage", e.getMessage());                                   
        }
        return displayTeachers();        
    }
    
    /**
     * Gets the teacherId of the teacher whose details needs to be edited
     * 
     * @param teacherId
     *     id of teacher
     * @param map
     *    sends the object of Teacher class whose record has to be edited
     * @return
     */
    @RequestMapping(value="/editTeacherDetails", method=RequestMethod.GET)
    public String editTeacherDetails(@RequestParam("teacherId") int teacherId, ModelMap map) {
    	try {
    		Teacher teacher = teacherService.getTeacherById(teacherId);
    		map.addAttribute("teacher",teacher);
    	} catch(DatabaseException e) {
    		map.addAttribute("Message",e.getMessage().toString());
    	}
    	return "EditTeacherDetails";
    }
    
    /**
     * Edits the details of the teacher using it's id
     * 
     * @param id
     *     id of teacher entered by the user
     * @param model
     *     ModelMap object to send the teacher object to the JSP page
     * @return EditTeacher
     *     JSP Page where user can make changes to the various attributes of the teacher
     * @throws ServletException
     *     when a servlet related problem occurs.
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     */
    @RequestMapping(value = "/editTeacherById", method = RequestMethod.GET)
    public String editTeacherForm(@RequestParam("teacherId") String id, ModelMap model) throws ServletException, IOException {
    	 try {
    		 model.addAttribute("Teacher", teacherService.getTeacherById(Integer.parseInt(id)));
             return "EditTeacher";
    	 } catch (DatabaseException e) {
    		 model.addAttribute("Message", e.getMessage().toString());
    		 return "EditTeacher";
    	 }
    }
    
    /**
     * <p>
     * Edits the teacher details by sending the teacher model object details to the assigned JSP page.
     * Invokes the TeacherService method to update the changes.
     * </p>
     * 
     * @param teacher
     *     Object of Teacher class    
     * @param message
     *     Status message
     * @return EditTeacher
     *     JSP Page for editing teacher details
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     * @throws ServletException
     *     when a servlet related problem occurs.
     */
    @RequestMapping(value = "/editTeacher", method = RequestMethod.POST)
    public String editTeacher(@ModelAttribute("Teacher") Teacher teacher, ModelMap message) {  
        try {
        	teacherService.editTeacher(teacher);      
            message.addAttribute("Message", "Teacher Edited Successfully");
            return "EditTeacher";
    	} catch (DatabaseException e) {
    		message.addAttribute("Message", (e.getMessage().toString()));
    		return "EditTeacher";
    	}
    }
}