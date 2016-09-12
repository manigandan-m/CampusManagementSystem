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
            model.addAttribute("Standard", new Standard());	
            model.addAttribute("teachers",teacherService.getTeachers());
            return "Standard";
		}
		catch (DatabaseException e) {
			String message = e.getMessage().toString();
			model.addAttribute("addMessage", message);
			return "Standard";
		}
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
        String message = null;  

        try {  
        	
            standardService.addStandard(standard);                                        
            message = "Standard is added successfully";            
        }  catch (DatabaseException ex) {        	
            message = ex.getMessage().toString();                         
        } 
        return new ModelAndView("Standard","addMessage", message);       
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

            return new ModelAndView("DisplayStandards","standards", standards);                                           
        } catch (DatabaseException e) {
        	
            return new ModelAndView("DisplayStandards","displayMessage", e.getMessage());                                                       
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
    
    /**
     * Edits the details of the standard using it's id
     * 
     * @param id
     *     id of standard entered by the user
     * @param model
     *     ModelMap object to send the standard object to the JSP page
     * @return EditStandard
     *     JSP Page where user can make changes to the various attributes of the standard
     * @throws ServletException
     *     when a servlet related problem occurs.
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     */
    /*@RequestMapping(value = "/editStandardById", method = RequestMethod.POST)
    public String editStandardForm(@RequestParam("id") String id, ModelMap model) throws ServletException, IOException {
    	 try {
    		 //checks if the standard id is number
    		 if (!isNumber(id)) {
    			 model.addAttribute("Message", "ID must be a number");
    			 return "EditStandardById";
    		 }
             model.addAttribute("Standard", standardService.getStandardById(Integer.parseInt(id)));
             return "EditStandard";
    	 } catch (DatabaseException e) {
    		 model.addAttribute("Message", e.getMessage().toString());
    		 return "EditStandard";
    	 }
    }
    
    /**
     * <p>
     * Edits the standard details by sending the standard model object details to the assigned JSP page.
     * Invokes the StandardService method to update the changes.
     * </p>
     * 
     * @param standard
     *     Object of Standard class    
     * @param message
     *     Status message
     * @return EditStandard
     *     JSP Page for editing standard details
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     * @throws ServletException
     *     when a servlet related problem occurs.
     */
    /*@RequestMapping(value = "/editStandard", method = RequestMethod.POST)
    public String editStandard(@ModelAttribute("Standard") Standard standard, ModelMap message
                            ) throws IOException, ServletException {  
        try {
        	standardService.editStandard(standard);      
            message.addAttribute("Message", "Standard Edited Successfully");
            return "EditStandard";
    	} catch (DatabaseException e) {
    		  message.addAttribute("Message", (e.getMessage().toString()));
    		  return "EditStandard";
    	}
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
