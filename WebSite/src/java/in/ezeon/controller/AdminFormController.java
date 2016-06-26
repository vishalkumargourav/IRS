package in.ezeon.controller;
import in.ezeon.command.AdminCommand;
import in.ezeon.domain.Notification;
import in.ezeon.dao.NotificationDao;
import in.ezeon.dao.PollDAO;
import in.ezeon.domain.Poll;
import in.ezeon.domain.Student;
import in.ezeon.service.AdminService;
import in.ezeon.service.LoginService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AdminFormController {

    @Autowired
    PollDAO pollDAO;
    @Autowired
    NotificationDao notDao;
    @Autowired
    LoginService loginService;
    @Autowired
    AdminService adminService;
//Following 4 mapping are for adminwelcome page     
    @RequestMapping("/welcomeForm")
    public String getwelcomeForm(Model m,HttpSession session){
        AdminCommand adminCommand=new AdminCommand();
        m.addAttribute("adminCommand",adminCommand);
        return "welcomePage";
    }
        @RequestMapping("/aboutUs")
    public String getaboutUsPage()
    {
        return "about_us";
    }
        
    @RequestMapping("/help")
     public String gethelpPage()
    {
        return "help";
    }
           @RequestMapping("/welcomeStudentLogin")
    public String getLoginPage(Model m) {
        Student s = new Student();
        m.addAttribute("studentCommand", s);
        return "studentLogin";
    }
           
//These following are for after admin login menu
    @RequestMapping("/home")
    public String getHome()
    {
        
        return "loginSuccess";
    }
         @RequestMapping("/userList")
    public ModelAndView showStudentList(HttpSession session) {

        ModelAndView mav = new ModelAndView();
        List<Student> students = new ArrayList<Student>();
       
        try {
            students = adminService.getUserList();
            mav.addObject("students", students);
            mav.setViewName("studentList");
            return mav;
        } catch (Exception ex) {
            ex.printStackTrace();
            return mav;
        }

    }
   
       @RequestMapping("/notification")
    public ModelAndView getNotificationAdminForm(@ModelAttribute("notification") Notification not)
    {
       List<Notification> n=new ArrayList<Notification>();
       ModelAndView mav=new ModelAndView();
       mav.setViewName("notification");
       try{
                  n=notDao.findAll();
                  mav.addObject("notificationList", n);
       for(Notification no:n)
          {
              System.out.println("''''''''"+no.getNotificationId());
              System.out.println("........."+no.getDate());
              System.out.println("");
          }
       }catch(Exception ex)
       {
           ex.printStackTrace();
       }

         return mav;
    }
     @RequestMapping("/poll")
     public ModelAndView getPollPage(@ModelAttribute("pollCommand") Poll p)
     {
         
         List<Poll> ps=new ArrayList<Poll>();
         ModelAndView mav=new ModelAndView();
         mav.setViewName("poll");
         try
         {
             ps=pollDAO.findAll();
             System.out.println("get data");
             mav.addObject("polls", ps);
             for(Poll po:ps)
             {
                 
                 System.out.println("...."+po.getStatusId());
                 System.out.println("...."+po.getPollId());
                 System.out.println("......."+po.getStatus());
             }
         }catch(Exception ex)
         {
             System.out.println("not gate data");
             ex.printStackTrace();
         }
        return mav;
         
     }
     
       
       @RequestMapping("/logout")
    public ModelAndView adminlogout(@ModelAttribute("adminCommand") AdminCommand adminCommand)
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("welcomePage");
        mav.addObject("err", "You are Successfully Logout");
        return mav;
    }



     

}