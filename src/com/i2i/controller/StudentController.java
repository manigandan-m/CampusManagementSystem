package com.i2i.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DatabaseException;
import com.i2i.service.StandardService;
import com.i2i.service.StudentService;
import com.i2i.service.UserService;
import com.i2i.model.Standard;
import com.i2i.model.Student;
import com.i2i.model.User;

/**
 * Controller to perform add, update, delete, retrieve, retrieve all operations using Student
 * by invoking StudentService class methods.
 * It is used to set views (JSP Pages) for the methods.
 * Assigns handlers (methods) to process the requests
 *   
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 * 
 */
@Controller
public class StudentController  {
    StudentService studentService = new StudentService();
    UserService userService = new UserService();
    StandardService standardService = new StandardService();
    
    /**
     * Gets the student details from the JSP Page and passes it as student.
     * It gets the userId and invokes the UserService method to get the corresponding user.
     * It invokes the StudentService method and sends the user and student for adding student details
     *  
     * @param student
     *     person who is a pupil of a school   
     * @return
     */
    @RequestMapping(value = "/addStudent", method=RequestMethod.POST) 
    public ModelAndView addStudent(@ModelAttribute("Student") Student student) {
        String message = null;    
        try {        	
            User user = userService.getUserById(student.getUser().getUserId());
            Standard standard = standardService.getStandardById(student.getStandard().getStandardId());
            studentService.addStudent(student, user, standard);                                        
            message = "Student is added successfully";            
        } catch (DatabaseException ex) {        	
            message = ex.getMessage().toString();                         
        } 
        return new ModelAndView("AddStudent","addMessage", message);       
    }

    /**
     * Used to view the record of the student by passing roll number
     * It invokes the StudemtService class method and gets the Student and passes it to JSP Page
     * 
     * @param studentId
     *     roll number of the student
     * @return
     *     JSP Page where the student details can be viewed
     */
    @RequestMapping(value = "/viewStudent", method=RequestMethod.GET) 
    public ModelAndView viewStudent(@RequestParam("rollNumber") int studentId) {               
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("SearchStudent");
        try {          
            modelView.addObject("searchStudent", studentService.getStudentById(studentId));                 
        } catch (DatabaseException e) {
            modelView.addObject("searchMessage", e.getMessage());            
        }
        return modelView;
    }
    
    /**
     * Used to view the record of the student by passing roll number
     * It invokes the StudemtService class method and gets the Student and passes it to JSP Page
     * 
     * @param studentId
     *     roll number of the student
     * @return
     *     JSP Page where the student details can be viewed
     */
    @RequestMapping(value = "/displayStudent", method=RequestMethod.GET) 
    public ModelAndView displayStudent(@RequestParam("rollNumber") int studentId) {               
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("DisplayStudent");
        try {          
            modelView.addObject("searchStudent", studentService.getStudentById(studentId));                                  
        } catch (DatabaseException e) {
            modelView.addObject("searchMessage", e.getMessage());            
        }
        return modelView;
    }

    /**
     * It displays all the students by invoking the StudentService class method.
     * It sends the list of the students to the JSP Page
     *  
     * @return
     *     returns the JSP Page where all the students are displayed
     */
    @RequestMapping(value = "/displayStudents", method=RequestMethod.GET) 
    public ModelAndView displayStudents() {
    	try {                                                                         
            return new ModelAndView("RetrieveStudents","students", studentService.getStudents());                                           
        } catch (DatabaseException e) {
            return new ModelAndView("RetrieveStudents","displayMessage", e.getMessage());                                
        } 
    }

    /**
     * Deletes the standard record by passing the roll number of the standard
     * 
     * @param standardId
     *     roll number of the standard whose record has to be deleted
     * @return
     *     JSP Page where the user is redirected
     */
    @RequestMapping(value = "/deleteStudent", method=RequestMethod.GET)
    public ModelAndView deleteStudent(@RequestParam("rollNumber") int studentId) {       
        ModelAndView modelView = new ModelAndView();
        try {                                                          
            studentService.removeStudentById(studentId);
        } catch (DatabaseException e) {
            modelView.addObject("deleteMessage", e.getMessage());                                   
        }
        return displayStudents();        
    }
    
    /**
     * Gets the roll number of the student whose details needs to be edited
     * 
     * @param studentId
     *     rollNumber of student
     * @param map
     *     sends the object of Student class whose record has to be edited
     * 
     * @return
     */
    @RequestMapping(value="/editStudentDetails", method=RequestMethod.GET)
    public String editTeacherDetails(@RequestParam("rollNumber") int studentId, ModelMap map) {
    	try {
    	    Student student = studentService.getStudentById(studentId);
    	    map.addAttribute("student",student);
    	} catch (DatabaseException e) {
    	    map.addAttribute("Message",e.getMessage().toString());
    	}
    	return "EditStudentDetails";
    }
    
    /**
     * Edits the details of the student using it's id
     * 
     * @param id
     *     id of student entered by the user
     * @return EditStudent
     *     JSP Page where user can make changes to the various attributes of the student
     * @throws ServletException
     *     when a servlet related problem occurs.
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     */
    @RequestMapping(value = "/editStudentById", method = RequestMethod.POST)
    public String editStudentForm(@RequestParam("rollNumber") int rollNumber, ModelMap model) {
    	 try {
    	     model.addAttribute("Student", studentService.getStudentById(rollNumber));
             return "EditStudent";
    	 } catch (DatabaseException e) {
    	     model.addAttribute("Message", e.getMessage().toString());
    	     return "EditStudent";
    	 }
    }
    
    /**
     * <p>
     * Edits the student details by sending the student model object details to the assigned JSP page.
     * Invokes the StudentService method to update the changes.
     * </p>
     * 
     * @param student
     *     person who is a pupil of a school    
     * @param message
     *     Status message
     * @return EditStudent
     *     JSP Page for editing student details
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     * @throws ServletException
     *     when a servlet related problem occurs.
     */
    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
    public String editStudent(@ModelAttribute("Student") Student student, ModelMap message) {  
        try {
            studentService.editStudent(student);      
            message.addAttribute("Message", "Student Edited Successfully");
            return "EditStudent";
    	} catch (DatabaseException e) {
    	    message.addAttribute("Message", (e.getMessage().toString()));
    	    return "EditStudent";
    	}
    }
}
