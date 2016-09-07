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
    public ModelAndView deleteUser(@RequestParam("periodId") int periodId) {        
        ModelAndView modelView = new ModelAndView();
    	
    	modelView.setViewName("Period");
        modelView.addObject("Period", new Period());          
        try {                                                           
            periodService.removePeriod(periodId);
            modelView.addObject("deleteMessage", "Period Id " + periodId + " is deleted");                                   
        } catch (DatabaseException e) {
        	
        	modelView.addObject("deleteMessage", e.getMessage());                                    
        } 
        return modelView;         
    }
    
}