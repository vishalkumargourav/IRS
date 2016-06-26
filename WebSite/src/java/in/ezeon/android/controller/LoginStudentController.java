/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.android.controller;

import in.ezeon.dao.BaseNamedParameterJdbcTemplate;
import in.ezeon.dao.NotificationDao;
import in.ezeon.dao.QueryDaoImpl;
import in.ezeon.dao.StudentDAO;
import in.ezeon.domain.Notification;
import in.ezeon.domain.Query;
import in.ezeon.domain.Student;
import in.ezeon.rm.StudentRowMapper;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author personal
 */
@Controller
public class LoginStudentController extends BaseNamedParameterJdbcTemplate{

    @Autowired
    StudentDAO studentDAO;
    @Autowired
    NotificationDao notDao;
    @Autowired
    QueryDaoImpl qdi;

    @RequestMapping("/androidStudentLogin")
    public @ResponseBody
    Student goToStudentLogin(HttpServletRequest request, HttpServletResponse response) {
        Student s = new Student();
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        try {
            String sql="SELECT * FROM student WHERE loginName=:ln and password=:pass and lStatus=:lsts and vStatus=:vsts";
            MapSqlParameterSource param=new MapSqlParameterSource();
            param.addValue("ln", loginName);
            param.addValue("pass", password);
            param.addValue("lsts",1);
            param.addValue("vsts", 1);
            s=(Student)getNamedParameterJdbcTemplate().queryForObject(sql, param, new StudentRowMapper());
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/androidRegisterStudent")
    public void RegisterStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String scholarNumber = request.getParameter("scholarNumber");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String alternatePhone = request.getParameter("alternatePhone");
        String semester = request.getParameter("semester");
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        Student s = new Student();
        s.setScholarNumber(scholarNumber);
        s.setFirstName(firstName);
        s.setLastName(lastName);
        s.setGender(gender);
        s.setEmail(email);
        s.setPhone(phone);
        s.setAlternatePhone(alternatePhone);
        s.setSemester(Integer.parseInt(semester));
        s.setLoginName(loginName);
        s.setPassword(password);
        s.setlStatus(0);
        s.setvStatus(0);
        Writer out=response.getWriter();
        try {
            studentDAO.save(s);
            out.write("Student saved successfully");
        }catch(Exception e){
            e.printStackTrace();
            out.write("Data not saved please try again");
        }
    }
    @RequestMapping("/androidStudentNotification")
    public @ResponseBody List<Notification> getNotificationListForStudent() {
        List<Notification> n = new ArrayList<Notification>();
        try {
            n = notDao.findAll();
            return n;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @RequestMapping("/androidSaveQuery")
    public void saveQuery(HttpServletRequest request,HttpServletResponse response) throws IOException{
        Query q=new Query();
        q.setAnswer("not yet answered");
        q.setAnsweredBy(-1);
        q.setQuery(request.getParameter("query"));
        q.setSubmitedBy(Integer.parseInt(request.getParameter("submitedBy")));
//        System.out.println("answer="+q.getAnswer());
//        System.out.println("answeredBy="+q.getAnsweredBy());
//        System.out.println("query="+q.getQuery());
//        System.out.println("submitted by"+q.getSubmitedBy());
        Writer out=response.getWriter();
        try{
            qdi.save(q);
            out.write("Query submitted successfully");
        }catch(Exception e){
            e.printStackTrace();
            out.write("Query not submitted");
        }
    }
    @RequestMapping("/androidQueryList")
    public @ResponseBody List<Query> getQueryList() {
        List<Query> q = new ArrayList<Query>();
        try {
            q = qdi.findAll();
            return q;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
