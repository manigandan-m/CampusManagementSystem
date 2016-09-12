package com.i2i.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import com.i2i.exception.DatabaseException;
import com.i2i.model.Address;
import com.i2i.model.Student;
import com.i2i.model.Teacher;
import com.i2i.model.User;
import com.i2i.service.AddressService;
import com.i2i.service.UserService;

/**
 * Controller to perform add, update, delete, retrieve, retrieve all operations using model class User
 * by invoking AddressService class methods.
 * It is used to set views (JSP Pages) for the methods.
 * Assigns handlers (methods) to process the requests
 *   
 * @author Zeeshan Ali
 * 
 * @created 2015-08-27
 * 
 */

@Controller
public class AddressController {
    UserService userService = new UserService();
    AddressService addressService = new AddressService();
   
    /**
     * The method gets the address details from the JSP page and passes it as an object of Address class
     * It gets the object of User class by passing the id of user in the UserService class method.
     * The id of the user is passed from the JSP Page. Depending on the role of the user, the user is redirected to the next JSP Page
     * 
     * @param address
     *     object of class Address that contains the address details
     * @param map
     *     object of ModelMap type. It is used to send the userId and the student model object or teacher model object depending on the tole of the user 
     * @return
     *     if the role of the user is teacher it returns the JSP Page where user can enter teacher details
     *     if the role of the user is student it returns the JSP Page where user can enter student details
     */
    @RequestMapping(value ="/addAddress", method=RequestMethod.POST)
    public String addAddress(@ModelAttribute("Address") Address address, ModelMap map) {          
        try {           
           int userId = address.getUser().getUserId();
            User user = userService.getUserById(userId);
            addressService.addAddress(address, user);
            map.addAttribute("userId", userId);
            if((user.getRole().getRoleName()).equals("student")) {
                map.addAttribute("Student", new Student());
                return "StudentInformation";
               
            } else if (user.getRole().getRoleName().equals("teacher")){
                map.addAttribute("Teacher", new Teacher());
                return "AddTeacher";
            }      
        }  catch (DatabaseException ex) {
            map.addAttribute("message", ex.getMessage().toString());   
        }
        return "Address"; 
    } 
   
    /**
     * It displays all the addresses by invoking the AddressService class method.
     * It sends the list of the address to the JSP Page by using ModelAndView object
     *  
     * @return
     *     returns the JSP Page where all the addresses are displayed
     */
    @RequestMapping(value = "/displayAddresses", method=RequestMethod.GET) 
    public ModelAndView displayStudents() {
    	try {                                                                         
            return new ModelAndView("DisplayAddresses","addresses", addressService.getAddresses());                                           
        } catch (DatabaseException e) {
              return new ModelAndView("DisplayAddresses","displayMessage", e.getMessage());                                                       
        } 
    }
    
    /**
     * It provides the page where the user can edit the address details. It calls the AddressService method 
     * to get the address object and passes it to the JSP Page by using adAttribute method
     *  
     * @param id
     *     id of address whose details has to be edited
     * @param model
     * @return 
     *     returns the JSP Page where user can edit the address details
     * @throws ServletException
     *     when a servlet related problem occurs.
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     */
    @RequestMapping(value = "/editAddressById", method = RequestMethod.GET)
    public String editAddressForm(@RequestParam("addressId") int id, ModelMap model) {
    	 try {
    		 model.addAttribute("Address", addressService.getAddressById(id));
             return "EditAddress";
    	 } catch (DatabaseException e) {
    		 model.addAttribute("Message", e.getMessage().toString());
    		 return "EditAddress";
    	 }
    }
    
    /**
     * <p>
     * Edits the address details by sending the address model object details to the assigned JSP page.
     * Invokes the AddressService method to update the changes.
     * </p>
     * 
     * @param address
     *     Object of Address class    
     * @param message
     *     Status message
     * @return EditAddress
     *     JSP Page for editing address details
     * @throws IOException
     *     if there is failed or interrupted input output operations.
     * @throws ServletException
     *     when a servlet related problem occurs.
     */
    @RequestMapping(value = "/editAddress", method = RequestMethod.POST)
    public String editAddress(@ModelAttribute("Address") Address address, ModelMap message) {  
        try {
        	addressService.editAddress(address);      
            message.addAttribute("Message", "Address Edited Successfully");
            return "EditAddress";
    	} catch (DatabaseException e) {
    		  message.addAttribute("Message", (e.getMessage().toString()));
    		  return "EditAddress";
    	}
    }
    
    /*
    private static boolean isNumber(String value) {
        try {
            Long.parseLong(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }*/
}
