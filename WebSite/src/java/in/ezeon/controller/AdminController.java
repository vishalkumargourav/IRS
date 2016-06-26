/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.controller;

import in.ezeon.command.AdminCommand;
import in.ezeon.dao.NotificationDao;
import in.ezeon.dao.PollDAO;
import in.ezeon.dao.QueryDaoImpl;
import in.ezeon.dao.StudentDAO;
import in.ezeon.domain.AdminLogin;
import in.ezeon.domain.Notification;
import in.ezeon.domain.Poll;
import in.ezeon.domain.Query;
import in.ezeon.domain.Student;
import in.ezeon.service.AdminService;
import in.ezeon.service.LoginService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VarunAg
 */
@Controller
public class AdminController {

    @Autowired
    PollDAO pollDAO;
    @Autowired
    NotificationDao notDao;
    @Autowired
    LoginService loginService;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    AdminService adminService;
    @Autowired
    QueryDaoImpl qdi;

    @RequestMapping("/adminLogin")
    public String getAdminLogin(@ModelAttribute("adminCommand") AdminCommand adminCommand, ModelAndView mav, HttpSession session) {

        try {
            AdminLogin ac = loginService.authenticate(adminCommand.getUserName(), adminCommand.getPassword());
            session.setAttribute("admin", ac);

            return "loginSuccess";

        } catch (Exception ex) {
            ex.printStackTrace();
            return "redirect:/wrongAdmin.htm";
        }

    }

    @RequestMapping("/wrongAdmin")
    public ModelAndView getwelcomePage(@ModelAttribute("adminCommand") AdminCommand adminCommand) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("err", "LoginFailed,Wrong UswerName OR Password");
        mav.setViewName("welcomePage");
        return mav;

    }

    @RequestMapping("/confirmStudent")
    public ModelAndView confirmStudent(@RequestParam("studentId") Integer stdId, HttpSession session) {
        // System.out.println("............"+stdId);

        ModelAndView mav = new ModelAndView();

        try {
            adminService.confirmStudent(stdId);
            System.out.println("''''''''operation executed");
            mav.setViewName("redirect:/userList.htm");
            mav.addObject("err", "ScholarNUmber" + stdId + "is added");
            return mav;
        } catch (Exception ex) {
            ex.printStackTrace();
            mav.setViewName("redirect:/userList.htm");
            mav.addObject("err", "ScholarNUmber" + stdId + "is added");
            System.out.println(";;;;;;;;;something is fishy");
            return mav;
        }



    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") Integer stdId, HttpSession session) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("studentList");
        mav.addObject("err", "scholar Number" + stdId + "is deleted");

        try {
            studentDAO.delete(stdId);
            System.out.println("....data deleted successfully");
            mav.addObject("err", "scholar Number" + stdId + "is deleted");
            return "redirect:/userList.htm";
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("''''''something is fishy");
            return "redirect:/userList.htm";
        }

    }

    @RequestMapping("/saveNotification")
    public String saveNotification(@ModelAttribute("notification") Notification not, HttpSession session) {

        AdminLogin ad = (AdminLogin) session.getAttribute("admin");
        not.setAddedby(ad.getFirstName());
        not.setAdminId(ad.getAdminId());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("notification");

        try {
            notDao.save(not);
            mav.addObject("err", "Notification saved successfully");

        } catch (Exception ex) {
            ex.printStackTrace();
            //  mav.addObject("err","Notification does not saved successfully");
            System.out.println("data do not saved succesfully'");
        }

        return "redirect:/notification.htm";
    }

    @RequestMapping("/deleteNotification")
    public String deleteNotification(@RequestParam("notId") Integer notId) {
        System.out.println("..........." + notId);
        try {
            notDao.delete(notId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/notification.htm";
    }

    @RequestMapping("/savePoll")
    public String savePoll(@ModelAttribute("pollCommand") Poll p) {
        System.out.println("...." + p.getQuestion());
        System.out.println("...." + p.getOption1());
        System.out.println("...." + p.getOption2());
        System.out.println("...." + p.getOption3());
        System.out.println("...." + p.getOption4());
        System.out.println("...." + p.getStatus());
        System.out.println("...." + p.getStatusId());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("poll");
        try {
            pollDAO.save(p);
            System.out.println(".....data saved succesfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(".....data not saved");
        }
        return "redirect:/poll.htm";
    }

    @RequestMapping("/changePollStatus")
    public ModelAndView changePollStatus(@RequestParam("polId") Integer plId) {
        System.out.println("...." + plId);
        Poll p = new Poll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/poll.htm");
        try {
            p = pollDAO.findById(plId);
            adminService.changepollStatus(p);
            System.out.println("..we are getting poll...");
            System.out.println("............" + p.getPollId());
        } catch (Exception ex) {
            System.out.println("..we are  not getting poll...");
            ex.printStackTrace();
        }
        return mav;

    }

    @RequestMapping("/studentQuery")
    public ModelAndView goToStudentQuery(@ModelAttribute("qry") Query qry, HttpSession session) {
        ModelAndView mav;

        mav = new ModelAndView();
        AdminLogin admin = new AdminLogin();
        admin = (AdminLogin) session.getAttribute("admin");
        List<Query> q = new ArrayList<Query>();
        List<Query> queries = new ArrayList<Query>();
        mav.setViewName("studentQuery");
        try {
            q = qdi.findAll();
            mav.addObject("queryList", q);
        } catch (Exception e) {
            mav.addObject("queryList", null);
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("/updateQuery")
    public String goToUpdateQuery(@ModelAttribute("qry") Query qry, @RequestParam("qid") Integer qid, HttpSession session) {
        Query q1 = new Query();
        q1 = qdi.findById(qid);
        qry.setQuery(q1.getQuery());
        qry.setQueryId(qid);
        qry.setSubmitedBy(q1.getSubmitedBy());
        AdminLogin admin = new AdminLogin();
        try {
            admin = (AdminLogin) session.getAttribute("admin");
            qry.setAnsweredBy(admin.getAdminId());
            qdi.update(qry);
//            System.out.println("Query updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Query not updated");
        }
        return "studentQuery";
    }
}
