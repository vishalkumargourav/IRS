/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.rm;

import in.ezeon.dao.Semester;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VarunAg
 */
public class SemesterRowMapper implements RowMapper<Semester>{

    @Override
    public Semester mapRow(ResultSet rs, int i) throws SQLException {
        Semester s=new Semester();
        s.setSemesterId(rs.getInt("semesterId"));
        s.setSem(rs.getInt("sem"));
        return s;
    }
    
}
