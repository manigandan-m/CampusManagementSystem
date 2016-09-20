package com.i2i.controller;

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
import com.i2i.model.Subject;

/**
 * Controller to perform add, update, delete, retrieve, retrieve all operations using standard
 * by invoking StandardService class methods.
 * It is used to set views (JSP Pages) for the methods.
 * Assigns handlers (methods) to process the requests
 *   
 * @author Manigandan
 * 
 * @created 2016-09-08
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
     *     used to send the standard and the list of teachers
     * @return
     *     returns the JSP Page where details of the standard can be entered
     */
    @RequestMapping(value = "/Standard", method=RequestMethod.GET) 
    public String viewStandards(ModelMap model) {
        try {       
            model.addAttribute("standards", standardService.getStandards());           
        } catch (DatabaseException e) {
            model.addAttribute("displayMessage", e.getMessage());                                                                  
        } 
        return "RetrieveStandards";
    }  
    
    /**
     * Returns to the JSP Page with a list of subjects
     * 
     * @param model
     *     It add the the object of class Standard to the JSP Page using addAtribute method
     * @return
     *     return the add standard jsp page  
     */
    @RequestMapping(value = "/AddStandard", method=RequestMethod.GET) 
    public String newStandard(ModelMap model) {
        Standard standard = new Standard();
        standard.addSubject(new Subject());
        standard.addSubject(new Subject());
        standard.addSubject(new Subject());
        standard.addSubject(new Subject());
        standard.addSubject(new Subject());
        model.addAttribute("Standard", standard);
        return "AddStandard";
    }  
    
    /**
     * Gets the details of the standard from JSP Page
     * and invokes the StandardService method to add the standard details
     * 
     * @param standard
     *     grade in which group of students study
     * @return
     *    returns the add standard jsp page
     */
    @RequestMapping(value = "/addStandard", method=RequestMethod.POST) 
        public ModelAndView addStandard(@ModelAttribute("Standard") Standard standard) {
        ModelAndView modelView = new ModelAndView(); 
        modelView.setViewName("AddStandard");
        try {   
            try {                                                                         
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
        modelView.setViewName("RetrieveStandards");
        modelView.addObject("RetrieveStandards", new Standard());          
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
     * Standard to the JSP Page where the standard details can be viewed
     *   
     * @param standardId
     *     id of the standard whose details have to be viewed
     * @return
     *     JSP Page where standard details can be viewed
     */
    @RequestMapping(value = "/searchStandard", method=RequestMethod.GET)  
    public ModelAndView searchStandard(@RequestParam("standardId") int standardId) {                
        ModelAndView modelView = new ModelAndView();        
        modelView.setViewName("RetrieveStandards");
        modelView.addObject("Standard", new Standard());
        try {           
            modelView.addObject("searchStandard", standardService.getStandardById(standardId));               
        } catch (DatabaseException e) {            
            modelView.addObject("searchMessage", e.getMessage());             
        }
        return modelView; 
    }
    
    /**
     * <p>
     * JSP Page where admin can assign a class teacher for a standard 
     * Sends the list of teachers by invoking the class TeacherService method and the standard  
     * to which class teacher should be assigned
     * </p>
     *  
     * @param standardId
     *     ID of standard
     * @return
     *     JSP Page where admin can assign the class coordinator to a class
     */
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
    
    /**
     * Assigns a class coordinator to a standard by invoking the StandardService class method and passing the Standard class object 
     * @param standard
     *     grade in which a group of students study
     * @return
     *     returns the edit coordinator jsp page   
     */
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
}
