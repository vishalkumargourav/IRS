/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.rm;

import in.ezeon.domain.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VarunAg
 */
public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int i) throws SQLException {
       Student s=new Student();
       s.setScholarNumber(rs.getString("scholarNumber"));
       s.setFirstName(rs.getString("firstName"));
       s.setLastName(rs.getString("lastName"));
       s.setAlternatePhone(rs.getString("alternatePhone"));
       s.setEmail(rs.getString("email"));
       s.setGender(rs.getString("gender"));
       s.setLoginName(rs.getString("loginName"));
       s.setPassword(rs.getString("password"));
       s.setPhone(rs.getString("phone"));
       s.setSemester(rs.getInt("semester"));
       s.setStudentId(rs.getInt("studentId"));
       s.setlStatus(rs.getInt("lStatus"));
       s.setvStatus(rs.getInt("vStatus"));
       return s;
    }
    
}
