package com.i2i.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DatabaseException;
import com.i2i.service.StandardService;
import com.i2i.service.SubjectService;
import com.i2i.service.TeacherService;
import com.i2i.model.Subject;

/**
 * Controller to perform add, update, delete, retrieve, retrieve all operations using model class Subject by 
 * invoking SubjectService class methods.
 * It is used to set views (JSP Pages) for the methods.
 * Assigns handlers (methods) to process the requests
 *   
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 * 
 */
@Controller
public class SubjectController {
	SubjectService subjectService = new SubjectService();
	TeacherService teacherService = new TeacherService();
	StandardService standardService = new StandardService();
    
	/**
	 * It is used to send the object of class Subject and the lists of the standards and teachers to a JSP Page where
	 * user can add the details of the subject  
	 * @param model
	 *     used to send the subject model object and the lists of standards and teachers
	 * @return
	 *     JSP Page where user can add the subject details
	 */
    @RequestMapping(value = "/Subject", method=RequestMethod.GET) 
    public String Subjects(ModelMap model) {
    	try {
        model.addAttribute("subjects", subjectService.getSubjects());        
        } catch (DatabaseException e) {
        }
        return "RetrieveSubjects";
    }       
    
    /**
     * The method gets the subject details from the JSP Page and invokes the 
     * SubjectService class method and sends the details as an object of model class Subject
     * 
     * @param subject
     *     object of class Subject. It contains all the user details that is sent from the JSP Page
     * @return
     *     returns the JSP Page called SubjectInformation
     */
    @RequestMapping(value = "/addSubject", method=RequestMethod.POST) 
    public ModelAndView addSubject(@ModelAttribute("Subject") Subject subject) {
        String message = null;    
        try {                                                     
        	subjectService.addSubject(subject);                                        
            message = "Subject is added successfully";            
        }  catch (DatabaseException ex) {        	
            message = ex.getMessage().toString(); 
        } 
        return new ModelAndView("RetrieveSubjects","displayMessage", message);       
    }

    /**
     * Used to find the details of a subject by getting the subject code. It passes
     *  an object of class Subject to the JSP Page where the subject details can be viewed
     *   
     * @param subjectCode
     *     code of the subject
     * @return
     *     JSP Page where subject details can be viewed
     */
    @RequestMapping(value = "/searchSubject", method=RequestMethod.GET)  
    public ModelAndView viewSubject(@RequestParam("subjectCode") String subjectCode) {                
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("SubjectInformation");
        modelView.addObject("Subject", new Subject());
        try {       	
        	modelView.addObject("searchSubject", subjectService.getSubjectBySubjectCode(subjectCode));        	                                          
        } catch (DatabaseException e) {
        	modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    }

    /**
     * Deletes the subject record by passing the code of the subject
     * 
     * @param subjectCode
     *     code of the subject whose record has to be deleted
     * @return
     *     JSP Page where the user is redirected
     */
    @RequestMapping(value = "/deleteSubject", method=RequestMethod.GET) 
    public ModelAndView deleteStudent(@RequestParam("subjectCode") String subjectCode) {        
        ModelAndView modelView = new ModelAndView();
    	modelView.setViewName("SubjectInformation");
        modelView.addObject("Subject", new Subject());          
        try {                                                           
        	subjectService.removeSubjectBySubjectCode(subjectCode);
            modelView.addObject("deleteMessage", "Student Id " + subjectCode + " is deleted");                                   
        } catch (DatabaseException e) {
        	modelView.addObject("deleteMessage", e.getMessage());                                    
        } 
        return modelView;         
    }
    
    @RequestMapping(value = "/assignTeacher", method=RequestMethod.GET) 
    public ModelAndView assignTeacherToSubjectForm(@RequestParam("subjectId") String subjectId) {        
        ModelAndView modelView = new ModelAndView();    	  	
        modelView.setViewName("AllocateTeacher"); 
        try {  
        	modelView.addObject("teachers", teacherService.getTeachers());
        	modelView.addObject("Subject", subjectService.getSubjectBySubjectCode(subjectId));            	     	                                          
        } catch (DatabaseException e) {        	
           	modelView.addObject("message", e.getMessage());             
        }
        return modelView;         
    }    
    
    @RequestMapping(value = "/allocateTeacher", method=RequestMethod.POST) 
    public ModelAndView assignTeacherToSubject(@ModelAttribute("Subject") Subject subject) {        
        ModelAndView modelView = new ModelAndView();    	  	
        modelView.setViewName("AllocateTeacher"); 
        try {  
            subjectService.allotTeacher(subject);      	                                          
        } catch (DatabaseException e) {        	
           	modelView.addObject("message", e.getMessage());             
        }                                             
        return modelView;         
    }  
    
    /**
     * Edits the details of the employee using it's subjectCode
     * 
     * @param subjectCode
     *     code of the subject whose record should be edited
     * @param model
     *     ModelMap object to send the subject object to the JSP page
     * @return EditSubject
     *     JSP Page where user can make changes to the various attributes of the subject
     * @throws ServletException
     *     when a servlet related problem occurs.
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     */
    /*@RequestMapping(value = "/editSubjectBySubjectCode", method = RequestMethod.POST)
    public String editSubjectForm(@RequestParam("subjectCode") String subjectCode, ModelMap model) throws ServletException, IOException {
    	 try {
    		 //checks if the employee id is number
    		 if (!isNumber(subjectCode)) {
    			 model.addAttribute("Message", "ID must be a number");
    			 return "editSubjectBySubjectCode";
    		 }
             model.addAttribute("Subject", subjectService.getSubjectBySubjectCode(Integer.parseInt(subjectCode)));
             return "EditSubject";
    	 } catch (DatabaseException e) {
    		 model.addAttribute("Message", e.getMessage().toString());
    		 return "EditSubject";
    	 }
    }
    
    /**
     * <p>
     * Edits the subject details by sending the subject model object details to the assigned JSP page.
     * Invokes the SubjectService method to update the changes.
     * </p>
     * 
     * @param subject
     *     Object of Subject class    
     * @param message
     *     Status message
     * @return EditSubject
     *     JSP Page for editing subject details
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     * @throws ServletException
     *     when a servlet related problem occurs.
     */
    /*@RequestMapping(value = "/editSubject", method = RequestMethod.POST)
    public String editSubject(@ModelAttribute("Subject") Subject subject, ModelMap message
                            ) throws IOException, ServletException {  
        try {
        	subjectService.editSubject(subject);      
            message.addAttribute("Message", "Subject Edited Successfully");
            return "EditSubject";
    	} catch (DatabaseException e) {
    		  message.addAttribute("Message", (e.getMessage().toString()));
    		  return "EditSubject";
    	}
    }*/
}
