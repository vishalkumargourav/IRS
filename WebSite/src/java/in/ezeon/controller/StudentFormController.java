/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.controller;

import in.ezeon.dao.NotificationDao;
import in.ezeon.dao.QueryDaoImpl;
import in.ezeon.domain.Notification;
import in.ezeon.domain.Query;
import in.ezeon.domain.Student;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentFormController {

    @Autowired
    NotificationDao notDao;
    @Autowired
    QueryDaoImpl qdi;

    @RequestMapping("/homeStudent")
    public String getHomeStudentForm() {
        return "studentLoginSuccess";

    }

    @RequestMapping("/studentNotification")
    public ModelAndView getNotificationListForStudent() {
        List<Notification> n = new ArrayList<Notification>();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("studentNotification");
        try {
            n = notDao.findAll();
            mav.addObject("notificationList", n);
//            for (Notification no : n) {
//                System.out.println("''''''''" + no.getNotificationId());
//                System.out.println("........." + no.getDate());
//                System.out.println("");
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return mav;


    }

    @RequestMapping("studentPoll")
    public String getStudentPollPage() {
        return "studentPoll";
    }

    @RequestMapping("/StudentLoginPage")
    public String getLoginPageafterlogout(Model m) {
        Student s = new Student();
        m.addAttribute("err", "you are successfully logout");
        m.addAttribute("studentCommand", s);
        return "studentLogin";
    }
   
}
