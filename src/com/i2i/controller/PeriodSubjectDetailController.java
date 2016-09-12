package com.i2i.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DatabaseException;
import com.i2i.service.PeriodService;
import com.i2i.service.PeriodSubjectDetailService;
import com.i2i.service.StandardService;
import com.i2i.service.SubjectService;
import com.i2i.service.TeacherService;
import com.i2i.model.PeriodSubjectDetail;
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
public class PeriodSubjectDetailController {
	PeriodSubjectDetailService periodSubjectDetailService = new PeriodSubjectDetailService();
	SubjectService subjectService = new SubjectService();
	PeriodService periodService = new PeriodService();
	/**
	 * It is used to send the object of class Subject and the lists of the standards and teachers to a JSP Page where
	 * user can add the details of the subject  
	 * @param model
	 *     used to send the subject model object and the lists of standards and teachers
	 * @return
	 *     JSP Page where user can add the subject details
	 */
    @RequestMapping(value = "/addPeriodSubjectDetail", method=RequestMethod.GET) 
    public String addPeriodSubjectDetail(ModelMap model) {
    	String message = null;
        model.addAttribute("PeriodSubjectDetail", new PeriodSubjectDetail());
        try {
        model.addAttribute("subjectList", subjectService.getSubjects());
        model.addAttribute("periodList", periodService.getPeriods());
        } catch (DatabaseException e) {
        }
        return "AddPeriodSubject";
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
    @RequestMapping(value = "/addPeriodSubject", method=RequestMethod.POST) 
    public ModelAndView addSubject(@ModelAttribute("PeriodSubjectDetail") PeriodSubjectDetail periodSubjectDetail) {
        String message = null;    
        try {                                                     
        	periodSubjectDetailService.addPeriodSubjectDetail(periodSubjectDetail);                                        
            message = "Period Details are added added successfully";            
        }  catch (DatabaseException ex) {        	
            message = ex.getMessage().toString(); 
            System.out.println(message);
        } 
        return new ModelAndView("AddPeriodSubject","addMessage", message);       
    }
}
