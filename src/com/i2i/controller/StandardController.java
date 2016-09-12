package com.i2i.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Standard;
import com.i2i.model.Teacher;
import com.i2i.service.StandardService;
import com.i2i.service.TeacherService;

/**
 * Controller to perform add, update, delete, retrieve, retrieve all operations using model class Standard
 * by invoking StandardService class methods.
 * It is used to set views (JSP Pages) for the methods.
 * Assigns handlers (methods) to process the requests
 *   
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 * 
 */
@Controller
public class StandardController {
	StandardService standardService = new StandardService();
	TeacherService teacherService = new TeacherService();
    	
    /**
	 * Sends the object of class Standard and the list of teachers by invoking
	 * the TeacherService method to the JSP Page
	 * 
	 * @param model
	 *     used to send the standard model object and the list of teachers using addAttribute method
	 * @return
	 *     returns the JSP Page where details of the standard can be entered
	 */
	@RequestMapping(value = "/Standard", method=RequestMethod.GET) 
    public String addStandard(ModelMap model) {
	    
	    try {       
			
		    List<Standard> standards = standardService.getStandards();
            model.addAttribute("standards", standardService.getStandards());           
        } catch (DatabaseException e) {
      	    model.addAttribute("displayMessage", e.getMessage());                                                                  
        } 
		return "Standard";
    }  
	
	@RequestMapping(value = "/AddStandard", method=RequestMethod.GET) 
    public String newStandard(ModelMap model) {
	    model.addAttribute("Standard", new Standard());	 
		return "AddStandard";
    }  
    /**
	 * Gets the details of the standard from JSP Page as an object of standard class
	 * and invokes the StandardService method to add the add the standard details
	 * 
	 * @param standard
	 *     object of Standard class
	 * @return
	 */
	@RequestMapping(value = "/addStandard", method=RequestMethod.POST) 
        public ModelAndView addStandard(@ModelAttribute("Standard") Standard standard) {
        
        ModelAndView modelView = new ModelAndView(); 
        modelView.setViewName("AddStandard");
        
        try {   
        	try {                                                                         
                List<Standard> standards = standardService.getStandards();

                modelView.addObject("standards", standardService.getStandards());                                          
            } catch (DatabaseException e) {
            	modelView.addObject("displayMessage", e.getMessage());                                                                      
            }        	
        	standardService.addStandard(standard);
        	modelView.addObject("addMessage", "Standard is added successfully");  
        	
        }  catch (DatabaseException ex) {  
        	modelView.addObject("addMessage", ex.getMessage().toString());                                    
        } 
        return modelView;       
    }

    /**
     * It displays all the standards by invoking the StandardService class method.
     * It sends the list of the standards to the JSP Page by using ModelAndView object
     *  
     * @return
     *     returns the JSP Page where all the standards are displayed
     */
    public ModelAndView displayStandards() {
    	
        try {                                                                         
            List<Standard> standards = standardService.getStandards();
            return new ModelAndView("Standard","standards", standards);                                           
        } catch (DatabaseException e) {        	
            return new ModelAndView("Standard","displayMessage", e.getMessage());                                                       
        } 
    }
    
    /**
     * Deletes the standard record by passing the id of the standard
     * 
     * @param standardId
     *     id of the standard whose record has to be deleted
     * @return
     *     JSP Page where the user is redirected
     */
    @RequestMapping(value = "/deleteStandard", method=RequestMethod.GET) 
    public ModelAndView deleteStandard(@RequestParam("standardId") int standardId) {        
        ModelAndView modelView = new ModelAndView();
    	
    	modelView.setViewName("Standard");
        modelView.addObject("Standard", new Standard());          
        try {                                                           
            standardService.removeStandardById(standardId);
            modelView.addObject("deleteMessage", "Standard Id " + standardId + " is deleted");                                   
        } catch (DatabaseException e) {
        	
        	modelView.addObject("deleteMessage", e.getMessage());                                    
        } 
        return modelView;         
    }
    
    /**
     * Used to find the details of a standard by getting the standardId. It passes
     * an object of class Standard to the JSP Page where the subject details can be viewed
     *   
     * @param standardId
     *     id of the standard
     * @return
     *     JSP Page where standard details can be viewed
     */
    @RequestMapping(value = "/searchStandard", method=RequestMethod.GET)  
    public ModelAndView searchStandard(@RequestParam("standardId") int standardId) {                
        ModelAndView modelView = new ModelAndView();
        
        modelView.setViewName("Standard");
        modelView.addObject("Standard", new Standard());
        try {       	
        	modelView.addObject("searchStandard", standardService.getStandardById(standardId));        	                                          
        } catch (DatabaseException e) {        	
        	modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    }
    
    @RequestMapping(value = "/Coordinator", method=RequestMethod.GET) 
    public ModelAndView Coordinator(@RequestParam("standardId") int standardId) {        
        ModelAndView modelView = new ModelAndView();    	  	
        modelView.setViewName("EditCoordinator"); 
        try {  
        	modelView.addObject("teachers", teacherService.getTeachers());
        	modelView.addObject("Standard", standardService.getStandardById(standardId));            	     	                                          
        } catch (DatabaseException e) {        	
           	modelView.addObject("message", e.getMessage());             
        }
        return modelView;         
    }    
    
    @RequestMapping(value = "/editCoordinator", method=RequestMethod.POST) 
    public ModelAndView assignCoordinator(@ModelAttribute("Standard") Standard standard) {        
        ModelAndView modelView = new ModelAndView();    	  	
                  
        modelView.setViewName("EditCoordinator"); 
        try {  
            standardService.editStandard(standard);      	                                          
        } catch (DatabaseException e) {        	
           	modelView.addObject("message", e.getMessage());             
        }                                             
        return modelView;         
    }  

    /**
     * Checks if the given input is a number
     *  
     * @param value
     *     the input given by the user
     * @return
     */
    /*private static boolean isNumber(String value) {
        try {
            Long.parseLong(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }*/
        
   
}