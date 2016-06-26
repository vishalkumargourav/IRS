/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.service;

import in.ezeon.dao.BaseNamedParameterJdbcTemplate;
import in.ezeon.domain.Poll;
import in.ezeon.domain.Student;
import in.ezeon.rm.StudentRowMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends BaseNamedParameterJdbcTemplate{
    
    public List<Student> getUserList()
    {
         String sql = "SELECT * FROM student";
        List<Student> students = new ArrayList<Student>();
        MapSqlParameterSource param = new MapSqlParameterSource();
        return getNamedParameterJdbcTemplate().query(sql, param, new StudentRowMapper());
    }
    public void confirmStudent(Integer studentId)
    {
        String sql = "UPDATE student SET vStatus=" + 1 + ",lStatus=" + 1 + " WHERE studentId=:sr";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("sr", studentId);
        getNamedParameterJdbcTemplate().update(sql, param);
    }
    public void changepollStatus(Poll p)
    {
        String sql="UPDATE poll SET status=:sts WHERE pollId=:id";
        MapSqlParameterSource param=new MapSqlParameterSource();
        if(p.getStatus().equals("Open"))
           param.addValue("sts","Close");
        else
            param.addValue("sts","Open");
        param.addValue("id",p.getPollId() );
        getNamedParameterJdbcTemplate().update(sql, param);;
    }
}
