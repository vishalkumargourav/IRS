/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.dao;

import in.ezeon.domain.Student;
import in.ezeon.rm.StudentRowMapper;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VarunAg
 */
@Repository
public class StudentDAOImpl extends BaseNamedParameterJdbcTemplate implements StudentDAO
{

    @Override
    public void save(Student s) {
        String sql="INSERT INTO student("
                + " scholarNumber "
                + " ,firstName "
                + " ,lastName "
                + " ,gender "
                + " ,email "
                + " ,phone "
                + " ,alternatePhone "
                + " ,semester"
                + " ,loginName"
                + " ,password"
                + " ,lStatus"
                + " ,vStatus)"
                + " values("
                + " :sch"
                + " ,:fName"
                + " ,:lName"
                + " ,:gender"
                + " ,:email"
                + " ,:phn"
                + " ,:alphone"
                + " ,:sem"
                + " ,:lgn"
                + " ,:psw"
                + " ,:ls"
                + " ,:vs)";
        MapSqlParameterSource param=new MapSqlParameterSource();
        param.addValue("sch",s.getScholarNumber());
        param.addValue("fName",s.getFirstName());
        param.addValue("lName",s.getLastName());
        param.addValue("gender",s.getGender());
        param.addValue("email", s.getEmail());
        param.addValue("phn",s.getPhone());
        param.addValue("alphone", s.getAlternatePhone());
        param.addValue("sem", s.getSemester());
        param.addValue("lgn", s.getLoginName());
        param.addValue("psw", s.getPassword());
        param.addValue("ls",s.getlStatus());
        param.addValue("vs",s.getvStatus());
        getNamedParameterJdbcTemplate().update(sql, param);
       
    }

    @Override
    public void update(Student s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Student s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer studentId) {
         String sql = "DELETE FROM student WHERE studentId=:sr";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("sr", studentId);
         getNamedParameterJdbcTemplate().update(sql, param);
    }

    @Override
    public Student findById(String userName,String password) {

        String sql="select * from student where loginName=:lgn AND password=:psw";
        MapSqlParameterSource param=new MapSqlParameterSource();
        param.addValue("lgn", userName);
        param.addValue("psw", password);
        return getNamedParameterJdbcTemplate().queryForObject(sql, param, new StudentRowMapper());
    }

    @Override
    public List<Student> findAll() {
        
        String sql="select * from student";
        MapSqlParameterSource param=new MapSqlParameterSource();
        return getNamedParameterJdbcTemplate().query(sql, param, new StudentRowMapper());
                
       }

    @Override
    public List<Student> findbyProperty(String name, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
