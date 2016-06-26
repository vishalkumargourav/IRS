/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.controller;

import in.ezeon.domain.Student;
import in.ezeon.dao.BaseNamedParameterJdbcTemplate;
import in.ezeon.dao.Semester;
import in.ezeon.dao.StudentDAO;
import in.ezeon.service.LoginService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentController extends BaseNamedParameterJdbcTemplate {

    @Autowired
    StudentDAO studentDAO;
    @Autowired
    LoginService loginService;

    @RequestMapping("/welcomeStudent")
    public String getregisterForm(Model m, HttpSession session) {
        Student s = new Student();
        m.addAttribute("studentCommand", s);
        return "studentRegister";
    }

    @RequestMapping("/studentRegister")
    public String getStudentInfo(@ModelAttribute("studentCommand") Student s, ModelAndView mav) {
        s.setlStatus(0);
        s.setvStatus(0);
        System.out.println("........." + s.getScholarNumber());
        System.out.println("......." + s.getFirstName());
        System.out.println("......." + s.getLastName());
        System.out.println("......." + s.getGender());
        System.out.println("......." + s.getPassword());
        System.out.println(".........." + s.getEmail());
        System.out.println(".........." + s.getLoginName());
        System.out.println(".........." + s.getSemester());
        System.out.println(".........." + s.getAlternatePhone());
        System.out.println(".........." + s.getlStatus());
        System.out.println(".........." + s.getvStatus());
        System.out.println(".........." + s.getPhone());



        try {
            studentDAO.save(s);
            System.out.println(".....data saved succesfulyy......");
            mav.addObject("err", "Your Data saved successfully");
            mav.setViewName("studentLogin");
            return "redirect:/welcomeStudentLogin.htm";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(".............Data do not saved successfully");
            return "redirect:/welcomeStudent.htm";
        }


    }




    @RequestMapping("/studentLogin")
    public String getStudentLoginInfo(@ModelAttribute("studentCommand") Student s, Model m, HttpSession session) {
        Student s1 = new Student();
        System.out.println("''''''''''''" + s.getLoginName());
        System.out.println("..........." + s.getPassword());
        m.addAttribute("loginName", s.getLoginName());
        m.addAttribute("password", s.getPassword());
        try {

            s1 = studentDAO.findById(s.getLoginName(), s.getPassword());
            System.out.println("..........." + s1.getFirstName());
            System.out.println("........" + s1.getLastName());
            Integer vs = s1.getvStatus();
            Integer ls = s1.getlStatus();
            if (vs == 1 && ls == 1){ 
                session.setAttribute("students",s1);
                    return "studentLoginSuccess";
            } else {
                return "redirect:/wrongStudentLogin.htm";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return "redirect:/wrongStudentLogin.htm";
        }

    }

    @RequestMapping("/wrongStudentLogin")
    public ModelAndView wrongstudentlogin(@ModelAttribute("studentCommand") Student s, ModelAndView mav) {
        mav.addObject("loginName", s.getLoginName());
        mav.addObject("password", s.getPassword());
        mav.addObject("err", "sorry your login failed");
        mav.setViewName("studentLogin");
        return mav;
    }



@ModelAttribute("semesterList")
public List<Semester> getSemesterList()
{
    return loginService.getSem();
}


}
