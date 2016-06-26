package in.ezeon.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import in.ezeon.domain.Notification;
import in.ezeon.domain.Student;
import java.util.List;

/**
 *
 * @author VarunAg
 */

public interface NotificationDao {
    void save(Notification n);

    void update(Notification n );

    void delete(Notification n);

    void delete(Integer notificationId);

    Student findById(Integer notificationId);

    List<Notification> findAll();

    
    //List<Student> findbyProperty(String name, Object value);
    
}
