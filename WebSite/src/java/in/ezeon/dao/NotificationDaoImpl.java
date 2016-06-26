package in.ezeon.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import in.ezeon.domain.Notification;
import in.ezeon.domain.Student;
import in.ezeon.rm.NotificationRowMapper;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VarunAg
 */
@Repository
public class NotificationDaoImpl extends BaseNamedParameterJdbcTemplate implements NotificationDao{

    @Override
    public void save(Notification n) {
       String sql="INSERT INTO notification("
               + " subject "
               + " ,description "
               + " ,addedBy "
               + " ,adminId "
               + " ,date) "
               + " VALUES( "
               + " :sub "
               + " ,:des "
               + " ,:adby "
               + " ,:admnId "
               + " ,:date) ";
       
       Date d=new Date();
       java.sql.Date sqlDate=new java.sql.Date(d.getTime());
        MapSqlParameterSource param=new MapSqlParameterSource();
        param.addValue("sub",n.getSubject());
        param.addValue("des",n.getDescription());
         param.addValue("date",sqlDate);
         param.addValue("adby",n.getAddedby());
         param.addValue("admnId",n.getAdminId());
         KeyHolder kh=new GeneratedKeyHolder();
         getNamedParameterJdbcTemplate().update(sql, param, kh);
         n.setNotificationId(kh.getKey().intValue());
       }
    

    @Override
    public void update(Notification n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Notification n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer notificationId) {
        String sql="DELETE FROM notification WHERE notificationId=:id";
        MapSqlParameterSource param=new MapSqlParameterSource();
        param.addValue("id",notificationId);
        getNamedParameterJdbcTemplate().update(sql, param);
       
    }

    @Override
    public Student findById(Integer notificationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Notification> findAll() {
       String sql="SELECT * FROM notification ";
       MapSqlParameterSource param=new MapSqlParameterSource();
       return getNamedParameterJdbcTemplate().query(sql, param, new NotificationRowMapper());
    }

 
    
}
