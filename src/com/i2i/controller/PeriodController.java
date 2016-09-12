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
import com.i2i.service.PeriodService;
import com.i2i.model.Period;

/**
 * Controller to perform add, update, delete, retrieve, retrieve all operations using model class Period
 * by invoking PeriodService class methods.
 * It is used to set views (JSP Pages) for the methods.
 * Assigns handlers (methods) to process the requests
 *   
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 * 
 */

@Controller
public class PeriodController {
    PeriodService periodService = new PeriodService();
    
    @RequestMapping("/Period")
    public String periodOperation(){
    	return "Period";
    }
    
    @RequestMapping(value = "/AddPeriod", method=RequestMethod.GET) 
    public String addUser(ModelMap model) {
    	model.addAttribute("Period", new Period());	 
        return "AddPeriod";
    }
    
    @RequestMapping(value = "/addPeriod", method=RequestMethod.POST) 
    public ModelAndView addPeriod(@ModelAttribute("Period") Period period) {
        String message = null;    

        try {                                                     
            periodService.addPeriod(period);                                        
            message = "User is added successfully";            
        }  catch (DatabaseException ex) {        	
            message = ex.getMessage().toString();                         
        } 
        return new ModelAndView("AddPeriod","addMessage", message);       
    }
    
    @RequestMapping(value = "/displayPeriods", method=RequestMethod.GET) 
    public ModelAndView displayPeriods() {
    	
        try {                                                                         
            List<Period> periods = periodService.getPeriods();
            return new ModelAndView("DisplayPeriods","periods", periods);                                           
        } catch (DatabaseException e) {
        	return new ModelAndView("DisplayPeriods","displayMessage", e.getMessage());                                                       
        } 
    }
    
    @RequestMapping(value = "/deletePeriod", method=RequestMethod.GET) 
    public ModelAndView deletePeriodById(@RequestParam("periodId") int periodId) {        
        ModelAndView modelView = new ModelAndView();
    	
    	modelView.setViewName("Period");
        modelView.addObject("Period", new Period());          
        try {                                                           
            periodService.removePeriodById(periodId);
            modelView.addObject("deleteMessage", "Period Id " + periodId + " is deleted");                                   
        } catch (DatabaseException e) {
        	
        	modelView.addObject("deleteMessage", e.getMessage());                                    
        } 
        return modelView;         
    }
    
    /**
     * Edits the details of the period using it's id
     * 
     * @param id
     *     id of period entered by the user
     * @param model
     *     ModelMap object to send the period object to the JSP page
     * @return EditPeriod
     *     JSP Page where user can make changes to the various attributes of the period
     * @throws ServletException
     *     when a servlet related problem occurs.
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     */
    /*@RequestMapping(value = "/editPeriodById", method = RequestMethod.POST)
    public String editPeriodForm(@RequestParam("id") String id, ModelMap model) throws ServletException, IOException {
    	 try {
    		 //checks if the period id is number
    		 if (!isNumber(id)) {
    			 model.addAttribute("Message", "ID must be a number");
    			 return "EditPeriodById";
    		 }
             model.addAttribute("Period", periodService.getPeriodById(Integer.parseInt(id)));
             return "EditPeriod";
    	 } catch (DatabaseException e) {
    		 model.addAttribute("Message", e.getMessage().toString());
    		 return "EditPeriod";
    	 }
    }
    
    /**
     * <p>
     * Edits the period details by sending the period model object details to the assigned JSP page.
     * Invokes the PeriodService method to update the changes.
     * </p>
     * 
     * @param period
     *     Object of Period class    
     * @param message
     *     Status message
     * @return EditPeriod
     *     JSP Page for editing period details
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     * @throws ServletException
     *     when a servlet related problem occurs.
     */
    /*@RequestMapping(value = "/editPeriod", method = RequestMethod.POST)
    public String editPeriod(@ModelAttribute("Period") Period period, ModelMap message
                            ) throws IOException, ServletException {  
        try {
        	periodService.editPeriod(period);      
            message.addAttribute("Message", "Period Edited Successfully");
            return "EditPeriod";
    	} catch (DatabaseException e) {
    		  message.addAttribute("Message", (e.getMessage().toString()));
    		  return "EditPeriod";
    	}
    }
    
    private static boolean isNumber(String value) {
        try {
            Long.parseLong(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }*/
}