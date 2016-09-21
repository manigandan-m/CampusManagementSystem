package com.i2i.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DatabaseException;
import com.i2i.service.PeriodSubjectDetailService;
import com.i2i.service.StandardService;
import com.i2i.service.SubjectService;
import com.i2i.service.TeacherService;

/**
 * Controller to perform add, delete, retrieve, retrieve all operations of time table periods
 * It is used to set views (JSP Pages) for the methods.
 * Assigns handlers (methods) to process the requests
 *   
 * @author Manigandan
 * 
 * @created 2016-09-12
 * 
 */
@Controller
public class PeriodSubjectDetailController {
    PeriodSubjectDetailService periodSubjectDetailService = new PeriodSubjectDetailService();
    StandardService standardService = new StandardService();
    SubjectService subjectService = new SubjectService();
    TeacherService teacherService = new TeacherService();
    
    /**
     * Redirects to the time table jsp page with the list of standards
     *   
     * @return
     *     JSP Page of time table
     */
    @RequestMapping("/TimeTable")
    public String timeTablePage(ModelMap model) {
        try {
            model.addAttribute("standards", standardService.getStandards());
            model.addAttribute("teachers", teacherService.getTeachers());
        } catch (DatabaseException e) {
            model.addAttribute("message", e.getMessage());   
        }
        return "TimeTable";
    }
    
    /**
     * Sends the standard id whose time table is to be retrieved and get the periods of timetable
     *   
     * @param standardId
     *     standard id whose time table is to be retrieved
     * @return
     *     JSP Page of standard time table
     */
    @RequestMapping(value = "/generateTimeTable", method=RequestMethod.GET) 
    public ModelAndView generateTimeTable(@RequestParam("standardId") int standardId) {
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("TimeTable");
        
        try {
            periodSubjectDetailService.generateTimeTable(standardId);            
        } catch (DatabaseException e) {
            modelView.addObject("message", e.getMessage());   
        }        
        return modelView;
    }

    /**
     * Sends the standard id whose time table is to be retrieved and get the periods of timetable
     *   
     * @param standardId
     *     standard id whose time table is to be retrieved
     * @return
     *     JSP Page of standard time table
     */
    @RequestMapping(value = "/standardTimeTable", method=RequestMethod.GET) 
    public ModelAndView displayStandardTimeTable(@RequestParam("standardId") int standardId) {               
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("StandardTimeTable");
        try {            
            modelView.addObject("periodSubjectDetails", periodSubjectDetailService.getPeriodSubjectDetailsByStandardId(standardId));
            modelView.addObject("subjects", standardService.getStandardById(standardId).getSubjects());
        } catch (DatabaseException e) {
            modelView.addObject("message", e.getMessage());            
        }
        return modelView;
    }

    /**
     * Sends the standard id whose time table is to be retrieved and get the periods of timetable
     *   
     * @param standardId
     *     standard id whose time table is to be retrieved
     * @param rollNumber
     *     rollNumber whose student jsp is to be retrieved    
     * @return
     *     JSP Page of student time table
     */
    @RequestMapping(value = "/studentTimeTable", method=RequestMethod.GET) 
    public ModelAndView displayStandardTimeTable(@RequestParam("standardId") int standardId, @RequestParam("rollNumber") int rollNumber) {
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("StudentTimeTable");
        try {          
            modelView.addObject("periodSubjectDetails", periodSubjectDetailService.getPeriodSubjectDetailsByStandardId(standardId)); 
            modelView.addObject("subjects", standardService.getStandardById(standardId).getSubjects());
            modelView.addObject("rollNumber",rollNumber);
        } catch (DatabaseException e) {
            modelView.addObject("message", e.getMessage());            
        }
        return modelView;
    }
    
    /**
     * Sends the teacher id whose time table is to be retrieved and get the periods of timetable
     *   
     * @param teacher
     *     teacher id whose time table is to be retrieved
     * @return
     *     JSP Page of teacher time table when admin login is used
     */
    @RequestMapping(value = "/teacherTimeTable", method=RequestMethod.GET) 
    public ModelAndView displayTeacherTimeTable(@RequestParam("teacherId") int teacherId) {               
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("TeacherTimeTable");
        try {          
            modelView.addObject("periodSubjectDetails", periodSubjectDetailService.getPeriodSubjectDetailsByTeacherId(teacherId)); 
            modelView.addObject("subject", subjectService.getSubjectByTeacherId(teacherId));
        } catch (DatabaseException e) {
            modelView.addObject("message", e.getMessage());            
        }
        return modelView;
    }

    /**
     * Sends the teacher id whose time table is to be retrieved and get the periods of timetable
     *   
     * @param teacherId
     *     teacher id whose time table is to be retrieved
     * @return
     *     JSP Page of teacher time table when teacher login is used
     */
    @RequestMapping(value = "/facultyTimeTable", method=RequestMethod.GET) 
    public ModelAndView displayFacultyTimeTable(@RequestParam("teacherId") int teacherId) {               
        ModelAndView modelView = new ModelAndView();  
        modelView.setViewName("FacultyTimeTable");
        try {          
            modelView.addObject("periodSubjectDetails", periodSubjectDetailService.getPeriodSubjectDetailsByTeacherId(teacherId)); 
            modelView.addObject("teacher", teacherService.getTeacherById(teacherId));
            modelView.addObject("subject", subjectService.getSubjectByTeacherId(teacherId));            
        } catch (DatabaseException e) {
            modelView.addObject("message", e.getMessage());            
        }
        return modelView;
    }    
}
