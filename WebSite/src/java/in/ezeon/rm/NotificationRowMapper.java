/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.rm;

import in.ezeon.domain.Notification;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.springframework.jdbc.core.RowMapper;

public class NotificationRowMapper implements RowMapper<Notification>{

    @Override
    public Notification mapRow(ResultSet rs, int i) throws SQLException {
        Notification n=new Notification();
        n.setSubject(rs.getString("subject"));
        n.setDescription(rs.getString("description"));
        java.util.Date date=rs.getDate("date");
        n.setDate(date);
        n.setAddedby(rs.getString("addedBy"));
        n.setAdminId(rs.getInt("adminId"));
        n.setNotificationId(rs.getInt("notificationId"));
        return n;
        
       
    }
    
    
    
}
